package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteGroup extends TestBase{

  @BeforeMethod
  public void preconditions(){
    if(app.db().contacts().size() == 0){
      app.contact().create(new ContactData().setFirstName("Daniil").setMiddleName("test").setLastName("Vladimirov").setNickname("sini").setPhoto(new File("src/test/resources/foto.png")).setTitle("test").setHomeNumber("111").setMobileNumber("222").setWorkNumber("333").setBday("13").setBmonth("March").setAday("14").setAmonth("March"),true);
    }
  }

  @Test
  public void testContactDeleteGroup(){
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData contact = before.iterator().next();
    if(contact.getGroups().size() == 0){
      app.contact().addedGroup(contact,groups);
    }
    app.contact().deleteGroup(contact,groups);
    Contacts after = app.db().contacts();
    assertThat(after.size(),equalTo(before.size()));
    assertThat(after, equalTo(before));

  }
}
