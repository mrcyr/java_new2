package ru.addressbook.tests;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

public class GroupAdd extends Testbase {

  @Test
  public void Normtest() {
    app.getNavigationhelper().gotoGroupPage();
    app.getGrouphelper01().initGroupCreate();
    app.getGrouphelper01().fillGroupForm(new GroupData("49", "123", "213"));
    app.getGrouphelper01().submitGroupCreation();
    app.getGrouphelper01().returnToGroupPage();
  }

}
