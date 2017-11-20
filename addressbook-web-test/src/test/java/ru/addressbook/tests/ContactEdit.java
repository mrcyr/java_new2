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
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData()
                      .withFirstname("Петя").withLastname("Иванов").withAddress("Москва")
                      .withNumber("123123123").withEmail("dsfsdf@dsfdsf.ru").withNumberofSelector("2").withNumberOfpunkt("1")
                      .withNumberOfSelector2("2").withNumberOfpunkt2("2").withGroup("test"),
              false);
    }
  }

  @Test(enabled = true)
  public void contactEditTest() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contacts = new ContactData().withId(before.get(before.size() - 1).getId())
            .withFirstname("Петя").withLastname("Иванов").withAddress("Москва")
            .withNumber("123123123").withEmail("dfsdf@dfdf.ty").withNumberofSelector("2").withNumberOfpunkt("1")
            .withNumberOfSelector2("2").withNumberOfpunkt2("2").withGroup("test");
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