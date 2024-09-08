/*
 * Level 1- Task 1: Temperature Converter
 * 
 * Description: Create a program that converts temperatures between Celsius and Fahrenheit.
 *              Prompt the user to enter a temperature value and the unit of measurement, and then perform the conversion.
 *              Display the converted temperature.
 * 
 * Skills: Basic input/output operations, arithmetic operations.
*/

import java.util.*;

public class TemperatureConverter {
    public static void main(String args[]) {
        double tempCelsius, tempFahrenheit;
        int choice;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter choice:\n1: Convert temperature from \u00B0C to \u00B0F.");
        System.out.println("2: Convert temperature from \u00B0F to \u00B0C.");
        choice = sc.nextInt();

        if(choice == 1){

            System.out.print("Enter temperature in \u00B0C: ");
            tempCelsius = sc.nextDouble();

            tempFahrenheit = (tempCelsius * 9/5) + 32;

            System.out.println(tempFahrenheit + "\u00B0F\n");

            System.out.println();

        } else if(choice == 2){

            System.out.print("Enter temperature in \u00B0F: ");
            tempFahrenheit = sc.nextDouble();

            tempCelsius = (tempFahrenheit - 32) * (5/9);

            System.out.println(tempCelsius + "\u00B0C\n");

            System.out.println();

        } else {
            System.out.println("Invalid choice. Try again.\n");
            System.out.println();
        }

        sc.close();
    }
}