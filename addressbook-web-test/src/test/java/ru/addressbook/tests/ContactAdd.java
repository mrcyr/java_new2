package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactAdd extends Testbase {

  @Test(enabled = false)
  public void Contact() {
    app.goTo().home();
    List<ContactData> before = app.contact().list();
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
    app.contact().create(contacts,false);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contacts);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}