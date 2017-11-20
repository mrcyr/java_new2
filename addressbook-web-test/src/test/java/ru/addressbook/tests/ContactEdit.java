package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactEdit extends Testbase {

  @Test(enabled = false)
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
    app.getContacthelper().editContact(before.size() - 1);
    ContactData contacts = new ContactData(before.get(before.size() - 1).getId(),
            "1",
            "2",
            "3",
            "6",
            "1",
            "2",
            "2",
            "2",
            null);
    app.getContacthelper().fillCotactInfo(contacts,false);
    app.getContacthelper().updateContact();
    app.getContacthelper().gotoHome();
    List<ContactData> after = app.getContacthelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contacts);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }
}