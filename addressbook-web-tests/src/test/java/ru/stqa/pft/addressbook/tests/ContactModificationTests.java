package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactModifitionData;

public class ContactModificationTests extends TestBase{

  @Test
   public void testContactModification(){
    app.contactHelper().selectContact();
    app.contactHelper().initModification();
    app.contactHelper().modificationContactForm(new ContactModifitionData("Michael", "updateTest", "Jackson", "sini", "upTitle", "upCompani", "upAddress", "updomtelefon", "upmobtelefon", "upworktelefon", "upfax", "upemail1", "upemail2", "upemail3", "sinicbob.github.io", "7", "September", "1990", "14", "June", "1990", "upAddressx2", "uphomeAddress", "update"));
    app.contactHelper().submitContactModification();
    app.contactHelper().gotoHomePage();
  }
}
