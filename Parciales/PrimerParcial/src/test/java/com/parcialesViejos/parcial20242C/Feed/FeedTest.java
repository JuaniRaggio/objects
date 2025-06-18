package com.parcialesViejos.parcial20242C.Feed;

import org.junit.jupiter.api.Test;

public class FeedTest {

  @Test
  public void feedTest() {
    Feeder feeder = new Feeder();


    // Se agrega un artículo
    Article article1 = feeder.addArticle(FeedType.RSS, "What's New in Java 23 in 2 Minutes");
    System.out.println(article1); // RSS What's New in Java 23 in 2 Minutes is unread


    article1.read(); // Se marca al artículo como leído
    System.out.println(article1); // RSS What's New in Java 23 in 2 Minutes is read


    feeder.addArticle(FeedType.PODCAST, "Episode 31 Sequenced Collections");
    feeder.addArticle(FeedType.RSS, "JVM Language Summit and Java 23!");
    feeder.addArticle(FeedType.YOUTUBE, "Java 23 - Launch Stream");
    feeder.addArticle(FeedType.YOUTUBE, "Modern Java in Action");


    // Se obtienen los artículos con el siguiente orden:
    // Primero los Podcast, luego Youtube y por último RSS
    // y a igualdad de tipo de artículo desempata alfabéticamente por título
    for(Article article : feeder.getArticlesCopy()) {
      System.out.println(article);
    }
    // PODCAST Episode 31 Sequenced Collections is unread
    // YOUTUBE Java 23 - Launch Stream is unread
    // YOUTUBE Modern Java in Action is unread
    // RSS JVM Language Summit and Java 23! is unread
    // RSS What's New in Java 23 in 2 Minutes is read


    // Se obtienen los artículos con el siguiente orden:
    // Primero los RSS, luego Youtube y por último Podcast
    // y a igualdad de tipo de artículo desempata descendente por título
    for(Article article : feeder.getReversedArticlesCopy()) {
      System.out.println(article);
    }

    // RSS What's New in Java 23 in 2 Minutes is read
    // RSS JVM Language Summit and Java 23! is unread
    // YOUTUBE Modern Java in Action is unread
    // YOUTUBE Java 23 - Launch Stream is unread
    // PODCAST Episode 31 Sequenced Collections is unread


    // El primer artículo no leído de cualquier tipo (respetando el orden de inserción)
    System.out.println(feeder.firstUnread());
    // PODCAST Episode 31 Sequenced Collections is unread
    feeder.firstUnread().read();
    System.out.println(feeder.firstUnread());
    // RSS JVM Language Summit and Java 23! is unread

    // El primer artículo no leído de tipo RSS (respetando el orden de inserción)
    System.out.println(feeder.firstUnread(FeedType.RSS));
    // RSS JVM Language Summit and Java 23! is unread


    System.out.println(feeder.firstUnread(FeedType.YOUTUBE));
    // YOUTUBE Java 23 - Launch Stream is unread


    try {
      // Se arroja un error porque no existen artículos no leídos de tipo Podcast
      feeder.firstUnread(FeedType.PODCAST);
    } catch (IllegalArgumentException ex) {
      System.out.println("Error"); // Error
    }

  }

}
