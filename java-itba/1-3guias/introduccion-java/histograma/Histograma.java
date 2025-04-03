package histograma;

public class Histograma {
  private final int default_size = 10;
  private int HISTOGRAM_SIZE;
  private int[] histogram = new int[HISTOGRAM_SIZE];
  private int max_value;

  public Histograma() {
    HISTOGRAM_SIZE = default_size;
  }

  public Histograma(int histogram_size) {
    this.HISTOGRAM_SIZE = histogram_size;
  }

  public void show_histogram() {
    // TODO
  }

  public void histogram_data_collector(String[] data) {
    for (String extraction : data) {
      try {
        int respective_index = (int) Integer.parseInt(extraction)/HISTOGRAM_SIZE;
        max_value = ++histogram[respective_index] > max_value ? histogram[respective_index]:max_value;
      } catch (NumberFormatException ex) {
        System.out.println(extraction + ": is not a valid data, expected: Integer");
      }
    }
  }

  public int get_size() { return HISTOGRAM_SIZE; }

}
