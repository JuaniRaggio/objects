= Ejercicio 1 - 3 pts
```java

a.m1() = 5;
a.m2() = 5;
a.m3() = 5;

b.m1() = StackTraceError;
b.m2() = 0;
b.m3() = StackTraceError;

c.m1() = 9;
c.m2() = 0;
c.m3() = 9;

```

= Ejercicio 2 - 3.5 pts

- Movimientos de despegues de vuelos en un aeropuerto
- *Despegue*
  - _Codigo de vuelo_ $->$ String
  - _Fecha_ $->$ LocalDate

Se desea:

+ Registrar un despegue
+ Obtener despegue x _Orden de insercion_
+ Obtener una copia de todos los despegues x O = _insercion_
+ Obtener una copia de todos los despegues x O = _parametro_
+ _Iterar_ por oreden de insercion

== Test

#table(columns : 1)[
```java
DeparturesCentral dc = new DeparturesCentral();
// Se registra un despegue del vuelo AA954 el 23/06/2022
dc.addDeparture("AA954", LocalDate.of(2022, 6, 23));
dc.addDeparture("AR1302", LocalDate.of(2022, 6, 22))
  .addDeparture("AA954", LocalDate.of(2022, 6, 22));

// Se obtiene el primer despegue registrado (por orden de inserción)
Departure firstDep = dc.getDepartureByIndex(0);
System.out.println(firstDep); // (AA954, 2022-06-23)
// Arroja un error porque se intenta obtener el cuarto despegue registrado
// (por orden de inserción) y sólo se registraron tres
try {
  dc.getDepartureByIndex(3);
} catch (Exception ex) {
  System.out.println("Error"); // Error
}
// Se obtiene una copia de los despegues registrados en orden cronológico
// y desempata alfabéticamente por código de vuelo
// y se imprimen en pantalla
System.out.println(Arrays.toString(dc.departures()));
// [(AA954, 2022-06-22), (AR1302, 2022-06-22), (AA954, 2022-06-23)]
dc.addDeparture("AC91", LocalDate.of(2022, 6, 24));
// Se obtiene una copia de los despegues registrados en orden alfabético
// por código de vuelo y desempata en orden cronológico descendente
// y se imprimen en pantalla
System.out.println(Arrays.toString(dc.departures((a, b) -> {
  int cmp = a.getCode().compareTo(b.getCode());
  if (cmp == 0) {
    cmp = b.getDate().compareTo(a.getDate());
  }
  return cmp;
}));
// [(AA954, 2022-06-23), (AA954, 2022-06-22), (AC91, 2022-06-24), (AR1302, 2022-06-22)]
// Se imprimen en pantalla todos los despegues registrados en orden de inserción
for(Departure departure : dc) {
  System.out.println(departure);
}
// (AA954, 2022-06-23)
// (AR1302, 2022-06-22)
// (AA954, 2022-06-22)
// (AC91, 2022-06-24)
```
]


== Solucion

```java

public class DeparturesCentral implemets Iterable<Departure> {

  private static final int BLOCK = 10;
  private int dim = 0;
  private Departure[] departures = new Departure[BLOCK];

  private Departure[] resize(int dim) {
    return Arrays.copyOf(departures, dim);
  }

  public Departure getDepartureByIndex(int idx) {
    if (idx >= dim) {
      throw new IllegalArgumentException();
    }
    return departures[idx];
  }

  // + Registrar un despegue
  private DeparturesCentral addDeparture(String code, LocalDate date) {
    if (dim == departures.size()) {
      departures = resize(dim + BLOCK);
    }
    departures[dim++] = new Departure(code, date);
  }

  // + Obtener despegue x _Orden de insercion_
  // + Obtener una copia de todos los despegues x O = cronologico + alfabetico 
  public Departure[] departures() {
    return departures(Comparator.naturalOrder());
  }

  public Departure[] departures(Comparator<Departure> cmp) {
    return Arrays.sort(resize(dim), cmp);
  }

  // + Obtener una copia de todos los despegues x O = _parametro_

  public Iterator<Departure> iterator() {
    return new Iterator<>() {
      private int i = 0;

      @Override
      public boolean hasNext() {
        return i < dim;
      }

      @Override
      public Departure next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return departures[i++];
      }
    }
  }


}

public class Departure implemets Comparable<Departure> {

  private final String code;
  private final LocalDate date;

  public Departure(String flightCode, LocalDate date) {
    this.code = flightCode;
    this.date = date;
  }

  @Override
  public int compareTo(Departure other) {
    int cmp = code.compareTo(other.code);
    if (cmp == 0) {
      return other.date.comapreTo(date);
    }
    return cmp;
  }

  public String getCode() { return code; }

  public LocalDate getDate() { return date; }

}


```

