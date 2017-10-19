package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.addressbook.model.ContactData;

public class Contacthelper extends Helperbase {

  public Contacthelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoHome() {
    click(By.linkText("home"));
  }

  public void fillCotactInfo(ContactData contactData) {
    type("firstname", contactData.getFirstname());
    type("lastname", contactData.getLastname());
    type("nickname", contactData.getNickname());
    type("company", contactData.getCompany());
    type("address", contactData.getAddress());
    type("mobile", contactData.getNumber());
    click(By.xpath("//div[@id='content']/form/select[" + contactData.getNumberofSelector() + "]//option[" + contactData.getNumberOfpunkt() + "]"));
    click(By.xpath("//div[@id='content']/form/select[" + contactData.getNumberOfSelector2() + "]//option[" + contactData.getNumberOfpunkt2() + "]"));
    type("byear", contactData.getYear());
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void addContact() {

    click(By.linkText("add new"));
  }
  public void checkContact() {

    click(By.name("selected[]"));
  }
  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void editContact(){
    click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
  }

  public void updateContact() {
    click(By.name("update"));
  }




}
