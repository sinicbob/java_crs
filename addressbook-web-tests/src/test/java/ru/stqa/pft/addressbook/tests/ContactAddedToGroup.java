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
    }
  }

  @Test
  public void testContactAddedToGroup(){
    Groups groups = app.db().groups();
    System.out.println(groups.iterator().next());
    Contacts before = app.db().contacts();
    ContactData contact = before.iterator().next();
    if (contact.getGroups().size() == 1){
      app.contact().deleteGroup(contact,groups);
    }
    app.contact().addedGroup(contact,groups);
    Contacts after = app.db().contacts();
    assertThat(after.size(),equalTo(before.size()));
    assertThat(after, equalTo(before));

  }
}
