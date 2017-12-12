package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.addressbook.app.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

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



}
