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
      app.contact().create(new ContactData(
                      "Petr",
                      "Petrov",
                      "Chetkiy",
                      "Lala co.",
                      "1",
                      "3",
                      "2",
                      "5",
                      "test"
                      ), false);
    }
  }
  @Test(enabled = false)
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
