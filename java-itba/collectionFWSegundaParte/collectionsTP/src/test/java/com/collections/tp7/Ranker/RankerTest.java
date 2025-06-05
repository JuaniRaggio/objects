// package com.collections.tp7.Ranker;
//
// import org.junit.jupiter.api.Test;
//
// public class RankerTest {
//
//   @Test
//   public void rankerTest() {
//     Ranker ranker = new Ranker();
//
//     Book hp7 = new Book("Harry Potter and the Deadly Hallows", "JK Rowling");
//     Book t2t = new Book("The Two Towers", "JRR Tolkien");
//     Book theHobbit = new Book("The Hobbit", "JRR Tolkien");
//     Book studyInScarlet = new Book("A Study in Scarlet", "Arthur Conan Doyle");
//     Book hamlet = new Book("Hamlet", "William Shakespeare");
//     Book prejudice = new Book("Pride and Prejudice", "Jane Austen");
//     Book eragon = new Book("Eragon", "Christopher Paolini");
//
//     ranker.add(Genre.FANTASY, hp7).add(Genre.FANTASY, theHobbit)
//       .add(Genre.FANTASY, t2t).add(Genre.FICTION, studyInScarlet)
//       .add(Genre.DRAMA, hamlet).add(Genre.DRAMA, prejudice);
//
//     ranker.rateUp(hp7);
//     ranker.rateUp(hp7);
//     ranker.rateUp(hp7);
//     ranker.rateUp(theHobbit);
//     ranker.rateUp(theHobbit);
//     ranker.rateUp(hamlet);
//     ranker.rateUp(new Book("Eragon", "Christopher Paolini"));
//     ranker.rateUp(eragon);
//
//     ranker.printRanking(Genre.FANTASY);
//     System.out.println("---------------------------------");
//     ranker.printRanking(Genre.DRAMA);
//     System.out.println("---------------------------------");
//     ranker.printRanking(Genre.CHILDREN);
//     System.out.println("---------------------------------");
//     ranker.printRanking();
//   }
//
// }
//
