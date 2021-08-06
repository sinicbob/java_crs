package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;


public class ContactModificationTests extends TestBase{

  @Test (enabled = false)
   public void testContactModification(){
    if(!app.contactHelper().isThereAContact()){
      app.contactHelper().createContact(new ContactData("Daniil", "test", "Vladimirov", "sini", "newTitle", "newCompani", "newAddress", "domtelefon", "mobtelefon", "worktelefon", "fax", "email1", "email2", "email3", "sinicbob.github.io", "7", "September", "1990", "14", "June", "1990","test1", "newAddressx2", "homeAddress", "lol"),true);
    }
    List<ContactData> before = app.contactHelper().getContactList();
    app.contactHelper().selectContact(before.size() - 1);
    app.contactHelper().initModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Michael", "test", "Jackson", "jack", "newTitle", "newCompani", "newAddress", "domtelefon", "mobtelefon", "worktelefon", "fax", "email1", "email2", "email3", "sinicbob.github.io", "7", "September", "1990", "14", "June", "1990",null, "newAddressx2", "homeAddress", "lol");
    app.contactHelper().fillContactForm(contact,false);
    app.contactHelper().submitContactModification();
    app.contactHelper().gotoHomePage();
    List<ContactData> after = app.contactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }
}
