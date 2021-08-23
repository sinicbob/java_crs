package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class ContactData {
  @Id
  @Column(name = "id")
  private  int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private  String firstName;
  @Expose
  @Column(name = "middlename")
  private  String middleName;
  @Expose
  @Column(name = "lastname")
  private  String lastName;
  @Expose
  @Column(name = "nickname")
  private  String nickname;
  @Expose
  @Column(name = "title")
  private  String title;
  @Expose
  @Column(name = "company")
  private  String company;
  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private  String address;
  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private  String homeNumber;
  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private  String mobileNumber;
  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private  String workNumber;
  @Expose
  @Transient
  private  String fax;
  @Expose
  @Transient
  private  String email;
  @Expose
  @Transient
  private  String email2;
  @Expose
  @Transient
  private  String email3;
  @Expose
  @Transient
  private  String homepage;
  @Expose
  @Transient
  private  String bday;
  @Expose
  @Transient
  private  String bmonth;
  @Expose
  @Transient
  private  String byear;
  @Expose
  @Transient
  private  String aday;
  @Expose
  @Transient
  private  String amonth;
  @Expose
  @Transient
  private  String ayear;



  @Expose
  @Transient
  private  String address2;
  @Expose
  @Transient
  private  String homeNumber2;
  @Expose
  @Transient
  private  String notes;
  @Transient
  private  String allPhones;
  @Transient
  private  String allEmails;
  @Transient
  private  String allAddress;
  @Expose
  @Column(name = "photo")
  @Type(type = "text")
  private  String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData setPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData setAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData setAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData setAllAddress(String allAddress) {
    this.allAddress = allAddress;
    return this;
  }

  public String getAllAddress() {
    return allAddress;
  }

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

  public Groups getGroups() {
    return new Groups(groups);
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
            ", middleName='" + middleName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", nickname='" + nickname + '\'' +
            ", title='" + title + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", homeNumber='" + homeNumber + '\'' +
            ", mobileNumber='" + mobileNumber + '\'' +
            ", workNumber='" + workNumber + '\'' +
            ", fax='" + fax + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(middleName, that.middleName) && Objects.equals(lastName, that.lastName) && Objects.equals(nickname, that.nickname) && Objects.equals(title, that.title) && Objects.equals(company, that.company) && Objects.equals(address, that.address) && Objects.equals(homeNumber, that.homeNumber) && Objects.equals(mobileNumber, that.mobileNumber) && Objects.equals(workNumber, that.workNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, middleName, lastName, nickname, title, company, address, homeNumber, mobileNumber, workNumber);
  }

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;

  }
}
