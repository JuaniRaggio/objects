package com.collections.tp7.ConcatIterator;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ConcatIteratorTest {

  @Test
  public void CITest() {
    List<String> list1 = List.of("a", "b", "c", "d");
    List<String> list2 = List.of("1", "2", "3", "4");
    List<String> list3 = List.of("alpha", "beta");
    Iterator<String> iterator = new ConcatIterator<>(
      new ConcatIterator<>(list1.iterator(), list2.iterator()),
      list3.iterator());
    while(iterator.hasNext()) {
      System.out.print(iterator.next());
    }
  }

}
