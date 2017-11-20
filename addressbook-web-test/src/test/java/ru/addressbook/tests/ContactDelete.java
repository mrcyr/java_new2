package ru.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.List;

public class ContactDelete extends Testbase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().home();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Петя").withLastname("Иванов").withAddress("Москва")
              .withNumber("123123123").withEmail("sfdfdf@ssdfwdf.ty").withNumberofSelector("2").withNumberOfpunkt("1")
              .withNumberOfSelector2("2").withNumberOfpunkt2("2").withGroup("test"),
              false);
    }
  }
  @Test(enabled = true)
  public void contactDeleteTest() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
