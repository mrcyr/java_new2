package ru.addressbook.tests;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;

public class GroupDelete extends Testbase {

    @Test
    public void testGroupDelete() {

        app.getNavigationhelper().gotoGroupPage();
        if(! app.getGrouphelper01().ThereAGroup()){
            app.getGrouphelper01().createGroup(new GroupData("5", "6", "7"));
        }
        app.getGrouphelper01().checkGroup();
        app.getGrouphelper01().deleteGroup();
        app.getGrouphelper01().returnToGroupPage();
    }

}
