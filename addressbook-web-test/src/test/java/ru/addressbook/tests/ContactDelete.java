package ru.addressbook.tests;


import org.testng.annotations.Test;

public class ContactDelete extends Testbase {

  @Test
  public void contactDeleteTest() {
  app.getNavigationhelper().gotoHomePage();
  app.getContacthelper().checkContact();
  app.getContacthelper().deleteContact();


  }


}
