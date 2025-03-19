package histograma;
import histograma.*;

public class Main {
  public static void main(String[] args) {
    Histograma mi_histograma = new Histograma(10);
    mi_histograma.histogram_data_collector(args);
    mi_histograma.show_histogram();
  }
}

