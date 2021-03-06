package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.addressbook.app.ApplicationManager;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Testbase {

  org.slf4j.Logger logger = LoggerFactory.getLogger(Testbase.class);

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {

    app.stop();
  }

  @BeforeMethod
  public void logTestStart (Method m, Object [] p) {

    logger.info(String.format("Start test %s with parameters %s", m.getName(), Arrays.asList(p)));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop (Method m) {
    logger.info("Stop test " + m.getName());
  }

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyContactListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContats = app.contact().all();
      assertThat(uiContats, equalTo(dbContacts.stream()
              .map((g) -> new ContactData().withId(g.getId())
                      .withLastname(g.getLastname())
                      .withFirstname(g.getFirstname()))
              .collect(Collectors.toSet())));
    }
  }
}
