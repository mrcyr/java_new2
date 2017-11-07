package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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
    type("group_name", groupData.getGroupName());
    type("group_header", groupData.getGroupHeader());
    type("group_footer", groupData.getGroupFooter());
  }

  public void initGroupCreate() {
    click(By.name("new"));
  }

  public void deleteGroup() {
    click(By.name("delete"));
  }

  public void checkGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }


  public void editGroup() {
    click(By.name("edit"));

  }

  public void updateGroup() {

    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreate();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean ThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();

  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements ) {
      String name = element.getText();
      GroupData group = new GroupData(name, null, null);
      groups.add(group);

    }
    return groups;

  }
}
