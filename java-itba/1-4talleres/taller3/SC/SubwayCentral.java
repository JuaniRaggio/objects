package SC;

public class SubwayCentral {

  private double rideCost;

  public SubwayCentral(double rideCost) {
    setRideCost(rideCost);
  }

  public SubwayCentral() {
    SubwayCentral(0.0);
  }

  public double getRideCost() { return rideCost; }

  void setRideCost(double rideCost) { this.rideCost = rideCost; }

}

