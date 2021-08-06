package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test (enabled = false)
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoContactHomePage();
    if(!app.contactHelper().isThereAContact()){
      app.contactHelper().createContact(new ContactData("Daniil", "test", "Vladimirov", "sini", "newTitle", "newCompani", "newAddress", "domtelefon", "mobtelefon", "worktelefon", "fax", "email1", "email2", "email3", "sinicbob.github.io", "7", "September", "1990", "14", "June", "1990","test1", "newAddressx2", "homeAddress", "lol"),true);
    }
    List<ContactData> before = app.contactHelper().getContactList();
    app.contactHelper().selectContact(before.size() - 1);
    app.contactHelper().deleteSelectedContact();
    Alert alert = app.wd.switchTo().alert();
    alert.accept();
    app.getNavigationHelper().gotoContactHomePage();
    List<ContactData> after = app.contactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before,after);
  }
}
