= Ejercicio 1

```java

a.m1() = 7;
a.m2() = 7;
a.m3() = 7;

b.m1() = 3;
b.m2() = StackOverflow;
b.m3() = StackOverflow;

c.m1() = 3;
c.m2() = 9;
c.m3() = StackOverflow;

```

= Ejercicio 2

Acumulacion de puntos por compras

=== Niveles:

- *ENTRY*: Apenas se da de alta se tiene este nivel. 10% por compra en puntos

- *GOLD*: 100 puntos para ascender a este nivel. 20% por compra en puntos

- *PREMIUM*: 600 puntos desde ENTRY, 500 puntos desde GOLD. 50% por compra en 
puntos


== Membersias:

- Nombre del cliente


= Programa

- Numeracion correlativa de membersias

- Emite membersias

_Los montos de las compras y puntos son todos enteros_

- Puede desactivar el ascenso de niveles momentaneamente 
(comienza inhabilitado)

- El ascenso de nivel se realiza cuando al *momento de hacer una compra* se
alcanza el limite para subir de nivel (*Se chequea al final de la funcion de 
comprar*)

- Solo se puede ascender de un nivel al siguiente

```java

public enum Level {

  // Es mejor hacer Level.values()[ordial() + 1]
  // porque si se quiere agregar un nivel intermedio, habria que cambiar todo
  // pero no tuve en cuenta .values() la verdad (devuelve un arreglo con las
  // instancias de los enums)
  ENTRY(0.1, 100) {

    private Level levelUp() {
      return GOLD;
    }

  }, GOLD(0.2, 600) {

    private Level levelUp() {
      return PREMIUM;
    }

  }, PREMIUM(0.5, 0) {

    private Level levelUp() {
      return this;
    }

  };

  private final double multiplier;
  private final int limit;

  private Level(double multiplier, int limit) {
    this.multiplier = multiplier;
    this.limit = limit;
  }

  private Level updateLevel(int points, int limit) {
    if (points >= limit) {
      return levelUp();
    }
    return this;
  }

  public Level getUpdatedLevel(int points) {
    return updateLevel(points, limit);
  }

  public int getCorrespondingPointsOfPurchase(int purchase) {
    return (int) (purchase * multiplier);
  }

}

public class BuyerLevelProgram {

  // En principio lvlup es esto
  private boolean levelUp = false;
  private static int id = 1001;

  public void enableLevelUp() {
    levelUp = true;
  }

  public void disableLevelUp() {
    levelUp = false;
  }

  public boolean isLevelUpActive() {
    return levelUp;
  }

  public int newMemberID() {
    return id++;
  }

}

public class BuyerMember {

  private BuyerLevelProgram central;
  private String name;
  private int id, points;
  private Level currentLevel = Level.ENTRY();

  public BuyerMember(BuyerLevelProgram central, String name) {
    this.central = central;
    this.name = name;
    this.id = central.newMemberID();
    this.points = 0;
  }

  public void addPointsFromPurchase(int purchase) {
    points += currentLevel.getCorrespondingPointsOfPurchase(purchase);
    if (central.isLevelUpActive()) {
      currentLevel = Level.respectiveLevel(points);
    }
  }

  public String toString() {
    return "Member %d %s has %d points and level %s"
        .formatted(id, name, points, currentLevel.toString());
  }

}

public class InvalidPurchaseException extends Exception {

  private static final String MSG = "Invalid purchase";

  public InvalidPurchaseException() {
    super(MSG);
  }

}

```


= Ejercicio 3

Controlar estadias

- Registrar estadia: Patente + Dias

- Consultar todas las estadias con cierto orden


```java

public class Stay implements {

  private int days;
  private String plate;

  public Stay(String plate, int days) {
    this.days = days;
    this.plate = plate;
  }

  public int getDays() { return days; }

  public String getPlate() { return plate; }

}

public abstract class Garage {

  private static final int BLOCK = 10;
  private Stay[] stays = new Stay[BLOCK];
  private int dim = 0;

  protected Garage() {}

  protected Stay[] getSortedStays(Comparator<Stay> cmp) {
    Stay[] ret = Arrays.copyOf(stays, dim);
    Arrays.sort(ret, cmp);
    return ret;
  }

  private void resize() {
    stays = Arrays.copyOf(stays, dim + BLOCK);
  }

  public Garage addStay(String plate, int days) {
    if (dim == stays.length) {
      resize();
    }
    stays[dim++] = new Stay(plate, days);
    return this;
  }

  public abstract Stay[] getStaysCopy();

}

public class AscendingPlateGarage extends Garage {

  // Podria aprovecharse el Constructor y pasar el comparator en el constructor
  // Si queda el constructor asi vacio, esta bueno intentar ver si se puede
  // aprovechar
  public AscendingPlateGarage() {
    super();
  }

  public Stay[] getStaysCopy() {
    return getSortedStays((a, b) -> {
      int cmp = b.getPlate().compareTo(a.getPlate());
      if (cmp == 0) {
        cmp = a.getDays().compareTo(b.getDays());
      }
      return cmp;
    });
  }

}

public class DescendingDaysGarage extends Garage {

  public DescendingDaysGarage() {
    super();
  }

  public Stay[] getStaysCopy() {
    return getSortedStays((a, b) -> {
      int cmp = b.getDays().compareTo(a.getDays());
      if (cmp == 0) {
        cmp = a.getPlate().compareTo(b.getPlate());
      }
      return cmp;
    });
  }

}


```

