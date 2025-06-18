package com.collections.tp7.FilterList;

import org.junit.jupiter.api.Test;

public class FilterListTest {
  
  @Test
  public void FLTest() {
    FilterList<Integer> list = new ArrayFilterList<>();
    list.add(4);
    list.add(3);
    list.add(8);
    System.out.println(list.filter(obj -> obj % 2 == 0));
  }

}
