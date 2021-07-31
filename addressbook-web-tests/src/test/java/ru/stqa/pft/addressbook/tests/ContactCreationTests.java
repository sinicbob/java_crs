package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.contactHelper().getContactList();
    app.getNavigationHelper().gotoContactPage();
    ContactData contact = new ContactData("Daniil", "test", "Vladimirov", "sini", "newTitle", "newCompani", "newAddress", "domtelefon", "mobtelefon", "worktelefon", "fax", "email1", "email2", "email3", "sinicbob.github.io", "7", "September", "1990", "14", "June", "1990","test1", "newAddressx2", "homeAddress", "lol");
    app.contactHelper().createContact(contact,true);
    List<ContactData> after = app.contactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() + 1);


    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);


  }

}
