package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.addressbook.model.ContactData;

public class Contacthelper extends Helperbase {

  public Contacthelper(WebDriver wd) {
    super(wd);
  }



  public void fillCotactInfo(ContactData contactData, boolean creation) {
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

    if (creation) {
      new Select(wd.findElement(By.name("new group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new group")));
    }
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

  public void createContact(ContactData contact, boolean b) {
    addContact();
    fillCotactInfo(contact, b);
    gotoHome();
  }

  public boolean ThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void gotoHome() {
    wd.findElement(By.linkText("home")).click();
  }
}
