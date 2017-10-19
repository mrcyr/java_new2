package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

public class GroupEdit extends Testbase {

  @Test
  public void testEdit() {

    app.getNavigationhelper().gotoGroupPage();
    app.getGrouphelper01().checkGroup();
    app.getGrouphelper01().editGroup();
    app.getGrouphelper01().fillGroupForm(new GroupData("5", "6", "7"));
    app.getGrouphelper01().updateGroup();
  }
}
