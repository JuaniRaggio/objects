package SC;

public class FixedSubwayCard extends SubwayCard {

  private int rides_left;

  public FixedSubwayCard(SubwayCentral subway_central, int rides) {
    // Para que pueda existir una fixed, si o si tiene que haber una subwayCard
    super(subway_central);
    rides_left = rides;
  }

  protected boolean canRide() {
    return rides_left > 0;
  }

  protected void applyCost() { --rides_left; }

}
