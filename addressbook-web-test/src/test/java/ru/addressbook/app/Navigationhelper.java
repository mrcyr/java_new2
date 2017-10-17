package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Navigationhelper {
  private FirefoxDriver wd;

  public Navigationhelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}
