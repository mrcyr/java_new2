package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigationhelper {
  private WebDriver wd;

  public Navigationhelper(WebDriver wd) {
    this.wd = wd;
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
  public void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }
}
