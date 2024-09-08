/*
 * Level 1- Task 2: Palindrome Checker
 * 
 * Description: Implement a program that checks whether a given word or phrase is a palindrome.
 *              A palindrome is a word or phrase that reads the same forwards and backward, ignoring spaces and punctuation.
 * 
 * Skills: String manipulation, loops, conditional statements.
 */

import java.util.*;

public class PalindromeChecker {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string (or phrase): ");
        String input = sc.nextLine();

        if(isPalindrome(input))
            System.out.println(input + " is a palindrome.");
        
        else System.out.println(input + " is not a palindrome.");

        sc.close();
    }

    public static boolean isPalindrome(String input) {
        input = input.replaceAll("\\s+", "").toUpperCase();
        int left = 0, right = input.length() - 1;

        while(left < right) {
            if(input.charAt(left) != input.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
