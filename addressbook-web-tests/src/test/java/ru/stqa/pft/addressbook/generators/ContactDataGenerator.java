package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;
  @Parameter(names = "-f", description = "Target file")
  public String file;
  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch (ParameterException ex){
      jCommander.usage();
      return;
    }

    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if(format.equals("json")) {
      saveAsJSON(contacts,new File(file));
    }else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for(int i = 0; i < count;i++){
      contacts.add(new ContactData().setFirstName(String.format("test %s",i))
              .setMiddleName(String.format("test %s",i))
              .setLastName(String.format("Vladimirov %s",i))
              .setNickname(String.format("sini %s",i))
                      .setCompany(String.format("testCompany%s",i)).setAddress(String.format("testAddress %s",i))
              .setTitle(String.format("test %s",i)).setHomeNumber("111").setMobileNumber("222").setWorkNumber("333").setBday("13")
              .setBmonth("March").setAday("14").setAmonth("March").setGroupname("test1"));
    }
    return contacts;
  }

  private void saveAsJSON(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file);){
      writer.write(json);
    }
  }
}
