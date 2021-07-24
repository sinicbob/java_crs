package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoContactHomePage();
    if(!app.contactHelper().isThereAContact()){
      app.contactHelper().createContact(new ContactData("Daniil", "test", "Vladimirov", "sini", "newTitle", "newCompani", "newAddress", "domtelefon", "mobtelefon", "worktelefon", "fax", "email1", "email2", "email3", "sinicbob.github.io", "7", "September", "1990", "14", "June", "1990","test1", "newAddressx2", "homeAddress", "lol"),true);
    }
    app.contactHelper().selectContact();
    app.contactHelper().deleteSelectedContact();
    Alert alert = app.wd.switchTo().alert();
    alert.accept();
  }
}
