package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;
import ru.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contacthelper extends Helperbase {

  public Contacthelper(WebDriver wd) {
    super(wd);
  }

  public void fillCotactInfo(ContactData contactData) /*, boolean creation)*/ {
    type("firstname", contactData.getFirstname());
    type("lastname", contactData.getLastname());
    type("address", contactData.getAddress());
    type("mobile", contactData.getNumber());
    type("email", contactData.getEmail());
    click(By.xpath("//div[@id='content']/form/select[" + contactData.getNumberofSelector() + "]//option[" + contactData.getNumberOfpunkt() + "]"));
    click(By.xpath("//div[@id='content']/form/select[" + contactData.getNumberOfSelector2() + "]//option[" + contactData.getNumberOfpunkt2() + "]"));
    click(By.xpath("//div[@id='content']/form/input[21]"));

    //new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    /*if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }*/
  }

  public void addContact() {

    click(By.linkText("add new"));
  }

  private void checkContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }
  public void editContact(int id){
    click((By.cssSelector("a[href='edit.php?id=" + id + "']")));
  }

  public void updateContact()
  {
    click(By.name("update"));
  }

  public void create(ContactData contact) /*,boolean b)*/ {
    addContact();
    fillCotactInfo(contact)/*, b)*/;
    contactCache = null;
    gotoHome();
  }

  public void delete(ContactData contact) {
    checkContactById(contact.getId());
    deleteContact();
    contactCache = null;
    gotoHome();
  }

  public void modify(ContactData contact) {
    checkContactById(contact.getId());
    editContact(contact.getId());
    fillCotactInfo(contact);
    updateContact();
    contactCache = null;
    gotoHome();
  }

  public boolean ThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void gotoHome() {
    wd.findElement(By.linkText("home")).click();
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if(contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
    for(WebElement element : elements) {
      String lastName = element.findElement(By.xpath("td[2]")).getText();
      String firstName = element.findElement(By.xpath("td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
    }
    return contactCache;
  }
}
