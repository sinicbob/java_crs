package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactModificationTests extends TestBase{

  @Test
   public void testContactModification(){
    if(!app.contactHelper().isThereAContact()){
      app.contactHelper().createContact(new ContactData("Daniil", "test", "Vladimirov", "sini", "newTitle", "newCompani", "newAddress", "domtelefon", "mobtelefon", "worktelefon", "fax", "email1", "email2", "email3", "sinicbob.github.io", "7", "September", "1990", "14", "June", "1990","test1", "newAddressx2", "homeAddress", "lol"),true);
    }
    app.contactHelper().selectContact();
    app.contactHelper().initModification();
    app.contactHelper().fillContactForm(new ContactData("Michael", "test", "Jackson", "jack", "newTitle", "newCompani", "newAddress", "domtelefon", "mobtelefon", "worktelefon", "fax", "email1", "email2", "email3", "sinicbob.github.io", "7", "September", "1990", "14", "June", "1990",null, "newAddressx2", "homeAddress", "lol"),false);
    app.contactHelper().submitContactModification();
    app.contactHelper().gotoHomePage();
  }
}
