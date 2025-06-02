package com.collections.tp7.Ranker;

public class Book {

  private String title, author;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author);
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof Book that && title.equals(that.title) && title.equals(that.author);
  }

}
