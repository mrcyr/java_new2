package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.List;

public class GroupEdit extends Testbase {

  @Test
  public void testEdit() {

    app.getNavigationhelper().gotoGroupPage();
    if(! app.getGrouphelper01().ThereAGroup()){
      app.getGrouphelper01().createGroup(new GroupData("5", "6", "7"));
    }
    List<GroupData> before = app.getGrouphelper01().getGroupList();
    app.getGrouphelper01().checkGroup(before.size() - 1);
    app.getGrouphelper01().editGroup();
    app.getGrouphelper01().fillGroupForm(new GroupData("122", "212", "123"));
    app.getGrouphelper01().updateGroup();
    app.getNavigationhelper().gotoGroupPage();
    List<GroupData> after = app.getGrouphelper01().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }
}
