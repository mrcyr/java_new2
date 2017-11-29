package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grouphelper01 extends Helperbase {

  public Grouphelper01(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type("group_name", groupData.getName());
    type("group_header", groupData.getHeader());
    type("group_footer", groupData.getFooter());
  }

  public void initGroupCreate() {
    click(By.name("new"));
  }

  public void deleteGroup() {
    click(By.name("delete"));
  }


  public void checkGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click(); }

  public void editGroup() { click(By.name("edit")); }

  public void updateGroup() { click(By.name("update")); }

  public void create(GroupData group) {
    initGroupCreate();
    fillGroupForm(group);
    submitGroupCreation();
    groupCache = null;
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    checkGroupById(group.getId());
    editGroup();
    fillGroupForm(group);
    updateGroup();
    groupCache = null;
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    checkGroupById(group.getId());
    deleteGroup();
    groupCache = null;
    returnToGroupPage();
  }

  public boolean ThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();

  }

  private Groups groupCache = null;

  public Groups all() {
    if(groupCache != null) {
      return new Groups(groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements ) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")) ;
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCache);
  }
}