= Ejercicio 3

== Test

#table(columns : 1)[
```java
// Se modela una promoción que no cambia la cantidad variable de puntos
Function<Double, Double> noPromotion = new Function<Double, Double>() {
  @Override
  public Double apply(Double originalPoints) {
    return originalPoints;
  }
};
// Se crea una central seteando la promoción definida
CoffeeRewards arCentral = new CoffeeRewards(noPromotion);
// Se crea una tarjeta de tipo WELCOME para el cliente Mike
CoffeeCard c1 = arCentral.buildCard("Mike", .........................);
System.out.println(c1); // CoffeeCard 1001 from Mike with 0 points
// Se registra una compra de $100
c1.purchase(100.0); // $100 suman $100 x 10 = 1000 pts
c1.purchase(200.0); // $200 suman $200 x 10 = 2000 pts
System.out.println(c1); // CoffeeCard 1001 from Mike with 3000 points
// Se modela una promoción que duplica la cantidad variable de puntos
Function<Double, Double> doublePointsPromotion = new Function<Double, Double>() {
  @Override
  public Double apply(Double originalPoints) {
    return originalPoints * 2;
  }
};
arCentral.setPointsPromotion(doublePointsPromotion);
c1.purchase(300.0); // $300 suman ($300 x 10) x 2 = 6000 pts
System.out.println(c1); // CoffeeCard 1001 from Mike with 9000 points
// Se crea una tarjeta de tipo GREEN para el cliente Lisa
CoffeeCard c2 = arCentral.buildCard("Lisa", .........................);
c2.purchase(100.0); // $100 suman (($100 x 30) x 2) + 5 = 6005 pts
System.out.println(c2); // CoffeeCard 1002 from Lisa with 6005 points
// Se vuelve a setear la promoción que no cambia la cantidad variable de puntos
arCentral.setPointsPromotion(noPromotion);
c2.purchase(200.0); // $200 suman ($200 x 30) + 5 = 6005 pts
System.out.println(c2); // CoffeeCard 1002 from Lisa with 12010 points
CoffeeRewards brCentral = new CoffeeRewards(noPromotion);
// Se crea una tarjeta de tipo GOLD para el cliente Adam
CoffeeCard c3 = brCentral.buildCard("Adam", .........................);
System.out.println(c3); // CoffeeCard 1003 from Adam with 0 points
```
]

== Solucion

Se emiten nuevas tarjetas, la relacion que tienen entre ellas es la enumeracion
por lo tanto vamos a tener ese parametro estatico $->$ compartido entre todos

*Tarjeta*
- Nombre de cliente
- Numero
- Tipo:
  - *WELCOME* : 10 pts x peso gastado + 0
  - *GREEN* : 30 pts x peso gastado + 5
  - *GOLD* : 50 pts x peso gastado + 10


Notemos que la cuenta de las tarjetas es siempre la misma:
- Multiplicador
- Sumador

Cuando queremos aplicar una promocion, lo que hariamos es multiplicar la valor
obtenido a travez del multiplicador y luego aplicar el sumador


```java

public enum CardType {
  WELCOME(10), GREEN(30), GOLD(50);

  private final int multiplier, summer;

  private CardType(int multiplier, int summer) {
    this.multiplier = multiplier;
    this.summer = summer;
  }

  public static double multiplier(double spent) {
    return spent * multiplier;
  }

  public static double summer(double spent) {
    return spent + summer;
  }

}

public class CoffeCard {

  // Las coffecards si o si tienen que tener un puntero a coffeRewards para
  // saber como tienen que sumar puntos
  private final int cardNumber;
  private int currentPoints;
  private String name;
  private CardType type;
  private CoffeRewards central;

  public CoffeCard(String name, CardType type, int number, CoffeRewards central) {
    this.cardNumber = number;
    this.currentPoints = 0;
    this.name = name;
    this.type = type;
    this.central = central;
  }

  public String toString() {
    return "CoffeCard %d form %s with %d points".
          formatted(cardNumber, name, currentPoints);
  }

  public void purchase(double amount) {
    currentPoints += type.summer(central.promotion(type.multiplier(amount)));
  }

}

public class CoffeRewards {

  private static int numberCounter = 1000;
  private Function<Double, Double> promotion;

  public CoffeRewards(Function<Double, Double> promo) {
    setPointsPromotion(promo);
  }

  public void setPointsPromotion(Function<Double, Double> promo) {
    promotion = promo;
  }

  public CoffeCard buildCard(String customerName, CardType type) {
    return CoffeCard(customerName, type, ++numberCounter);
  }

}

```





