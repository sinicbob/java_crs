package ru.stqa.crs.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testParams(){
    Point p1 = new Point(2,4);
    Assert.assertEquals(p1.x , 2);
    Assert.assertEquals(p1.y , 4);
  }

  @Test
  public void testDistance(){
    Point p1 = new Point(0,1);
    Point p2 = new Point(2,-2);
    Assert.assertEquals(p1.distance(p1,p2),3.605551275463989);
  }

  @Test
  public void testDistanceX2(){
    Point p1 = new Point(-1,3);
    Point p2 = new Point(6,2);
    Assert.assertEquals(p1.distance(p1,p2),7.0710678118654755);
  }

}
