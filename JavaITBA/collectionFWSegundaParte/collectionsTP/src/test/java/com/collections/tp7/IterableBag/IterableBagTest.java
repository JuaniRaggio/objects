package com.collections.tp7.IterableBag;

import java.util.NoSuchElementException;

public class IterableBagTest {

  public void IBTest() {
    IterableBag<String> stringBag = new IterableBagImpl<>();
    System.out.println(stringBag.contains("hola"));
    stringBag.add("hola");
    System.out.println(stringBag.contains("hola"));
    stringBag.add("que");
    stringBag.add("que");
    System.out.println(stringBag.count("que"));
    stringBag.add("tal");
    System.out.println(stringBag.count("que"));
    System.out.println(stringBag.sizeDistinct());
    for(String elem : stringBag.elementsDistinct()) {
      System.out.println(elem);
    }
    System.out.println(stringBag.size());
    for(String elem : stringBag.elements()) {
      System.out.println(elem);
    }
    stringBag.remove("tal");
    System.out.println(stringBag.sizeDistinct());
    System.out.println(" ---------- ");
    IterableBag<Integer> integerBag = new IterableBagImpl<>();
    try {
      integerBag.remove(2);
    } catch (NoSuchElementException e) {
      System.out.println("Test ok");
    }

    // Salida:
    // false
    // true
    // 2
    // 2
    // 3
    // tal
    // que
    // hola
    // 4
    // tal
    // que
    // que
    // hola
    // 2
    //
  }

}

