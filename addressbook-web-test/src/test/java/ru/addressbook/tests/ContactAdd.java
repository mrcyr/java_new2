package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactAdd extends Testbase {

  @Test(enabled = true)
  public void ContactAddTest() {
    app.goTo().home();
    Contacts before = app.contact().all();
    ContactData contacts = new ContactData()
            .withFirstname("Саша").withLastname("Иванов").withAddress("Питер")
            .withNumber("123123123").withEmail("pey@mail.ru").withNumberofSelector("2").withNumberOfpunkt("1")
            .withNumberOfSelector2("2").withNumberOfpunkt2("2");
    app.contact().create(contacts);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() + 1);
    assertThat(after, equalTo(
            before.withAdded(contacts.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}