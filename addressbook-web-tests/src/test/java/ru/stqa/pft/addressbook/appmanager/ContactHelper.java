package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.ContactModifitionData;

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

  public void fillContactForm(ContactData contactData) {
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
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroupname());
    type(By.name("address2"),contactData.getAddress2());
    type(By.name("phone2"),contactData.getHomeNumber2());
    type(By.name("notes"),contactData.getNotes());
  }

  public void modificationContactForm(ContactModifitionData contactModificationData){
    type(By.name("firstname"), contactModificationData.getFirstName());
    type(By.name("middlename"), contactModificationData.getMiddleName());
    type(By.name("lastname"), contactModificationData.getLastName());
    type(By.name("nickname"), contactModificationData.getNickname());
    type(By.name("title"),contactModificationData.getTitle());
    type(By.name("company"),contactModificationData.getCompany());
    type(By.name("address"),contactModificationData.getAddress());
    type(By.name("home"),contactModificationData.getHomeNumber());
    type(By.name("mobile"),contactModificationData.getMobileNumber());
    type(By.name("work"),contactModificationData.getWorkNumber());
    type(By.name("fax"),contactModificationData.getFax());
    type(By.name("email"),contactModificationData.getEmail());
    type(By.name("email2"),contactModificationData.getEmail2());
    type(By.name("email3"),contactModificationData.getEmail3());
    type(By.name("homepage"),contactModificationData.getHomepage());
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactModificationData.getBday());
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactModificationData.getBmonth());
    type(By.name("byear"),contactModificationData.getByear());
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactModificationData.getAday());
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactModificationData.getAmonth());
    type(By.name("ayear"),contactModificationData.getAyear());
    type(By.name("address2"),contactModificationData.getAddress2());
    type(By.name("phone2"),contactModificationData.getHomeNumber2());
    type(By.name("notes"),contactModificationData.getNotes());
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@class=\"left\"][2]//input[@value=\"Delete\"]"));
  }

  public void initModification() {
    click(By.xpath("//*[@title=\"Edit\"]"));
  }

  public void submitContactModification() {
    click(By.xpath("//*[@value=\"Update\"][2]"));
  }
}