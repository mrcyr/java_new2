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
                      .withFirstname("Петя").withLastname("Иванов").withAddress("Москва")
                      .withNumber("123123123").withEmail("dsfsdf@dsfdsf.ru").withNumberofSelector("2").withNumberOfpunkt("1")
                      .withNumberOfSelector2("2").withNumberOfpunkt2("2"));
    }
  }
  @Test(enabled = true)
  public void ContactEditTest() {
    Contacts before = app.contact().all();
    ContactData modifedContact = before.iterator().next();
    ContactData contacts = new ContactData().withId(modifedContact.getId())
            .withFirstname("ваня").withLastname("Петров").withAddress("Москва")
            .withNumber("123123123").withEmail("dfsdf@dfdf.ty").withNumberofSelector("2").withNumberOfpunkt("1")
            .withNumberOfSelector2("2").withNumberOfpunkt2("2").withGroup("test");
    app.contact().modify(contacts);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withOut(modifedContact).withAdded(contacts)));
  }
}