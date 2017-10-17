package ru.addressbook.app;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;

  private Sessionhelper sessionhelper;
  private Navigationhelper navigationhelper;
  private Grouphelper01 grouphelper01;

  public void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    grouphelper01 = new Grouphelper01(wd);
    navigationhelper = new Navigationhelper(wd);
    sessionhelper = new Sessionhelper(wd);
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
}
