package ru.project;

public class pro {

  public static void main (String[] args) {
    hello(4);
    hello(5);
    hello(6);
    double l = 5;
    System.out.println(area(l));
    double a = 5;
    double b = 7;
    System.out.println(area2(a, b));
  }

  public static void hello(double perem) {

    System.out.println("Hello, " + perem );
  }

  public static double area(double l) {

    return l*l;
  }
  public static double area2(double a, double b){

    return a*b;
  }
}
