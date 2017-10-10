package ru.project;

public class Point {
  public double a1;
  public double b1;
  public double a2;
  public double b2;

  public Point(double a1, double a2, double b1, double b2){
    this.a1 = a1;
    this.a2 = a2;
    this.b1 = b1;
    this.b2 = b2;
  }

  public double distance() {
    return Math.sqrt(Math.pow((this.a2 - this.a1), 2) + Math.pow((this.b2 - this.b1), 2));
  }

}
