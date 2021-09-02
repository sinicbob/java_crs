package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddedToGroup extends TestBase{


  @BeforeMethod
  public void preconditions(){
    if(app.db().contacts().size() == 0){
      app.contact().create(new ContactData().setFirstName("Daniil").setMiddleName("test").setLastName("Vladimirov").setNickname("sini").setPhoto(new File("src/test/resources/foto.png")).setTitle("test").setHomeNumber("111").setMobileNumber("222").setWorkNumber("333").setBday("13").setBmonth("March").setAday("14").setAmonth("March"),true);
    }
    if(app.db().groups().size() == 0){
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("new1").withHeader("new1").withFooter("new1"));
      app.goTo().contactHomePage();
    }
  }


  @Test
  public void testContactAddedToGroup() {
    Contacts contactsDB = app.db().contacts();
    ContactData contactAddedToGroup = null;
      for (ContactData contact : contactsDB) {
        if (contact.getGroups().size() == 0) {
          contactAddedToGroup = contact;
          break;
        }
      }
      if (contactAddedToGroup == null) {
      ContactData newContact = new ContactData().setFirstName("Daniil").setMiddleName("test").setLastName("Vladimirov").setNickname("sini").setPhoto(new File("src/test/resources/foto.png")).setTitle("test").setHomeNumber("111").setMobileNumber("222").setWorkNumber("333").setBday("13").setBmonth("March").setAday("14").setAmonth("March");
      app.contact().create(newContact, true);
      contactsDB = app.db().contacts();
    }

    for (ContactData contact : contactsDB) {
      if (contact.getGroups().size() == 0) {
        contactAddedToGroup = contact;
      }
    }

    Groups before = contactAddedToGroup.getGroups();
    Groups groups = app.db().groups();
    GroupData group = groups.iterator().next();
    app.contact().addedGroup(contactAddedToGroup,group);
    Groups after = contactAddedToGroup.getGroups();
    assertThat(after,equalTo(before.withAdded(group)));
  }
}
