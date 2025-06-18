package com.collections.tp7.SimpleList;

import org.junit.jupiter.api.Test;

public class SimpleListTest {

  @Test
  public void SLTest() {
    SimpleList<Integer> simpleList = new SimpleArrayList<>();

    simpleList.add(1);
    simpleList.add(3);
    simpleList.add(5);
    simpleList.add(7);

    System.out.println(simpleList.size()); // 4

    System.out.println(simpleList.contains(0)); // false

    Integer sum = simpleList.reduce(0, (accum, value) -> accum + value);
    System.out.println(sum); // 16 => 0 + 1 + 3 + 5 + 7

    SimpleList<Integer> emptyList = new SimpleArrayList<>();

    Integer emptySum = emptyList.reduce(0, (accum, value) -> accum + value);
    System.out.println(emptySum); // 0 => 0

    Integer prod = simpleList.reduce(1, (accum, value) -> accum * value);
    System.out.println(prod); // 105 => 1 * 1 * 3 * 5 * 7

    Integer emptyProd = emptyList.reduce(1, (accum, value) -> accum * value);
    System.out.println(emptyProd); // 1 => 1

    String s = simpleList.reduce("", (accum, value) -> accum + "<%d>".formatted(value));
    System.out.println(s); // <1><3><5><7> => "" + "<1>" + "<3>" + "<5>" + "<7>"

    String t = emptyList.reduce(".", (accum, value) -> accum + "<%d>".formatted(value));
    System.out.println(t); // . => "."
  }

}
