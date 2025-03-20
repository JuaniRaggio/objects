package point;

public class Point_intro {

   private final double x, y;

   public Point_intro(double x, double y) {
       this.x = x;
       this.y = y;
   }

   public double getX() {
       return x;
   }

   public double getY() {
       return y;
   }

   @Override
   public String toString() {
       return "{%g, %g}".formatted(x, y);
   }
}
