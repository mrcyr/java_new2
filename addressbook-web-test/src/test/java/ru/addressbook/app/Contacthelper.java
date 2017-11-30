package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import java.util.List;

public class Contacthelper extends Helperbase {

  public Contacthelper(WebDriver wd) {
    super(wd);
  }

  public void fillCotactInfo(ContactData contactData) /*, boolean creation)*/ {
    type("firstname", contactData.getFirstname());
    type("lastname", contactData.getLastname());
    type("address", contactData.getAddress());
    type("mobile", contactData.getMobNumber());
    type("home", contactData.getHomeNumber());
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
      String[] phones = element.findElement(By.xpath("td[6]")).getText().split("\n");
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName)
              .withHomeNumber(phones[0]).withMobNumber(phones[1]));
    }
    return contactCache;
  }
  public ContactData infoFromEditForm(ContactData contact){
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String mob = wd.findElement(By.name("mobile")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withMobNumber(mob)
            .withHomeNumber(home);
  }

  private void initContactModificationById (int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }
}
