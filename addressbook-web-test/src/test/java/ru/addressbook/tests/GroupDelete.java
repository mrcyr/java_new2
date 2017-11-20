package ru.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

import java.util.List;

public class GroupDelete extends Testbase {

  @BeforeMethod
  public void ensurePrecondition () {
    app.goTo().groupPage();
    if(app.group().list().size() == 0){
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @Test
  public void testGroupDelete() {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
