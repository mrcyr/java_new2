package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import java.util.Set;

public class GroupEdit extends Testbase {

  @BeforeMethod
  public void ensurePrecondition () {
    app.goTo().groupPage();
    if(app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testEdit() {
    Set<GroupData> before = app.group().all();
    GroupData modifedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifedGroup.getId()).withName("122").withHeader("212").withFooter("123");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }


}
