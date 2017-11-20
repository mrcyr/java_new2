package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactEdit extends Testbase {
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
              ),
              false);
    }
  }

  @Test(enabled = false)
  public void contactEditTest() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contacts = new ContactData(before.get(before.size() - 1).getId(),
            "1",
            "2",
            "3",
            "6",
            "1",
            "2",
            "2",
            "2",
            null);
    app.contact().modify(index, contacts);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contacts);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }


}