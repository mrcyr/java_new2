package ru.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;


import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class ContactDelete extends Testbase {

  @BeforeMethod
  public void ensurePrecondition(){
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("sadsd").withLastname("dsdsad").withAddress("dasdsad")
              .withMobNumber("123123123").withEmail1("sfdfdf@ssdfwdf.ty").withPhoto(new File("src/test/resources/7Lj6myuF0cA.jpg")));
    }
  }
  @Test(enabled = true)
  public void contactDeleteTest() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertEquals(app.contact().count(), before.size() - 1);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }
}
