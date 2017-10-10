package ru.project;

public class pro {

  public static void main (String[] args) {
    hello(4);
    hello(5);
    hello(6);

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(5, 7);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = "+ r.area2());

    Point p = new Point(1, -8, 10, -16);
    System.out.println("Расстрояние между двумя точками равно = " + p.distance());


  }

  public static void hello(double perem) {

    System.out.println("Hello, " + perem );
  }




}
