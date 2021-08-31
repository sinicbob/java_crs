package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl")+ "/signup_page.php");
    type(By.name("username"),username);
    type(By.name("email"),email);
    click(By.cssSelector("input[class=\"width-40 pull-right btn btn-success btn-inverse bigger-110\"]"));
  }

  public void finish(String confirmationLink,String user, String password) {
    wd.get(confirmationLink);
    type(By.name("realname"),user);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("button[class=\"width-100 width-40 pull-right btn btn-success btn-inverse bigger-110\"]"));
  }
}
