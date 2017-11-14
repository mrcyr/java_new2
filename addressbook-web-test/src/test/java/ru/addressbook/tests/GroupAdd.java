package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupAdd extends Testbase {

  @Test
  public void Normtest() {
    app.getNavigationhelper().gotoGroupPage();
    List<GroupData> before = app.getGrouphelper01().getGroupList();
    GroupData group = new GroupData("test1", "test2", "test3");
    app.getGrouphelper01().createGroup(group);
    List<GroupData> after = app.getGrouphelper01().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(group);
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }



}
