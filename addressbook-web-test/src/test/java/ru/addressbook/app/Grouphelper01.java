package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.addressbook.model.GroupData;

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

  public void checkGroup() {

    click(By.name("selected[]"));

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
}
