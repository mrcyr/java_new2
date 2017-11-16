package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.List;

public class ContactDelete extends Testbase {

  @Test
  public void contactDeleteTest() {
    app.getNavigationhelper().gotoHomePage();
    if (!app.getContacthelper().ThereAContact()) {
      app.getContacthelper().createContact(new ContactData(
                      "Petr",
                      "Petrov",
                      "Chetkiy",
                      "Lala co.",
                      "1",
                      "3",
                      "2",
                      "5",
                      "test"
              ),
              false);
    }
    List<ContactData> before = app.getContacthelper().getContactList();
    app.getContacthelper().checkContact(before.size() - 1);
    app.getContacthelper().deleteContact();
    app.getNavigationhelper().gotoHomePage();
    List<ContactData> after = app.getContacthelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);


  }


}
