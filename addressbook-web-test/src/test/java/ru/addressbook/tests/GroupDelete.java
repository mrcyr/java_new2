package ru.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.List;

public class GroupDelete extends Testbase {

  @BeforeMethod
  public void ensurePrecondition () {
    app.getNavigationhelper().gotoGroupPage();
    if(! app.getGrouphelper01().ThereAGroup()){
      app.getGrouphelper01().createGroup(new GroupData("5", "6", "7"));
    }
  }

  @Test
  public void testGroupDelete() {
    List<GroupData> before = app.getGrouphelper01().getGroupList();
    app.getGrouphelper01().checkGroup(before.size() - 1);
    app.getGrouphelper01().deleteGroup();
    app.getGrouphelper01().returnToGroupPage();
    List<GroupData> after = app.getGrouphelper01().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
