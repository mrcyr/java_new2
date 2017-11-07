package ru.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collection {
  public static void main(String [] args) {

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
    List<Integer> Numer = Arrays.asList(1, 2, 3, 4);

    String [] langs = {"Java", "C#", "Python", "PHP"};

    for(int i = 0; i < langs.length; i+=1){
      System.out.println("Ты не знаешь " + langs[i]);
    }

    for (String l : langs){
      System.out.println("ДАДАДАДА " + l);
    }


    for(String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

    for(int i = 0; i < languages.size();i++){
      System.out.println("OOOOOOOOOO");
    }

    for (Integer i : Numer) {
      System.out.println("1111111" + i);
    }

  }
}
