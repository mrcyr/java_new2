package ru.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupEdit extends Testbase {

  @BeforeMethod
  public void ensurePrecondition () {
    app.goTo().groupPage();
    if(app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void GroupEditTest() {
    Groups before = app.group().all();
    GroupData modifedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifedGroup.getId()).withName("122").withHeader("212").withFooter("123");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifedGroup).withAdded(group)));

  }


}
