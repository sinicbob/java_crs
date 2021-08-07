package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactForm() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"),contactData.getTitle());
    type(By.name("company"),contactData.getCompany());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomeNumber());
    type(By.name("mobile"),contactData.getMobileNumber());
    type(By.name("work"),contactData.getWorkNumber());
    type(By.name("fax"),contactData.getFax());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"),contactData.getEmail3());
    type(By.name("homepage"),contactData.getHomepage());
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
    type(By.name("byear"),contactData.getByear());
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAday());
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAmonth());
    type(By.name("ayear"),contactData.getAyear());
    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroupname());
    }else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("address2"),contactData.getAddress2());
    type(By.name("phone2"),contactData.getHomeNumber2());
    type(By.name("notes"),contactData.getNotes());
  }


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@class=\"left\"][2]//input[@value=\"Delete\"]"));
  }

  public void initModification(int index) {
    wd.findElements(By.xpath("//*[@title=\"Edit\"]")).get(index).click();

  }
  public void initModificationById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id="+ id +"']")).click();
  }


  public void submitContactModification() {
    click(By.xpath("//*[@value=\"Update\"][2]"));
  }

  public void create(ContactData contact, boolean create) {
    gotoContactPage();
    fillContactForm(contact,create);
    submitContactForm();
    gotoHomePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initModificationById(contact.getId());
    fillContactForm(contact,false);
    submitContactModification();
    gotoHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    Alert alert = wd.switchTo().alert();
    alert.accept();
  }

  public boolean isThereAContact() {
    if(isElementPresent(By.name("entry"))){
      return isElementPresent(By.name("selected[]"));
    }else {
      return false;
    }
  }

  public void gotoContactPage() {
    if(isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPresent(By.name("submit"))){
      return;
    }
    click(By.linkText("add new"));
  }


  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for( WebElement e : elements){
      String name = e.findElement(By.xpath("td[3]")).getText();
      String lastname = e.findElement(By.xpath("td[2]")).getText();
      String allPhones = e.findElement(By.xpath("td[6]")).getText();
      String allEmails = e.findElement(By.xpath("td[5]")).getText();
      String allAddress = e.findElement(By.xpath("td[4]")).getText();
      int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().setId(id).setFirstName(name).setLastName(lastname).setAllPhones(allPhones).setAllEmails(allEmails).setAllAddress(allAddress));
    }
    return contacts;
  }


  public ContactData infoEditForm(ContactData contact) {
    initModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().setId(contact.getId()).setFirstName(firstname).setLastName(lastname)
            .setHomeNumber(home).setMobileNumber(mobile).setWorkNumber(work)
            .setEmail(email1).setEmail2(email2).setEmail3(email3)
            .setAddress(address);
  }
}
