package ListImpl;

public interface ListInterface <T> {

  boolean is_empty();

  // If elem is not in the list, return -1, else return index
  int get_idx(T elem);

  void remove_idx(int idx);

  void add_element(T elem);

  default boolean removeElement(T to_remove) {
    int idx = get_idx(to_remove);
    if (index != -1) return removeIdx(idx);
    return false;
  }

}
