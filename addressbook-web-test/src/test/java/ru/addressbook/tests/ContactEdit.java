package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.List;

public class ContactEdit extends Testbase {

  @Test
  public void contactEditTest() {
    app.getNavigationhelper().gotoHomePage();
    if (! app.getContacthelper().ThereAContact()) {
      app.getContacthelper().createContact(new ContactData(
                      "Petr",
                      "Petrov",
                      "Tamtam",
                      "123123123",
                      "1",
                      "4",
                      "2",
                      "9",
                      "123"),
              false);
    }
    List<ContactData> before = app.getContacthelper().getContactList();
    app.getContacthelper().checkContact(before.size() - 1);
    app.getContacthelper().editContact();
    app.getContacthelper().fillCotactInfo(new ContactData(
            "1",
            "2",
            "3",
            "6",
            "1",
            "2",
            "2",
            "2",
            null),
            false);
    app.getContacthelper().updateContact();
    app.getContacthelper().gotoHome();
    List<ContactData> after = app.getContacthelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}
