package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Set;

public class ContactAdd extends Testbase {

  @Test(enabled = true)
  public void ContactAddTest() {
    app.goTo().home();
    Set<ContactData> before = app.contact().all();
    ContactData contacts = new ContactData()
            .withFirstname("Саша").withLastname("Иванов").withAddress("Питер")
            .withNumber("123123123").withEmail("pey@mail.ru").withNumberofSelector("2").withNumberOfpunkt("1")
            .withNumberOfSelector2("2").withNumberOfpunkt2("2").withGroup("123");
    app.contact().create(contacts);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    contacts.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contacts);
    Assert.assertEquals(before, after);
  }
}