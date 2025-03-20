package SC;

public class RechargeableSubwayCard extends SubwayCard {
  private double balance;

  public RechargeableSubwayCard(SubwayCentral subway_central) {
    super(subway_central);
  }

  public void recharge(double amount) {
    balance += amount;
  }

  @Override
  protected boolean canRide() { return balance >= getSubwayCentral().getRideCost();  }

  @Override
  protected void applyCost() {
    // El super. es innecesario
    balance -= super.getSubwayCentral().getRideCost();
  }

}

