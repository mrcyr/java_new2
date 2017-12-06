package ru.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String address;
  private String fullAddress;
  private String mobnumber;
  private String homenumber;
  private String allPhones;
  private String email1;
  private String email2;
  private String allEmails;
  private String group;
  private String allDetails;
  private File photo;


  public int getId() { return id; }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getFullAddress() {
    return fullAddress;
  }

  public String getMobNumber() {
    return mobnumber;
  }

  public String getHomeNumber() {
    return homenumber;
  }

  public String getAllPhones() {
    return allPhones;
  }
  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getGroup() {
    return group;
  }

  public String getAllDetails() {
    return allDetails;
  }

  public File getPhoto() {
    return photo;
  }

  public ContactData withId(int id) {

    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
    return this;
  }

  public ContactData withMobNumber(String mobnumber) {
    this.mobnumber = mobnumber;
    return this;
  }

  public ContactData withHomeNumber(String homenumber) {
    this.homenumber = homenumber;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAllDetails(String allDetails) {
    this.allDetails = allDetails;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
