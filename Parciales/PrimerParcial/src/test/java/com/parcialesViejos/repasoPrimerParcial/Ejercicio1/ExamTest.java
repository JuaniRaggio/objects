// package com.parcialesViejos.repasoPrimerParcial.Ejercicio1;
//
// import java.util.Arrays;
//
// import org.junit.jupiter.api.Test;
//
// public class ExamTest {
//
//   @Test
//   public void examTester() {
//     Exam exam = new Exam("Primer Parcial PI");
//     exam.enroll("Matias");
//     exam.enroll("Matias");
//     exam.enroll("Natalia");
//     System.out.println("Enrolled Students: " + Arrays.toString(exam.getEnrolledStrudents()));
//     exam.unenroll("Matias");
//     System.out.println("Enrolled Students: " + Arrays.toString(exam.getEnrolledStrudents()));
//     System.out.println("##########");
//
//     UniqueExam uniqueExam = new UniqueExam("Primer Parcial POO");
//     uniqueExam.enroll("Matias");
//     uniqueExam.enroll("Matias");
//     uniqueExam.enroll("Natalia");
//     System.out.println("Enrolled Students: " + Arrays.toString(uniqueExam.getEnrolledStrudents()));
//     uniqueExam.unenroll("Matias");
//     System.out.println("Enrolled Students: " + Arrays.toString(uniqueExam.getEnrolledStrudents()));
//     System.out.println("##########");
//
//     LimitedExam limitedExam = new LimitedExam("TPE POD", 2);
//     limitedExam.enroll("Matias");
//     limitedExam.enroll("Matias");
//     limitedExam.enroll("Natalia");
//     limitedExam.enroll("Solange");
//     limitedExam.enroll("Jose");
//     limitedExam.enroll("Micaela");
//     System.out.println("Enrolled Students: " + Arrays.toString(limitedExam.getEnrolledStrudents()));
//     System.out.println("Pending Students: " + Arrays.toString(limitedExam.getPendingStudents()));
//     limitedExam.unenroll("Matias");
//     System.out.println("Enrolled Students: " + Arrays.toString(limitedExam.getEnrolledStrudents()));
//     System.out.println("Pending Students: " + Arrays.toString(limitedExam.getPendingStudents()));
//     limitedExam.unenroll("Jose");
//     limitedExam.unenroll("Natalia");
//     System.out.println("Enrolled Students: " + Arrays.toString(limitedExam.getEnrolledStrudents()));
//     System.out.println("Pending Students: " + Arrays.toString(limitedExam.getPendingStudents()));
//   }
//
// }
