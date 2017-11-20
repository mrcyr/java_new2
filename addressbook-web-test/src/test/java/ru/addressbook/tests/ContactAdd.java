package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactAdd extends Testbase {

  @Test(enabled = true)
  public void Contact() {
    app.goTo().home();
    List<ContactData> before = app.contact().list();
    ContactData contacts = new ContactData()
            .withFirstname("Саша").withLastname("Иванов").withAddress("Питер")
            .withNumber("123123123").withEmail("pey@mail.ru").withNumberofSelector("2").withNumberOfpunkt("1")
            .withNumberOfSelector2("2").withNumberOfpunkt2("2").withGroup("lala");

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