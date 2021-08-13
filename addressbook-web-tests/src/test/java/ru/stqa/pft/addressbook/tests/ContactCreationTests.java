package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    File photo = new File("src/test/resources/foto.png");
    ContactData contact = new ContactData().setFirstName("Daniil").setMiddleName("test").setLastName("Vladimirov").setPhoto(photo).setNickname("sini").setTitle("test").setHomeNumber("111").setMobileNumber("222").setWorkNumber("333").setBday("13").setBmonth("March").setAday("14").setAmonth("March").setGroupname("test1");
    app.contact().create(contact,true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after,equalTo(
            before.withAdded(contact.setId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
