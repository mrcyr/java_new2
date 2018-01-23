//ебаный стыд

package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsToGroup extends Testbase {

  @BeforeMethod
  public void ensurePrecondition(){
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("dsfdsfя").withLastname("dfsdf").withAddress("ddsa")
              .withMobNumber("123123123").withEmail1("dsfsdf@dsfdsf.ru").withPhoto(new File("src/test/resources/7Lj6myuF0cA.jpg")));
    }
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData().withName("group1"));
    }
  }

  @Test
  public void testAdditionContactIntoGroup() {

    app.goTo().home();
    ContactData selectedContact = app.db().contacts().iterator().next();
    Groups usedGroups = selectedContact.getGroups();
    Groups allGroups = app.db().groups();
    if (usedGroups.size() == allGroups.size()) {
      GroupData newGroup = new GroupData().withName("test" + (allGroups.size() + 1));
      app.goTo().groupPage();
      app.group().create(newGroup);
      app.goTo().home();
      app.contact().selectGroupForAdding(newGroup.getName());
      app.contact().checkContactById(selectedContact.getId());
    } else if (usedGroups.size() == 0) {
      app.contact().selectGroupForAdding(allGroups.iterator().next().getName());
      app.contact().checkContactById(selectedContact.getId());
    } else {
      Groups unusedGroups = allGroups;
      GroupData currentGroup = unusedGroups.iterator().next();
      for (GroupData group : usedGroups) {
        if (currentGroup.getName().equals(group.getName())) {
          unusedGroups.remove(currentGroup);
          currentGroup = unusedGroups.iterator().next();
        }
      }
      app.contact().selectGroupForAdding(unusedGroups.iterator().next().getName());
      app.contact().checkContactById(selectedContact.getId());
    }

    app.contact().addToGroup();
    app.goTo().home();

    ContactData updatedContact = app.db().contactWithId(selectedContact.getId());
    Groups updatedGroups = updatedContact.getGroups();
    assertThat(updatedGroups.size(), equalTo(usedGroups.size() + 1));

  }

  @Test(enabled = false)
  public void testRemovingFromGroup() {
    app.goTo().home();
    app.contact().selectCurrentGroup("[all]");
    ContactData selectedContact = app.db().contacts().iterator().next();
    Groups usedGroups = selectedContact.getGroups();
    Groups allGroups = app.db().groups();
    if (usedGroups.size() == allGroups.size()) {
      app.contact().selectCurrentGroup(allGroups.iterator().next().getName());
      app.contact().checkContactById(selectedContact.getId());

    } else if (usedGroups.size() == 0) {
      String currentGroup = allGroups.iterator().next().getName();
      app.contact().selectGroupForAdding(currentGroup);
      app.contact().checkContactById(selectedContact.getId());
      app.contact().addToGroup();
      app.goTo().home();

      app.contact().selectCurrentGroup(currentGroup);
      app.contact().checkContactById(selectedContact.getId());

    } else {
      app.contact().selectCurrentGroup(usedGroups.iterator().next().getName());
      app.contact().checkContactById(selectedContact.getId());
    }

    ContactData before = app.db().contacts().iterator().next();
    Groups currentGroups = before.getGroups();
    app.contact().removeFromGroup();
    app.goTo().home();

    ContactData after = app.db().contactWithId(selectedContact.getId());
    Groups updatedGroups = after.getGroups();
    assertThat((updatedGroups.size() +1), equalTo(currentGroups.size()));


  }

}

