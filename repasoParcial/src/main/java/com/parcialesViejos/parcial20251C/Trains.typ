#import "@preview/codly:1.3.0"
*Atencion*: este ejercicio se realiza de forma ineficiente ya que el objetiivo es entender como funciona Comparable, Comparator, Iterable, Iterator. Usando colecciones se haria muchisimo mas eficiente, pero no es el objetivo.
= Ejercicio 2 - 3.5 pts

Se desea modelar un tablero de partidas de una estación de tren que cuenta con un tiempo (en horas y minutos) para así distinguir a los trenes que ya partieron de la estación de los que no. El tiempo de la estación se indica por constructor y debe poder ser modificado una vez ya instanciado el tablero

Para agregar una partida se invoca al método addDeparture indicando el tiempo de partida (en horas y minutos), el nombre de destino y el número de plataforma. *No se debe permitir agregar partidas repetidas*, esto es, si ya existe una partida con el mismo tiempo, destino y plataforma, retornar false y no agregarla. De lo contrario agrega la partida y retorna true.

En cualquiera de los tres casos se indica el tiempo de partida, el destino, la plataforma y un texto “DEPARTED” si el tiempo de la partida es posterior al del tablero y “ON TIME” sino.
Para simplificar el ejercicio, se espera que cada invocación a addDeparture realice un recorrido por todas las partidas agregadas y no es necesario optimizarlo. Además el tablero es para un único día, si el tiempo de la estación es “00:00” ninguna de las partidas habrá partido de la
estación.

- _Estacion de tren_
- *tiempo*
- boolean addDeparture(time, String name, String destination, int platform): Agrega una partida con los respectivos parametros
- Consulta de partidas de 3 formas distintas:
+ _Insercion_
+ _Descendente por platform_, _cronologico por tiempo_ y _alfabetico por destino_
+ _Ascendente por platform_, _cronologico inverso_ y _descendente por destino_ (Comparator.reverseOrder() de el item 2.)

== Test

#table()[
```java
public static void main(String[] args) {
  // Ejemplo de uso de la clase java.time.LocalTime
  LocalTime currentTime = LocalTime.of(18,13);
  System.out.println(currentTime.isAfter(LocalTime.of(18,11))); // true
  // Se instancia un tablero de partidas donde el tiempo actual del tablero es 18:13
  DeparturesBoard board = new DeparturesBoard(currentTime);
  // Se agrega una partida al tablero de partidas, para el tren que sale a las 18:35
  // con destino a Swindown desde la plataforma 3, indica true porque se agregó con éxito
  System.out.println(board.addDeparture(LocalTime.of(18,35),
  "Swindown"
  , 3)); // true
  System.out.println(board.addDeparture(LocalTime.of(18,36),
  "Salisbury"
  , 1)); // true
  System.out.println(board.addDeparture(LocalTime.of(18,44),
  "Gloucester"
  , 2)); // true
  // Se obtienen las partidas en orden DE INSERCIÓN
  for (Departure departure : board.getDepartures()) {
    System.out.println(departure);
  }
  // 18:35 | Swindown | P03 | ON TIME
  // 18:36 | Salisbury | P01 | ON TIME
  // 18:44 | Gloucester | P02 | ON TIME
  System.out.println(board.addDeparture(LocalTime.of(18,35),
  "Weymouth"
  , 2)); // true
  // Como ya existe otra partida en el tablero otra partida con el mismo
  // tiempo, destino y plataforma no se agrega, indica false
  System.out.println(board.addDeparture(LocalTime.of(18,35),
  "Weymouth"
  , 2)); // false
  // Se modifica el tiempo actual del tablero a 18:36
  board.setCurrentTime(LocalTime.of(18,36));
  // Se obtienen las partidas en orden DE INSERCIÓN
  for (Departure departure : board.getDepartures()) {
    System.out.println(departure);
  }
  // 18:35 | Swindown | P03 | DEPARTED
  // 18:36 | Salisbury | P01 | ON TIME
  // 18:44 | Gloucester | P02 | ON TIME
  // 18:35 | Weymouth | P02 | DEPARTED
  // Se obtienen las partidas en orden DESCENDENTE por plataforma,
  // y desempata CRONOLOGICO por tiempo y ALFABETICO por estación
  for (Departure departure : board.getDeparturesDescendingByPlatform()) {
    System.out.println(departure);
  }
  // 18:35 | Swindown | P03 | DEPARTED
  // 18:35 | Weymouth | P02 | DEPARTED
  // 18:44 | Gloucester | P02 | ON TIME
  // 18:36 | Salisbury | P01 | ON TIME
  board.setCurrentTime(LocalTime.of(18,37));
  // Se obtienen las partidas en orden ASCENDENTE por plataforma,
  // y desempata DESCENDENTE por tiempo y DESCENDENTE por estación
  for (Departure departure : board.getDeparturesAscendingByPlatform()) {
    System.out.println(departure);
  }
  // 18:36 | Salisbury | P01 | DEPARTED
  // 18:44 | Gloucester | P02 | ON TIME
  // 18:35 | Weymouth | P02 | DEPARTED
  // 18:35 | Swindown | P03 | DEPARTED
}
```
]

== Solucion

```java

public class DeparturesBoard {

  private LocalTime current;
  private Departure[] board = new ArrayList<>();

  public DeparturesBoard(LocalTime time) {
    current = time;
  }

  public Departure[] getDepartures(Comparator<Departure> cmp) {
    return getDepartures().sort(cmp);
  }

  public Departure[] getDeparturesDescendingByPlatform() {
    return getDepartures(Comparator.naturalOrder());
  }

  public Departure[] getDeparturesAscendingByPlatform() {
    return getDepartures(Comparator.reverseOrder());
  }

  public Departure[] getDepartures() {
    return Arrays.copyOf(board);
  }

  public boolean addDeparture(LocalTime departureTime,
  String destination, int platform) {
    Departure toAdd = new Departure(departureTime, destination, platform, this);
    for (Departure d: board) {
      if (d.compareTo(toAdd) == 0) {
        return false;
      }
    }
    board.add(toAdd);
    return true;
  }

}

public class Departure implements Comparable<Departure> {

  private DeparturesBoard db;

  private LocalTime departureTime;
  private String destination;
  private int platformNumber;

  public Departure(LocalTime time, String destination, int platform, 
                    DeparturesBoard db) {
    this.db = db;
    this.departureTime = time;
    this.destination = destination;
    this.platformNumber = platform;
  }

  @Override
  public int comapreTo(Departure other) {
    int cmp = platformNumber.compareTo(other.platformNumber);
    if (cmp == 0) {
      cmp = departureTime.compareTo(other.departureTime);
      if (cmp == 0) {
        return destination.compareTo(other.destination);
      }
    }
    return cmp;
  }

  @Override
  public String toString() {
    return "%s | %s | P%2d | %s".formatted(time, destination, platform, time.isAfter(db.getTime()) ? "DEPARTED":"ONTIME");
  }

}

```

