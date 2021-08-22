package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void preconditions(){
    if(app.db().contacts().size() == 0){
      app.goTo().contactHomePage();
      app.contact().create(new ContactData().setFirstName("Daniil").setMiddleName("test").setLastName("Vladimirov").setNickname("sini").setPhoto(new File("src/test/resources/foto.png")).setTitle("test").setHomeNumber("111").setMobileNumber("222").setWorkNumber("333").setBday("13").setBmonth("March").setAday("14").setAmonth("March").setGroupname("test1"),true);
    }
  }


  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.db().contacts();
    ContactData deteledContact = before.iterator().next();
    app.contact().delete(deteledContact);
    app.goTo().contactHomePage();
    Contacts after = app.db().contacts();
    assertThat(after.size(),equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deteledContact)));
  }

}
