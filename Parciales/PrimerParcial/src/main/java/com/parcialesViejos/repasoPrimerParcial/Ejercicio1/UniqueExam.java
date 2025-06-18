package com.parcialesViejos.repasoPrimerParcial.Ejercicio1;

public class UniqueExam extends Exam {

  public UniqueExam(String examName) {
    super(examName);
  }

  @Override
  public void enroll(String studentName) {
    if (isEnrolled(studentName))
      return;
    super.enroll(studentName);
  }
    
}
