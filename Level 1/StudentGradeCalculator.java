/* 
 * Level 1- Task 3: Student Grade Calculator
 * 
 * Description: create a program that calculates and displays the average grade of a student.
 *              Prompt the user to enter the number of grades to be entered, and then input each grade.
 *              Calculate the average and display it to the user.
 * 
 * Skills: Loops, arrays, basic arithmetic operations.
*/

import java.util.*;

public class StudentGradeCalculator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        System.out.print("Enter the number of subjects: ");
        int numGrades = sc.nextInt();

        if(numGrades <= 0)
            System.out.println("Please enter valid number of subjects.");
        else {
            sum = 0;

            System.out.println("Enter grades (out of 10) of subjects:");
            for(int i = 0; i < numGrades; i++) {
                System.out.print("Grade "+ (i + 1) + ": ");
                double grade = sc.nextDouble();
                sum += grade;
            }

            sum /= numGrades;

            System.out.println("Average grade is: " + sum);
        }

        sc.close();
    }
}