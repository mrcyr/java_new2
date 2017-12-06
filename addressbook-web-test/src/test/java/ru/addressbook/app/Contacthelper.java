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
    type("email", contactData.getEmail1());
    type("email2", contactData.getEmail2());
    attach("photo", contactData.getPhoto());
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
      String allPhones = element.findElement(By.xpath("td[6]")).getText();
      String allEmails = element.findElement(By.xpath("td[5]")).getText();
      String fullAddress = element.findElement(By.xpath("td[4]")).getText();

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName)
              .withAllPhones(allPhones).withAllEmails(allEmails).withFullAddress(fullAddress));
    }
    return contactCache;
  }
  public ContactData infoFromEditForm(ContactData contact){
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String mob = wd.findElement(By.name("mobile")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withMobNumber(mob)
            .withHomeNumber(home).withEmail1(email1).withEmail2(email2).withAddress(address);
  }

  private void initContactModificationById (int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public ContactData infoFromDetailForm(ContactData contact) {
    initContactDetailsById(contact.getId());
    String allDetails = wd.findElement(By.xpath("//div[@id='content']")).getText();

    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withAllDetails(allDetails);

  }
  private void initContactDetailsById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", id))).click();
  }
}
