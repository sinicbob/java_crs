package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void preconditions(){
    if(app.db().contacts().size() == 0){
      app.contact().create(new ContactData().setFirstName("Daniil").setMiddleName("test").setLastName("Vladimirov").setNickname("sini").setPhoto(new File("src/test/resources/foto.png")).setTitle("test").setHomeNumber("111").setMobileNumber("222").setWorkNumber("333").setBday("13").setBmonth("March").setAday("14").setAmonth("March").setGroupname("test1"),true);
    }
  }

  @Test
   public void testContactModification(){
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .setId(modifiedContact.getId()).setFirstName("Michael").setLastName("test").setMiddleName("Jackson").setNickname("sini").setPhoto(new File("src/test/resources/foto.png")).setTitle("test").setBday("13").setBmonth("March").setAday("14").setAmonth("March");
    app.contact().modify(contact);
    Contacts after = app.db().contacts();
    assertThat(after.size(),equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }
}
