package ru.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

public class GroupAdd extends Testbase {

  @Test
  public void Normtest() {
    app.getNavigationhelper().gotoGroupPage();
    int before = app.getGrouphelper01().getGroupCount();
    app.getGrouphelper01().createGroup(new GroupData("5", "6", "7"));
    int after = app.getGrouphelper01().getGroupCount();
    Assert.assertEquals(after, before + 1);


  }



}
