package com.parcialesViejos.parcial20242C.Feed;

public class Article implements Comparable<Article> {

  private final FeedType type;
  private final String title;
  private boolean read = false;

  public Article(FeedType type, String title) {
    this.title = title;
    this.type = type;
  }

  public void read() {
    read = true;
  }

  @Override
  public int compareTo(Article other) {
    int cmp = Integer.compare(this.type.ordinal(), other.type.ordinal());
    if (cmp == 0) {
      cmp = this.title.compareTo(other.title);
    }
    return cmp;
  }

  @Override
  public String toString() {
    return type.toString() + " %s ".formatted(title) + " is %s".formatted(read ? "read" : "unread");
  }

  public boolean isRead() { return read; }

  public String getTitle() { return title; }

  public FeedType getType() { return type; }

}
