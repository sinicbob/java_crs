package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class RefreshPasswordHelper extends HelperBase {

  public RefreshPasswordHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }

  public void login(String username) {
    wd.get(app.getProperty("web.baseUrl")+ "/login_page.php");
    type(By.name("username"),username);
    click(By.cssSelector("input[class=\"width-40 pull-right btn btn-success btn-inverse bigger-110\"]"));
  }
  public void password(String password) {
    type(By.name("password"),password);
    click(By.cssSelector("input[class=\"width-40 pull-right btn btn-success btn-inverse bigger-110\"]"));
    wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
  }

  public void takeUser(String user){
    click(By.xpath(String.format("*//a[text()=\"%s\"]",user)));
  }

  public String userEmail() {
    String email = "";
    return email = wd.findElement(By.name("email")).getAttribute("value");
  }

  public void resetPass(){
    click(By.cssSelector("input[class=\"btn btn-primary btn-white btn-round\"]"));
  }

  public void finish(String confirmationLink, String newPassword) {
    wd.get(confirmationLink);
  }
}
