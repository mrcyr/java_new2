package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class Contacthelper extends Helperbase {

  public Contacthelper(WebDriver wd) {
    super(wd);
  }



  public void fillCotactInfo(ContactData contactData, boolean creation) {
    type("firstname", contactData.getFirstname());
    type("lastname", contactData.getLastname());
    type("address", contactData.getAddress());
    type("mobile", contactData.getNumber());
    click(By.xpath("//div[@id='content']/form/select[" + contactData.getNumberofSelector() + "]//option[" + contactData.getNumberOfpunkt() + "]"));
    click(By.xpath("//div[@id='content']/form/select[" + contactData.getNumberOfSelector2() + "]//option[" + contactData.getNumberOfpunkt2() + "]"));
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
  public void checkContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
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

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
    for(WebElement element : elements) {
     String lastName = element.findElement(By.xpath("td[2]")).getText();
     String firstName = element.findElement(By.xpath("td[3]")).getText();
     int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
     ContactData contact = new ContactData(id, firstName, lastName,
             null,
             null,
             null,
             null,
             null,
             null,
             null);
     contacts.add(contact);
    }
    return contacts;
  }
}
