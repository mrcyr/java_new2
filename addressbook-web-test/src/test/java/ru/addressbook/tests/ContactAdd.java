package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.List;

public class ContactAdd extends Testbase {
  @Test
  public void Contact() {
    List<ContactData> before = app.getContacthelper().getContactList();
    app.getContacthelper().createContact(new ContactData(
            "Петя",
            "Иванов",
            "Москва",
            "123123123",
            "1",
            "2",
            "2",
            "2",
            "test"),
            false);
    List<ContactData> after = app.getContacthelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

  }

}