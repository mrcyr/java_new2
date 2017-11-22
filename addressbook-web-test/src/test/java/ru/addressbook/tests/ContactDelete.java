package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDelete extends Testbase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().home();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Петя").withLastname("Иванов").withAddress("Москва")
              .withNumber("123123123").withEmail("sfdfdf@ssdfwdf.ty").withNumberofSelector("2").withNumberOfpunkt("1")
              .withNumberOfSelector2("2").withNumberOfpunkt2("2").withGroup("test"));
    }
  }
  @Test(enabled = true)
  public void contactDeleteTest() {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}
