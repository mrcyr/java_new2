package ru.addressbook.app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;

  private Contacthelper contacthelper;
  private Sessionhelper sessionhelper;
  private Navigationhelper navigationhelper;
  private Grouphelper01 grouphelper01;
  private String browser;
  private Dbhelper dbHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    dbHelper = new Dbhelper();

    if (Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else if (Objects.equals(browser, BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (Objects.equals(browser, BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    }

    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    grouphelper01 = new Grouphelper01(wd);
    navigationhelper = new Navigationhelper(wd);
    sessionhelper = new Sessionhelper(wd);
    contacthelper = new Contacthelper(wd);
    sessionhelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
  }

  public void stop() {
    wd.close();
  }

  public Grouphelper01 group() {

    return grouphelper01;
  }

  public Navigationhelper goTo() {

    return navigationhelper;
  }

  public Sessionhelper getSessionhelper() {

    return sessionhelper;
  }

  public Contacthelper contact() {
    return contacthelper;
  }

  public Dbhelper db() {
    return dbHelper;
  }
}
