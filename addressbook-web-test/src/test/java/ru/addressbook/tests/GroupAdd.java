package ru.addressbook.tests;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

public class GroupAdd extends Testbase {

  @Test
  public void Normtest() {
    app.getNavigationhelper().gotoGroupPage();
    app.getGrouphelper01().initGroupCreate();
    app.getGrouphelper01().fillGroupForm(new GroupData("5", "6", "7"));
    app.getGrouphelper01().submitGroupCreation();
    app.getGrouphelper01().returnToGroupPage();
  }

}
