package ru.addressbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

public class GroupDelete extends Testbase {

    @Test
    public void testGroupDelete() {

      app.getNavigationhelper().gotoGroupPage();
      int before = app.getGrouphelper01().getGroupCount();
      if(! app.getGrouphelper01().ThereAGroup()){
          app.getGrouphelper01().createGroup(new GroupData("5", "6", "7"));
      }
      app.getGrouphelper01().checkGroup();
      app.getGrouphelper01().deleteGroup();
      app.getGrouphelper01().returnToGroupPage();
      int after = app.getGrouphelper01().getGroupCount();
      Assert.assertEquals(after, before - 1);
    }

}
