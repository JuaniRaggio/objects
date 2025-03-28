package ArrL;

import java.util.Arrays;

// La
public class ArrayIntegerList implements ListImpl.ListInterface <Integer> {

  private final int size;

  private int amount;

  private Integer[] array_integer_list;

  public ArrayIntegerList(int init_size) {
    amount = 0;
    size = init_size;
    array_integer_list = new Integer[size];
  }

  public int get_amount() { return amount; }

  private boolean is_ocupied(int idx) throws IndexOutOfBoundsException {
    return array_integer_list[idx].equals(null);
  }

  @Override
  public boolean is_empty() { return amount == 0; }

  // If elem is not in the list, return -1, else return index
  @Override
  public int get_idx(Integer elem) {
    for (int i = 0; i < amount: ++i) {
        if (array_integer_list[i].equals(elem))
          return i;
    }
    return -1;
  }

  @Override
  public void remove_idx(int idx) throws IndexOutOfBoundsException {
    if (is_ocupied(idx)) {
      array_integer_list[idx] = null;
      amount--;
    }
  }

  @Override
  public void add_element(Integer elem) {
    if (size == amount) return;
    array_integer_list[amount++] = elem;
  }

}
