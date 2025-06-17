= Ejercicio 1

```java

a.m1() = 1;
a.m2() = 1;
a.m3() = 1;

b.m1() = 4;
b.m2() = StackOverflow;
b.m3() = StackOverflow;

c.m1() = 4;
c.m2() = 9;
c.m3() = 9;

```

= Ejercicio 2

== Sistema de acumulacion de millas


- Membersias comparten numeracion correlativa


== Tipos de membersias

Cantidades variable de millas:

- _SILVER_: 10 millas x \$ gastado

- _GOLD_: 20 millas x \$ gastado

- _DIAMOND_: 30 millas x \$ gastado


*Promocion* $->$ cantidades extra de millas:

_La promocion empieza desactivada_

- _SILVER_: +100 millas si saldo > 1000

- _GOLD_: +500 millas si 1000 < saldo < 5000

- _DIAMOND_: +1000 millas siempre


```java

public enum Membership {

  SILVER(10, 100) {
    protected boolean qualifiesForPromo(int currentMiles) {
      return currentMiles > 1000;
    }
  }, GOLD(20, 500) {
    protected boolean qualifiesForPromo(int currentMiles) {
      return currentMiles < 5000 && currentMiles > 1000;
    }
  }, DIAMOND(30, 1000) {
    protected boolean qualifiesForPromo(int currentMiles) {
      return true;
    }
  };

  private final int multiplier, summer;

  private Membership(int multiplier, int summer) {
    this.miltiplier = multiplier;
    this.summer = summer;
  }

  protected boolean qualifiesForPromo(int currentMiles);

  public int getMultiplier() {
    return multiplier;
  }

  public int getSummer() {
    return summer;
  }

  public int updateMiles(int currentMiles, double spent, boolean applyPromo) {
    int updatedMiles = spent * getMultiplier();
    if (applyPromo && qualifiesForPromo(currentMiles)) {
      updatedMiles += getSummer();
    }
    return updatedMiles;
  }

}

public class LoyaltyProgram {

  private static int number = 1000;
  private boolean isActivePromo;

  public LoyaltyProgram() {
    setPromotionIsActive(false);
  }

  public void setPromotionIsActive(boolean value) {
    isActivePromo = value;
  }

  public int addMember() {
    return ++number;
  }

  public boolean isActivePromo() {
    return isActivePromo;
  }

}

public class LoyaltyMember {

  private LoyaltyProgram lp;
  private Membership type;
  private String name;
  private int id;
  private int miles;

  public LoyaltyMember(LoyaltyProgram lp, String name, Membership type) {
    this.lp = lp;
    this.name = name;
    this.type = type;
    this.miles = 0;
    this.id = lp.addMember();
  }

  public void addMilesFromPurchase(double spent) {
    miles += type.updateMiles(miles, spent, lp.isActivePromo());
  }

  public String toString() {
    return "Loyalty member %d from %s with %d miles".
              formatted(id, name, name, miles);
  }

}

```


= Ejercicio 3

Inventario numistarico

Se desea:

- Monedas:
  - Nombre
  - Pais de origen
  - Año de acuñacion

  - Plata
  - Oro
    - Numero de quilates correspondiente

- Agregar moneda de plata al catalogo
- Agregar moneda de oro al catalogo

- Retornar con dos ordenes:
  + Descendente por año + Desempate alfabeticamente por pais
  + Alfabeticamente por pais + Descendente por año

- A partir de un predicado retornar la primer moneda (en orden de insercion)


```java

public class CoinInventory {

  private static final int BLOCK = 10;
  private int dim = 0;
  private Coin[] inventory = new Coin[BLOCK];

  private Coin[] resize(int dim) {
    return Arrays.copyOf(inventory, dim);
  }

  private Coin[] getOrderedInventory(Comparator<Coin> cmp) {
    Coin[] cp = resize(dim);
    Arrays.sort(cp, cmp);
    return cp;
  }

  public Coin[] getMintDateCopy() {
    return getOrderedInventory((a, b) -> {
      int cmp = b.getYear().compareTo(a.getYear());
      if (cmp == 0) {
        cmp = a.getCountry().compareTo(b.getCountry());
      }
      return cmp;
    });
  }

  public Coin[] getCountriesCopy() {
    return getOrderedInvetory((a, b) -> {
      int cmp = a.getCountry().compareTo(b.getCountry());
      if (cmp == 0) {
        cmp = b.getYear().compareTo(a.getYear());
      }
      return cmp;
    });
  }

  private CoinInventory addCoin(Coin coin) {
    if (dim == inventory.length) {
      inventory = resize(dim + BLOCK);
    }
    inventory[dim++] = coin;
    return this;
  }

  public CoinInventory addSilverCoin(String name, String country, int year) {
    return addCoin(new SilverCoin(name, country, year));
  }

  public CoinInventory addGoldCoin(String name, String country, int year) {
    return addCoin(new GoldCoin(name, country, year));
  }

  public Coin getFirstCoin(Predicate<Coin> pred) {
    for (Coin coin : inventory) {
      if (pred.test(coin)) {
        return coin;
      }
    }
    throw new NoSuchElementException("No such coin");
  }

}

public abstract class Coin {

  private String name, country;
  private int year;

  protected Coin(String name, String country, int year) {
    this.name = name;
    this.country = country;
    this.year = year;
  }

  public String toString() {
    return "coin %s of %s minted in %d".formatted(name, country, year);
  }

  public String getCountry() {
    return country;
  }

  public int getYear() {
    return year;
  }

}

public class GoldCoin extends Coin {

  private int karats;

  public GoldCoin(String name, String country, int year, int karats) {
    super(name, country, year);
    this.karats = karats;
  }

  public String toString() {
    return "Golden %s with %d karats".formatted(super.toString(), karats);
  }

}

public class SilverCoin extends Coin {

  public SilverCoin(String name, String country, int year) {
    super(name, country, year);
  }

  public String toString() {
    return "Silver %s".formatted(super.toString());
  }
}

```



