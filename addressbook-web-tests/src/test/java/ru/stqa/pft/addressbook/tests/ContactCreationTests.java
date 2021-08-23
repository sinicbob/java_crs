package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
   try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))){
     String json = "";
     String line = reader.readLine();
     while (line != null){
       json += line;
       line = reader.readLine();
     }
     Gson gson = new Gson();
     List<ContactData> groups = gson.fromJson(json, new TypeToken<List<ContactData>>() {}.getType());
     return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
   }
  }

  @Test(dataProvider = "validGroupsFromJson")
  public void testContactCreation(ContactData contact) throws Exception {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    app.goTo().contactPage();
    File photo = new File("src/test/resources/foto.png");
    contact.setPhoto(photo);
    contact.inGroup(groups.iterator().next());
    app.contact().create(contact,true);
    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after,equalTo(
            before.withAdded(contact.setId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
