package ru.stqa.crs.sandbox;

public class PointWorker {

  public static void main(String[] args) {
    Point p1 = new Point(0,1);
    Point p2 = new Point(2,-2);
    System.out.println("Расстояние между точками " + p1.x + " " + p1.y + " и " + p2.x + " "+ p2.y +" = " + p1.distance(p2));

  }
//  public static double distance(Point p1, Point p2){
//    double result = Math.sqrt(Math.pow((p2.x - p1.x),2) + Math.pow((p2.y - p1.y),2) );
//    return result;
//  }
}
