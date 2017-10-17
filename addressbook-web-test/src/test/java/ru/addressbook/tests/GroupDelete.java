package ru.addressbook.tests;
import org.testng.annotations.Test;

public class GroupDelete extends Testbase {

    @Test
    public void testGroupDelete() {

        app.getNavigationhelper().gotoGroupPage();
        app.getGrouphelper01().checkGroup();
        app.getGrouphelper01().deleteGroup();
        app.getGrouphelper01().returnToGroupPage();
    }

}
