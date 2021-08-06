package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private  String firstName;
  private  String middleName;
  private  String lastName;
  private  String nickname;
  private  String title;
  private  String company;
  private  String address;
  private  String homeNumber;
  private  String mobileNumber;
  private  String workNumber;
  private  String fax;
  private  String email;
  private  String email2;
  private  String email3;
  private  String homepage;
  private  String bday;
  private  String bmonth;
  private  String byear;
  private  String aday;
  private  String amonth;
  private  String ayear;
  private  String groupname;
  private  String address2;
  private  String homeNumber2;
  private  String notes;


  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomeNumber() {
    return homeNumber;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public String getWorkNumber() {
    return workNumber;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getAday() {
    return aday;
  }

  public String getAmonth() {
    return amonth;
  }

  public String getAyear() {
    return ayear;
  }

  public String getGroupname() {
    return groupname;
  }

  public String getAddress2() {
    return address2;
  }

  public String getHomeNumber2() {
    return homeNumber2;
  }

  public String getNotes() {
    return notes;
  }

  public ContactData setId(int id) {
    this.id = id;
    return this;
  }

  public ContactData setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData setNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData setTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData setCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData setAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData setHomeNumber(String homeNumber) {
    this.homeNumber = homeNumber;
    return this;
  }

  public ContactData setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
    return this;
  }

  public ContactData setWorkNumber(String workNumber) {
    this.workNumber = workNumber;
    return this;
  }

  public ContactData setFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData setEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData setEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData setEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData setHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData setBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData setBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData setByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData setAday(String aday) {
    this.aday = aday;
    return this;
  }

  public ContactData setAmonth(String amonth) {
    this.amonth = amonth;
    return this;
  }

  public ContactData setAyear(String ayear) {
    this.ayear = ayear;
    return this;
  }

  public ContactData setGroupname(String groupname) {
    this.groupname = groupname;
    return this;
  }

  public ContactData setAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData setHomeNumber2(String homeNumber2) {
    this.homeNumber2 = homeNumber2;
    return this;
  }

  public ContactData setNotes(String notes) {
    this.notes = notes;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }
}
