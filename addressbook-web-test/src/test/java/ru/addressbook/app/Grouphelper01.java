package ru.addressbook.app;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.addressbook.model.GroupData;

public class Grouphelper01 {
  private FirefoxDriver wd;

  public Grouphelper01(FirefoxDriver wd) {
    this.wd = wd;

  }

  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getGroupName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getGroupHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getGroupFooter());
  }

  public void initGroupCreate() {
    wd.findElement(By.name("new")).click();
  }

  public void deleteGroup() {
      wd.findElement(By.name("delete")).click();
  }

  public void checkGroup() {
      wd.findElement(By.name("selected[]")).click();
  }
}
