package ru.stqa.crs.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args){
  String[] langs = {"Java","C#","Python","PHP"};

    List languages = Arrays.asList("Java","C#","Python","PHP");

    for(Object l : languages){
      System.out.println("Я хочу выучить " + l);
    }
  }
}
