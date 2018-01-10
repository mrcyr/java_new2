package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactsAddToGroup extends Testbase {

  @Test
  public void ContactAddToGroupTest () {
    app.goTo().home();
    Contacts before = app.db().contacts();
    ContactData exContact = before.iterator().next();
    app.contact().contactAddToGroup(exContact);
    assertEquals(app.contact().count(), before.size());
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
    verifyContactListInUI();

  }
}
