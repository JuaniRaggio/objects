import java.util.ArrayList;
import java.util.Optional;

public class Affiliate {

  // Affiliate number viene dado por el indice en donde se encuentra la persona

  private final int nombre = 1;
  private final int apellido = 2;
  private final int fecha_nac = 3;

  private ArrayList<String[]> affs = new ArrayList<>();
  
  public Affiliate(String nombre, String apellido,
                    String fecha_nac) {
    String[] person =  {nombre, apellido, fecha_nac};
    this.affs.add(person);
  }
  
  public String get_name(int affiliate_number) { return affs.get(affiliate_number)[nombre]; }
  public String get_surname(int affiliate_number) { return affs.get(affiliate_number)[apellido]; }
  public int get_last_affiliate_number(int affiliate_number) { return affs.size(); }
  public String get_fecha_nac(int affiliate_number) { return affs.get(affiliate_number)[fecha_nac]; }

}
