package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

public class GroupEdit extends Testbase {

  @Test
  public void testEdit() {

    app.getNavigationhelper().gotoGroupPage();
    if(! app.getGrouphelper01().ThereAGroup()){
      app.getGrouphelper01().createGroup(new GroupData("5", "6", "7"));
    }
    app.getGrouphelper01().checkGroup();
    app.getGrouphelper01().editGroup();
    app.getGrouphelper01().fillGroupForm(new GroupData("122", "212", "123"));
    app.getGrouphelper01().updateGroup();
  }
}
