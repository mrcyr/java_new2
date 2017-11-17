package ru.addressbook.model;

public class ContactData {
  private final String id;
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String number;
  private final String numberofSelector;
  private final String numberOfpunkt;
  private final String numberOfSelector2;
  private final String numberOfpunkt2;
  private String group;

  public ContactData(String firstname, String lastname, String address, String number, String numberofSelector, String numberOfpunkt, String numberOfSelector2, String numberOfpunkt2, String group) {
    this.id = null;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.number = number;
    this.numberofSelector = numberofSelector;
    this.numberOfpunkt = numberOfpunkt;
    this.numberOfSelector2 = numberOfSelector2;
    this.numberOfpunkt2 = numberOfpunkt2;
    this.group = group;
  }


  public ContactData(String id, String firstname, String lastname, String address, String number, String numberofSelector, String numberOfpunkt, String numberOfSelector2, String numberOfpunkt2, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.number = number;
    this.numberofSelector = numberofSelector;
    this.numberOfpunkt = numberOfpunkt;
    this.numberOfSelector2 = numberOfSelector2;
    this.numberOfpunkt2 = numberOfpunkt2;
    this.group = group;
  }


  public String getId() { return id; }

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

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
