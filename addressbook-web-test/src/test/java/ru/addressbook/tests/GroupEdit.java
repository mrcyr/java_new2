package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

public class GroupEdit extends Testbase {

  @Test
  public void testEdit() {

    app.getNavigationhelper().gotoGroupPage();
    int before = app.getGrouphelper01().getGroupCount();
    if(! app.getGrouphelper01().ThereAGroup()){
      app.getGrouphelper01().createGroup(new GroupData("5", "6", "7"));
    }
    app.getGrouphelper01().checkGroup();
    app.getGrouphelper01().editGroup();
    app.getGrouphelper01().fillGroupForm(new GroupData("122", "212", "123"));
    app.getGrouphelper01().updateGroup();
    int after = app.getGrouphelper01().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
