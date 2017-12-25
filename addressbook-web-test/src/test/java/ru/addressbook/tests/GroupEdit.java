package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupEdit extends Testbase {

  @BeforeMethod
  public void ensurePrecondition () {

    if(app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void GroupEditTest() {
    Groups before = app.db().groups();
    GroupData modifedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifedGroup.getId()).withName("122").withHeader("212").withFooter("123");
    app.goTo().groupPage();
    app.group().modify(group);
    assertEquals(app.group().count(), before.size());
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.withOut(modifedGroup).withAdded(group)));
  }


}
