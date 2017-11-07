package ru.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.List;

public class GroupAdd extends Testbase {

  @Test
  public void Normtest() {
    app.getNavigationhelper().gotoGroupPage();
    List<GroupData> before = app.getGrouphelper01().getGroupList();
    app.getGrouphelper01().createGroup(new GroupData("5", "6", "7"));
    List<GroupData> after = app.getGrouphelper01().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);


  }



}
