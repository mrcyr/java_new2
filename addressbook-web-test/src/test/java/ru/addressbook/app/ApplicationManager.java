package ru.addressbook.app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private Contacthelper contacthelper;
  private Sessionhelper sessionhelper;
  private Navigationhelper navigationhelper;
  private Grouphelper01 grouphelper01;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (Objects.equals(browser, BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (Objects.equals(browser, BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }


    wd.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    grouphelper01 = new Grouphelper01(wd);
    navigationhelper = new Navigationhelper(wd);
    sessionhelper = new Sessionhelper(wd);
    contacthelper = new Contacthelper(wd);
    sessionhelper.login("admin", "secret");
  }

  public void stop() {
    wd.close();
  }

  public Grouphelper01 getGrouphelper01() {

    return grouphelper01;
  }

  public Navigationhelper getNavigationhelper() {

    return navigationhelper;
  }

  public Sessionhelper getSessionhelper() {

    return sessionhelper;
  }

  public Contacthelper getContacthelper() {
    return contacthelper;
  }
}
