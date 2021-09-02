package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class RefreshPassword extends TestBase{
  @BeforeMethod
  public void startMailServer(){
    app.mail().start();
  }

  @Test
  public void testRefreshPassword() throws MessagingException, IOException {
    app.refresh().login(app.getProperty("web.adminLogin"));
    app.refresh().password(app.getProperty("web.adminPassword"));
    app.refresh().takeUser("user1630445582947");
    String email = app.refresh().userEmail();
    String newPassword = "password1";
    app.refresh().resetPass();
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 60000);
    String confirmationLink = findConfirmationLink(mailMessages,email);
    app.refresh().finish(confirmationLink, newPassword);
  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }
}
