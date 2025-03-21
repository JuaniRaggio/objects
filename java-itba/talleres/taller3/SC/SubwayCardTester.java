package SC;

public class SubwayCardTester {

  public static void main(String[] args) {
    SubwayCentral sc = new SubwayCentral(25);

    FixedSubwayCard fsc = new FixedSubwayCard(sc, 2);
    try {
      fsc.ride();
      fsc.ride();
      fsc.ride(); // Imprime un mensaje de error
    } catch (CannotRideException ex) {
      System.err.println(ex.getMessage());
    }

    RechargeableSubwayCard rsc = new RechargeableSubwayCard(sc);
    rsc.recharge(50);
    try {
      rsc.ride();
    } catch (CannotRideException ex) {
      System.err.println(ex.getMessage());
    }
    sc.setRideCost(30);
    try {
      rsc.ride(); // Imprime un mensaje de error
    } catch (CannotRideException ex) {
      System.err.println(ex.getMessage());
    }

    DiscountRechargeableSubwayCard drsc = new DiscountRechargeableSubwayCard(sc, 0.50);
    drsc.recharge(30);
    try{
      drsc.ride();
      drsc.ride();
      drsc.ride(); // Imprime un mensaje de error
    } catch(CannotRideException ex) {
      System.err.println(ex.getMessage());
    }
  }

}
