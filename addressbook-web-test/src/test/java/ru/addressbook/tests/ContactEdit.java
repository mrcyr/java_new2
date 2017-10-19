package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

public class ContactEdit extends Testbase {

  @Test
  public void contactEditTest() {
    app.getNavigationhelper().gotoHomePage();
    app.getContacthelper().checkContact();
    app.getContacthelper().editContact();
    app.getContacthelper().fillCotactInfo(new ContactData("1", "2", "3", "4", "5", "6", "1", "2","2", "2", "1980"));
    app.getContacthelper().updateContact();

  }
}
