package com.parcialesViejos.parcial20242C.Feed;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class Feeder {

  private int savedArticles = 0;
  private final int BLOCK = 8;
  private Article[] feed = new Article[BLOCK];

  public Article addArticle(FeedType type, String title) {
    return feed[savedArticles++] = new Article(type, title);
  }

  private Article[] copyAndSortByComparator(Comparator<Article> cmp) {
    Article[] returnValue = Arrays.copyOf(feed, savedArticles);
    Arrays.sort(returnValue, cmp);
    return returnValue;
  }

  public Article[] getArticlesCopy() {
    return copyAndSortByComparator(Comparator.naturalOrder());
  }

  public Article[] getReversedArticlesCopy() {
    return copyAndSortByComparator(Comparator.reverseOrder());
  }

  protected Article getFirstWhoAssertsTrue(Function<Article, Boolean> assertion) {
    for (int i = 0; i < savedArticles; ++i) {
      if (assertion.apply(feed[i]))
        return feed[i];
    }
    throw new IllegalArgumentException();
  }

  public Article firstUnread() {
    return getFirstWhoAssertsTrue((a) -> !a.isRead());
  }

  public Article firstUnread(FeedType type) {
    return getFirstWhoAssertsTrue((a) -> a.getType().equals(type) && !a.isRead());
  }
  
}
