package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactAdd extends Testbase {

  @Test(enabled = true)
  public void ContactAddTest() {
    app.goTo().home();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/7Lj6myuF0cA.jpg");
    ContactData contacts = new ContactData()
            .withFirstname("Саша").withLastname("Иванов").withAddress("Питер")
            .withMobNumber("123123123").withHomeNumber("123123").withEmail1("pey123@mail.ru").withEmail2("asdasd@asdsd.ru")
            .withPhoto(photo);
    app.contact().create(contacts);
    assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contacts.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}