= Ejercicio 3 - 3 pts

Se desea modelar un programa de televisión que cuenta con una cantidad de temporadas y una cantidad de episodios por temporada (ambos enteros positivos sino se arroja error), donde ambas se indican en el constructor. Se debe poder consultar los episodios del programa en orden ascendente por temporada y luego ascendente por episodio. Se debe ofrecer también la posibilidad de modificar los valores de temporadas y episodios por temporada una vez ya instanciado el programa de televisión. Para simplificar el ejercicio, todas las temporadas cuentan con la misma cantidad de episodios

- *Orden ascendente por temporada*
- *Orden ascendente por episodio*

== Test

```java

public static void main(String[] args) {
  // Se instancia un programa de TV de 2 temporadas, donde cada una tiene 3 episodios
  TVShow sherlock = new TVShow(2, 3);
  for(TVEpisode episode : sherlock) {
    // Se consultan los 6 episodios de la serie
    System.out.printf("%s # ", episode);
  }
  System.out.println();
  // [S01E01] # [S01E02] # [S01E03] # [S02E01] # [S02E02] # [S02E03] #
  Iterator<TVEpisode> sherlockIt = sherlock.iterator();
  sherlock.setSeasons(1); // Se modifica la cantidad de temporadas a 1
  sherlock.setEpisodesPerSeason(2); // Se modifica la cantidad de episodios a 2
  System.out.println(sherlock.iterator().next()); // [S01E01]
  while(sherlockIt.hasNext()) { // Se consultan los 6 episodios de la serie
    System.out.printf("%s # ", sherlockIt.next());
  }
  System.out.println(); // [S01E01] # [S01E02] # [S01E03] # [S02E01] # [S02E02] # [S02E03] #
  for(TVEpisode episode : sherlock) { // Se consultan los 2 episodios de la serie
    System.out.printf("%s # ", episode);
  }
  try {
    System.out.println(); // [S01E01] # [S01E02] #
    sherlock.setEpisodesPerSeason(0);
  } catch (Exception ex) {
    System.out.println(ex.getMessage());
    // La cantidad de episodios debe ser positiva.
  }
}

```

== Solucion

```java

public class TVShow implements Iterable<TVEpisode> {
  private int ep, tmp;

  public TVShow(int seasons, int episodes) {
    setEpisodesPerSeason(episodes);
    setSeasons(seasons);
  }

  public void setEpisodesPerSeason(int ep) {
    if (ep <= 0) {
      throw new IllegalArgumentException("La cantidad de episodios debe ser positiva");
    }

    this.ep = ep;
  }

  public void setSeasons(int seasons) {
    if (seasons <= 0) {
      throw new IllegalArgumentException("La cantidad de temporadas debe ser positiva")
    }
    tmp = seasons;
  }

  public Iterator<TVEpisode> iterator() {
    return new Iterator<>() {

      private int episodes = ep, seasons = tmp, currentEp = 1, currentSeason = 1;

      @Override
      public boolean hasNext() {
        return currrentEp != episodes || currentSeason != seasons;
      }

      @Override
      public TVEpisode next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        if (currentEp == episodes) {
          currentEp = 1;
          currentSeason += 1;
        } else {
          currentEp += 1;
        }
        return new TVEpisode(currentEp, currentSeason);
      }

    }
  }

  public static class TVEpisode {

    private int e, s;

    public TVEpisode(int e, int s) {
      this.e = e;
      this.s = s;
    }

    @Override
    public String toString() {
      return "[S%2dE%2d]".formatted(s, e);
    }

  }

}

```

