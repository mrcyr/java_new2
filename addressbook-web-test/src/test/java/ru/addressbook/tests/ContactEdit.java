package ru.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactEdit extends Testbase {
  @BeforeMethod
  public void ensurePrecondition(){
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData()
                      .withFirstname("dsfdsfя").withLastname("dfsdf").withAddress("ddsa")
                      .withMobNumber("123123123").withEmail1("dsfsdf@dsfdsf.ru").withPhoto(new File("src/test/resources/7Lj6myuF0cA.jpg")));
    }
  }
  @Test(enabled = true)
  public void ContactEditTest() {
    Contacts before = app.db().contacts();
    ContactData modifedContact = before.iterator().next();
    ContactData contacts = new ContactData().withId(modifedContact.getId())
            .withFirstname("dasdsad").withLastname("dasdsad").withAddress("dasd")
            .withHomeNumber("123123123").withEmail1("dfsdf@dfdf.ty").withPhoto(new File("src/test/resources/7Lj6myuF0cA.jpg"));
    app.contact().modify(contacts);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(modifedContact).withAdded(contacts)));
  }
}