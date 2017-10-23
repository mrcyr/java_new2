package ru.project;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

  @Test
  public void  testEquation0() {
    Equation e = new Equation(1, 1, 1);
    Assert.assertEquals(e.countNumber(), 0);

  }
  @Test
  public void  testEquation1() {
    Equation e = new Equation(1, 2, 1);
    Assert.assertEquals(e.countNumber(), 1);

  }
  @Test
  public void  testEquation2() {
    Equation e = new Equation(1, 5, 6);
    Assert.assertEquals(e.countNumber(), 2);

  }
  @Test
  public void  testEquationLinear() {
    Equation e = new Equation(0, 1, 1);
    Assert.assertEquals(e.countNumber(), 1);

  }
  @Test
  public void  testEquationConst() {
    Equation e = new Equation(0, 0, 1);
    Assert.assertEquals(e.countNumber(), 0);

  }
  @Test
  public void  testEquationZero() {
    Equation e = new Equation(0, 0, 0);
    Assert.assertEquals(e.countNumber(), -1);

  }
}
