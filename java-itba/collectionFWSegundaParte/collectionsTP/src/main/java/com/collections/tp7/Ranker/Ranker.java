package com.collections.tp7.Ranker;

public class Ranker {

  // Correcto
  private Set<RankedBook> ranking = new TreeSet<>();

  public Ranker add(Genre genre, Book book) {
    if (!byGenre.containsKey(genre)) {
      byGenre.put(genre, new TreeSet<RankedBook>);
    }
    RankedBook toAdd = new RankedBook(book);
    ranking.add(toAdd);
    byGenre.get(genre).add(toAdd);
    return this;
  }

  public void rateup(Book book) {
  }

}
