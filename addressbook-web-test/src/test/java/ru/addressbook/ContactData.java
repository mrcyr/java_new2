package ru.addressbook;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String number;
  private final String numberofSelector;
  private final String numberOfpunkt;
  private final String numberOfSelector2;
  private final String numberOfpunkt2;
  private final String year;

  public ContactData(String firstname, String lastname, String nickname, String company, String address, String number, String numberofSelector, String numberOfpunkt, String numberOfSelector2, String numberOfpunkt2, String year) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.number = number;
    this.numberofSelector = numberofSelector;
    this.numberOfpunkt = numberOfpunkt;
    this.numberOfSelector2 = numberOfSelector2;
    this.numberOfpunkt2 = numberOfpunkt2;
    this.year = year;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
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

  public String getYear() {
    return year;
  }
}
