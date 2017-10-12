package ru.project;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SquareTests {

  @Test
  public void testArea () {

    Square s = new Square(5);
    Assert.assertEquals(s.area(),25.0);
  }

  @Test
  public void testArea1 () {

    Square s = new Square(10);
    Assert.assertEquals(s.area(), 100.0);
  }
}
