package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.contactHelper().selectContact();
    app.contactHelper().deleteSelectedContact();
    Alert alert = app.wd.switchTo().alert();
    alert.accept();
  }
}
