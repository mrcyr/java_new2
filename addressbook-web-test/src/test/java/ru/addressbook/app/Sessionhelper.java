package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sessionhelper extends Helperbase {

  public Sessionhelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    type("user", username);
    type("pass", password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
}
}
