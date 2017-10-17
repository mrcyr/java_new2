package ru.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactAdd {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      login("admin", "secret");

    }
    private void login(String username, String password) {
      wd.get("http://localhost/addressbook/");
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @Test
    public void Contact() {
      addContact();
      fillCotactInfo(new ContactData("Petr", "Petrov", "Chetkiy", "Lala co.", "Tamtam", "123123123", "1", "6", "2", "7", "1990"));
      gotoHome();
    }

  private void gotoHome() {
    wd.findElement(By.linkText("home")).click();
  }
  private void fillCotactInfo(ContactData contactData) {
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
    wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("mobile")).sendKeys(contactData.getNumber());
    wd.findElement(By.xpath("//div[@id='content']/form/select[" + contactData.getNumberofSelector() + "]//option[" + contactData.getNumberOfpunkt() + "]")).click();
    wd.findElement(By.xpath("//div[@id='content']/form/select[" + contactData.getNumberOfSelector2() + "]//option[" + contactData.getNumberOfpunkt2() + "]")).click();
    wd.findElement(By.name("byear")).sendKeys(contactData.getYear());
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void addContact() {
    wd.findElement(By.linkText("add new")).click();
  }
  @AfterMethod
    public void tearDown() {
        wd.close();
    }
}
