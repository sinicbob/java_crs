package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase{
  @BeforeMethod
  public void preconditions() {
    app.goTo().contactHomePage();
    if(app.contact().all().size() == 0){
      app.contact().create(new ContactData().setFirstName("Daniil").setMiddleName("test").setLastName("Vladimirov").setNickname("sini").setTitle("test").setHomeNumber("111").setMobileNumber("222").setWorkNumber("333").setEmail("test@mail.ru").setEmail2("test-main@gmail.ru").setEmail3("(test).mail@ya.ru").setAddress("test-address").setBday("13").setBmonth("March").setAday("14").setAmonth("March"),true);
    }
  }

  @Test
  public void testContactEmail(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData addressEditForm = app.contact().infoEditForm(contact);

    assertThat(contact.getAllAddress(), equalTo(mergePhones(addressEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getAddress())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }
}
