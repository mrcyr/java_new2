package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
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
    GroupData group = new GroupData(before.get(before.size()-1).getId(),"122", "212", "123");
    app.getGrouphelper01().fillGroupForm(group);
    app.getGrouphelper01().updateGroup();
    app.getNavigationhelper().gotoGroupPage();
    List<GroupData> after = app.getGrouphelper01().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
