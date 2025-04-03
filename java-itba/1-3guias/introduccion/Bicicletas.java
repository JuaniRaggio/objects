public class Bicicletas {

  private int chainring;
  private double cog;
  private double ratio;

  public Bicicletas(int chainring, double cog, double ratio) {
    this.chainring = chainring;
  }

  public double get_ratio() {
    return ratio;
  }

  public void set_ratio(double new_ratio) {
    ratio = new_ratio;
  }

  public void set_chainring(int new_chainring) {
    chainring = new_chainring;
  }

  public void set_cog(double new_cog) {
    cog = new_cog;
  }

}

