package ru.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactEdit extends Testbase {
  @BeforeMethod
  public void ensurePrecondition(){
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
                      .withFirstname("dsfdsfя").withLastname("dfsdf").withAddress("ddsa")
                      .withMobNumber("123123123").withEmail1("dsfsdf@dsfdsf.ru"));
    }
  }
  @Test(enabled = true)
  public void ContactEditTest() {
    Contacts before = app.contact().all();
    ContactData modifedContact = before.iterator().next();
    ContactData contacts = new ContactData().withId(modifedContact.getId())
            .withFirstname("dasdsad").withLastname("dasdsad").withAddress("dasd")
            .withHomeNumber("123123123").withEmail1("dfsdf@dfdf.ty");
    app.contact().modify(contacts);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withOut(modifedContact).withAdded(contacts)));
  }
}