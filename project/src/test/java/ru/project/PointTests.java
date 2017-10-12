package ru.project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void test1 () {

    Point p = new Point(1,1,1,1);
    Assert.assertEquals(p.distance(),0.0);
  }
  @Test
  public void test2 () {

    Point p = new Point(-1,1,1,-1);
    Assert.assertEquals(p.distance(),2.8284271247461903);
  }
}
