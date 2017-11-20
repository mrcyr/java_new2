package ru.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String address;
  private String number;
  private String email;
  private String numberofSelector;
  private String numberOfpunkt;
  private String numberOfSelector2;
  private String numberOfpunkt2;
  private String group;


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

  public String getNumber() {
    return number;
  }

  public String getEmail() {
    return email;
  }

  public String getNumberofSelector() {
    return numberofSelector;
  }

  public String getNumberOfpunkt() {
    return numberOfpunkt;
  }

  public String getNumberOfSelector2() {
    return numberOfSelector2;
  }

  public String getNumberOfpunkt2() {
    return numberOfpunkt2;
  }
  public String getGroup() {
    return group;
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

  public ContactData withNumber(String number) {
    this.number = number;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withNumberofSelector(String numberofSelector) {
    this.numberofSelector = numberofSelector;
    return this;
  }

  public ContactData withNumberOfpunkt(String numberOfpunkt) {
    this.numberOfpunkt = numberOfpunkt;
    return this;
  }

  public ContactData withNumberOfSelector2(String numberOfSelector2) {
    this.numberOfSelector2 = numberOfSelector2;
    return this;
  }

  public ContactData withNumberOfpunkt2(String numberOfpunkt2) {
    this.numberOfpunkt2 = numberOfpunkt2;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
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

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
