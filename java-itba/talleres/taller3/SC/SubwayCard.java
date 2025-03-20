package SC;

public abstract class SubwayCard {

  private SubwayCentral subway_central;

  public SubwayCard(SubwayCentral subway_central) {
    this.subway_central = subway_central;
  }

  protected abstract boolean canRide();

  protected abstract void applyCost();

  protected SubwayCentral getSubwayCentral() {
    return this.subway_central;
  }

  public void ride() {
    if (!canRide()) {
      System.err.println("No more rides");
      return;
    }
    applyCost();
  }

}

