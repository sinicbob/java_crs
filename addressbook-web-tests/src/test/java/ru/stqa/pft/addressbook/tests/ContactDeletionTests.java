package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void preconditions(){
    app.goTo().contactHomePage();
    if(app.contact().all().size() == 0){
      app.contact().create(new ContactData().setFirstName("Daniil").setMiddleName("test").setLastName("Vladimirov").setNickname("sini").setTitle("test").setBday("13").setBmonth("March").setAday("14").setAmonth("March").setGroupname("test1"),true);
    }
  }


  @Test
  public void testContactDeletion() throws Exception {
    Contacts before = app.contact().all();
    ContactData deteledContact = before.iterator().next();
    app.contact().delete(deteledContact);
    app.goTo().contactHomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(),equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deteledContact)));
  }

}
