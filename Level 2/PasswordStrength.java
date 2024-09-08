/*
 * Level 2- Task 2: Password Strength Checker
 * 
 * Description: Create a program that checks the strength of a password.
 *              Prompt the user to input a password and analyze its strength based on certain criteria, such as length,
 *              presence of uppercase letters, lowercase letters, numbers, and special characters.
 *              Provide feedback on the password strength.
 * 
 * Skills: String manipulation, conditional statements.
 */

import java.util.*;
import java.util.regex.*;

public class PasswordStrength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        String strength = checkStrength(password);
        System.out.println("Password strength: " + strength);

        sc.close();
    }

    public static String checkStrength(String password) {
        int length = password.length();

        if (length < 8)
            return "Weak (Too Short)";

        if (!containsDigit(password))
            return "Weak (Missing digit)";

        if (!containsUppercase(password))
            return "Weak (Missing uppercase letter)";

        if (!containsLowercase(password))
            return "Weak (Missing lowercase letter)";

        if (!containsSpecial(password))
            return "Moderate (No special character)";

        return "Strong";
    }

    public static boolean containsDigit(String password) {
        return Pattern.compile("[0-9]").matcher(password).find();
    }

    public static boolean containsUppercase(String password) {
        return Pattern.compile("[A-Z]").matcher(password).find();
    }

    public static boolean containsLowercase(String password) {
        return Pattern.compile("[a-z]").matcher(password).find();
    }

    public static boolean containsSpecial(String password) {
        return Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?/").matcher(password).find();
    }
}