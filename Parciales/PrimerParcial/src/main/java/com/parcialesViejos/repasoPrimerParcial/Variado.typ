= Rooms Parcial 2024 2C

- Sistema de reservas

== Clientes:
  - Metodo para reservar a partir de un tipo especificado, cant hue, cant noches
  Verificar cant hue
  Verificar cant noches

  - Consulta de nombre

  - Consulta de cantidad de reservas hechas al momento. 
  Notemos que esto es de alguna forma esta relacionado a la "cantidad de reservas posibles"

- Tourist: Nombre, monto a gastar

- Ejecutive: Nombre, cantidad de reservas posibles

== Habitaciones
Si se supera la cantidad maxima de huespedes, se arroja error

- Simple: 1 hue, 1000 x dia

- Suite: 4 hue max, 3000 x dia

```java

public enum Rooms {

  SIMPLE(1000, 1), SUITE(3000, 4);

  private int cost, customers;

  private Rooms(int cost, int customers) {
    this.cost = cost;
    this.customers = customers;
  }

  public boolean canBook(int customers) {
    return this.customers <= customers;
  }

  public int prize(int nights) {
    return cost * nights;
  }

}

public abstract class Client {

  private String name;
  private int bookings;

  public Client(String name) {
    this.name = name;
    this.bookings = 0;
  }

  public String getName() { return name; }
  public int getBookings() { return bookings; }

  public String toString() {
    return "Client %s made %d bookings".formatted(name, bookings);
  }

  protected abstract void pay(Rooms type, int customers, int nights);

  protected abstract boolean canAfford(int prize);

  public void bookRoom(Rooms type, int customers, int nights) {
    if (!type.canBook(customers) || !canAfford(type.prize(nights)) || nights < 0 || customers < 0) {
      throw new CannotBookException();
    }
    pay(type, nights);
    bookings++;
  }

}

public class Tourist extends Client {

  private int moneyLeft;

  public Tourist(String name, int money) {
    super(name);
    this.moneyLeft = money;
  }

  protected boolean canAfford(int prize) {
    return Integer.compare(moneyLeft, prize) > 0;
  }

  protected void pay(Rooms type, int nights) {
    moneyLeft -= type.prize(nights);
  }

}

public class Ejecutive extends Client {

  private final int limit;

  public Ejecutive(String name, int limit) {
    super(name);
    this.limit = limit;
  }

  // Currently no payment required
  protected void pay(Rooms type, int customers, int nights) {}

  protected boolean canAfford(int prize) {
    return Integer.compare(getBookings(), limit) < 0;
  }

}

public class CannotBookException extends Exception {

  private static final String msg = "Cannot book";

  public CannotBookException() {
    super(msg);
  }

}

```


= FootballMatches 2022 2C

Este habia salido bastante bien, no tiene mucho sentido de rehacerlo
los que pueden joder son los de enum


= Levels - Memberships 2024 1C

Existen 3 niveles posibles:

- ENTRY: Inicial y 10% de la compra en puntos

- GOLD: 100 puntos desde ENTRY y 20% de la compra en puntos

- PREMIUM: 600 puntos desde ENTRY y 50% de la compra en puntos

Desde el programa se desea poder habilitar y deshabilitar la suba de niveles momentaneamente (inicia deshabilitado)

Solo se puede ascender de a un nivel


```java

public enum Level {

  ENTRY(0.1) {
    public boolean levelUp(int points) {
      return points >= 100;
    }
  }, GOLD(0.2) {

    public boolean levelUp(int points) {
      return points >= 600;
    }

  }, PREMIUM(0.5) {

    public boolean levelUp(int points) {
      return false;
    }

  };

  private double extra;

  private Level(double extra) {
    this.extra = extra;
  }

  public int pointsFromPurchase(int purchase) {
    return purchase * extra;
  }

  public Level updateLevel(int points) {
    if (levelUp(points)) {
      return Level.values()[ordial() + 1];
    }
    return this;
  }

}

public class BuyerLevelProgram {

  private boolean isActiveLevelUp = false;
  private static int IDs = 1001;

  public void enableLevelUp() { isActiveLevelUp = true; }

  public void disableLevelUp() { isActiveLevelUp = false; }

  public getNewId() { return IDs++; }

}

public class BuyerMember {

  private Level level = Level.ENTRY;
  private BuyerLevelProgram blp;
  private int id;
  private int points;

  public BuyerMember(BuyerLevelProgram blp, String name) {
    this.name = name;
    this.blp = blp;
    this.id = blp.getNewId();
  }

  public String toString() {
    return "Member %d %s has %d %s".formatted(id, name, points, level.toString());
  }

  public void addPointsFromPurchase(int purchase) {
    if (purchase < 0) {
      throw new InvalidPurchaseException();
    }
    points += level.pointsFromPurchase(purchase);
    level = level.updateLevel(points);
  }

}

public class InvalidPurchaseException extends Exception {
  private String msg = "Invalid purchase";

  public InvalidPurchaseException() {
    super(msg);
  }
}

```

