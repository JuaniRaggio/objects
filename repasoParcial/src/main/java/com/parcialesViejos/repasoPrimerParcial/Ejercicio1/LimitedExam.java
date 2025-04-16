package com.parcialesViejos.repasoPrimerParcial.Ejercicio1;

import java.util.Arrays;

public class LimitedExam extends UniqueExam {

  private String[] pendingStudents;
  private int nextToLeave = 0, currentPendingStudents = 0;

  public LimitedExam(String examName, int limit) {
    super(examName);
    pendingStudents = new String[limit];
  }

  @Override
  public void enroll(String studentName) {
    if (currentPendingStudents == pendingStudents.length) {
      super.enroll(studentName);
      return;
    }
    pendingStudents[currentPendingStudents++] = new String(studentName);
    System.out.println("Enrolled %s".formatted(studentName));
  }

  @Override
  public void unenroll(String studentName) {
    int i = 0, found = 0;
    while (i < currentPendingStudents) {
      if (pendingStudents[i].equals(studentName)) {
        found = 1;
        System.out.println("Unenrolled " + studentName);
      }
    }
    nextToLeave += found;
  }

  public String[] getPendingStudents() {
    return super.getEnrolledStudents();
  }

}
