package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesTests extends TestBase{

  @BeforeMethod
  public void preconditions(){
    app.goTo().contactHomePage();
    if(app.contact().all().size() == 0){
      app.contact().create(new ContactData().setFirstName("Daniil").setMiddleName("test").setLastName("Vladimirov").setNickname("sini").setTitle("test").setHomeNumber("111").setMobileNumber("222").setWorkNumber("333").setBday("13").setBmonth("March").setAday("14").setAmonth("March"),true);
    }
  }

  @Test
  public void testContactPhones(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomeNumber(),contact.getMobileNumber(),contact.getWorkNumber())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhonesTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("[() \\s -]","");
  }
}
