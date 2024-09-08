/*
 * Level 1- Task 4: Random Password Generator
 * 
 * Description: Build a program that generates a random password for the user.
 *              Prompt the user to enter the desired length of the password and
 *              specify whether it should include numbers, lowercase letters, uppercase letters, and special characters.
 *              Generate the password accordingly and display it to the user.
 * 
 * Skills: Random number generation, string manipulation, user input. 
 */

import java.security.*;
import java.util.*;

public class RandomPasswordGenerator {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String numbers = "0123456789",
            lowercaseLetters = "abcdefghijklmnopqrstuvwxyz",
            uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            specialCharacters = "!@#$%^&*()-_=+/?><,.;:[]{}₹|";

        System.out.print("Enter the desired length of your password: ");
        int length = sc.nextInt();

        System.out.print("Should the password include numbers (yes/no): ");
        boolean includeNumbers = sc.next().equalsIgnoreCase("yes");

        System.out.print("Should the password include lowercase letters (yes/no): ");
        boolean includeLowercase = sc.next().equalsIgnoreCase("yes");

        System.out.print("Should the password include uppercase letter (yes/no): ");
        boolean includeUppercase = sc.next().equalsIgnoreCase("yes");

        System.out.print("Should the password include special chracters (yes/no): ");
        boolean includeSpecial = sc.next().equalsIgnoreCase("yes");

        if(!includeNumbers && !includeLowercase && !includeUppercase && !includeSpecial)
            System.out.println("Please enter at least one character type.");
        
        else {
            String allowChars = "";

            if(includeNumbers)
                allowChars += numbers;

            if(includeLowercase)
                allowChars += lowercaseLetters;

            if(includeUppercase)
                allowChars += uppercaseLetters;

            if(includeSpecial)
                allowChars += specialCharacters;
            
            String password = generateRandomPassword(allowChars, length);
            System.out.println("Generated password: " + password);
        }

        sc.close();
    }

    public static String generateRandomPassword(String allowChars, int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for(int i = 0; i < length; i++) {
            int randomInd = random.nextInt(allowChars.length());
            char randomChar = allowChars.charAt(randomInd);
            password.append(randomChar);
        }

        return password.toString();
    }
}