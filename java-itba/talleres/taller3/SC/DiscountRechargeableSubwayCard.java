package SC;

public class DiscountRechargeableSubwayCard extends RechargeableSubwayCard {

  private double discountPercentage;

  public DiscountRechargeableSubwayCard(SubwayCentral subway_central, double dp) {
    super(subway_central);
    discountPercentage = dp;
  }

  protected double rideCost() {
    return super.getSubwayCentral().getRideCost() * (1 - discountPercentage/100);
  }

}
