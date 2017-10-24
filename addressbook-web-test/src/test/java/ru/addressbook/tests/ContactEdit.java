package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

public class ContactEdit extends Testbase {

  @Test
  public void contactEditTest() {
    app.getNavigationhelper().gotoHomePage();
    if (! app.getContacthelper().ThereAContact()) {
      app.getContacthelper().createContact(new ContactData(
                      "Petr",
                      "Petrov",
                      "Chetkiy",
                      "Lala co.",
                      "Tamtam",
                      "123123123",
                      "1",
                      "4",
                      "2",
                      "9",
                      "1991",
                      "123"),
              false);
    }
    app.getContacthelper().checkContact();
    app.getContacthelper().editContact();
    app.getContacthelper().fillCotactInfo(new ContactData(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "1",
            "2",
            "2",
            "2",
            "1980",
            null),
            false);
    app.getContacthelper().updateContact();

  }
}
