package com.collections.tp7.MultiMap;

import org.junit.jupiter.api.Test;

public class MultiMapTest {

  @Test
  public void MMTest() {
    MultiMap<String,Integer> m = new MultiMapImpl<>();
    m.put("hola" , 4);
    m.put("hola" , 3);
    m.put("hola" , 2);
    m.put("chau" , 4);
    m.put("chau" , 5);
    m.put("adios" , 6);
    System.out.println(m.size());
    System.out.println("#####");
    for(Integer i : m.get("hola")) {
      System.out.println(i);
    }
    System.out.println("#####");
    m.remove("adios");
    m.remove("hola"
      , 2);
    for(Integer i : m.get("hola")) {
      System.out.println(i);
    }
    System.out.println("#####");
    System.out.println(m.get("adios"));
    System.out.println("#####");
    System.out.println(m.size());
  }
}
