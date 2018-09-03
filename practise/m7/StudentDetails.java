/**
 * { Imports the scanner class }.
 * Author: krishnaja
 * Date: 03 september 2018
 */
import java.util.Scanner;
/**
 * Class for student details.
 */
class Student {
    private String roll_Number;
    private String student_name;
    private float m1;
    private float m2;
    private float m3;
    /**
     * Constructor initializes the person's name, roll number, and marks.
     *
     * @param      student_name  The student name
     * @param      roll_Number   The roll number
     * @param      m1            The m 1
     * @param      m2            The m 2
     * @param      m3            The m 3
     */
    Student(String student_name, String roll_Number, float m1, float m2, float m3) {
        this.student_name = student_name;
        this.roll_Number = roll_Number;       
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        }
        /**
         * function to calculate gpa.
         * @return     { returns boolean type }.
         */
        double GPA() {
            double gpa;
            gpa = (m1 + m2 + m3)/3.0D;
            return gpa;
        }
}
public class StudentDetails {
        /**
     * main function to find gpa.
     *
     * @param      args  The arguments
     */
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String name = sc.next();
    String rollno = sc.next();
    float m1 = sc.nextFloat();
    float m2 = sc.nextFloat();
    float m3 = sc.nextFloat();
    Student s = new Student(name, rollno, m1, m2, m3);
    System.out.println(s.GPA());
}    
}