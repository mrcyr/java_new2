package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Helperbase {
  protected WebDriver wd;

  public Helperbase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();

  }

  protected void type(String locator, String text) {
    click(By.name(locator));
    if (text != null) {
      String existingText = wd.findElement(By.name(locator)).getAttribute("value");
      if (! text.equals(existingText)){
        wd.findElement(By.name(locator)).clear();
        wd.findElement(By.name(locator)).sendKeys(text);
      }
     }
    }

  protected void attach (String locator, File file) {
    if (file != null) {
        wd.findElement(By.name(locator)).sendKeys(file.getAbsolutePath());
      }
    }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}

