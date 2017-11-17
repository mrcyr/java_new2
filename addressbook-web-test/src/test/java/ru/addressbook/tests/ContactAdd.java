package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import java.util.HashSet;
import java.util.List;

public class ContactAdd extends Testbase {
  @Test
  public void Contact() {
    List<ContactData> before = app.getContacthelper().getContactList();
    ContactData contacts = new ContactData(
            "Петя",
            "Иванов",
            "Москва",
            "123123123",
            "1",
            "2",
            "2",
            "2",
            "test");
    app.getContacthelper().createContact(contacts,
            false);
    List<ContactData> after = app.getContacthelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    int max = 0;
    for(ContactData c : after) {
      if(c.getId() > max) {
        max = c.getId();
      }
    }
    contacts.setId(max);
    before.add(contacts);
    Assert.assertEquals(new HashSet<>(before),new HashSet<>(after));

  }

}