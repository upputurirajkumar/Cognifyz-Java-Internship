/*
 * Level 2- Task 3: File Encryption/Decryption
 * 
 * Description: Create a program that encrypts or decrypts the contents of a text file using a simple
 *               encryption algorithm. Prompt the user to choose between encryption or decryption, and input the
 *               file name or path. Encrypt or decrypt the file accordingly and save the result to a new file.
 * 
 * Skills: File handling, string manipulation, basic input/output operations.
 */

import java.io.*;
import java.util.*;

public class FileEncryptDecrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 'E' for encryption or 'D' for decryption: ");
        String choice = sc.nextLine().toUpperCase();

        if(choice.equals("E") || choice.equals("D")) {
            System.out.print("Enter the filename or path: ");
            String filename = sc.nextLine();
            System.out.print("Enter the key (integer): ");
            int key = sc.nextInt();

            if(choice.equals("E"))
                encryptFile(filename, key);
            else decryptFile(filename, key);
        }
        else System.out.println("Invalid choice. Please try again.");

        sc.close();
    }

    public static void encryptFile(String inputFileName, int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted.txt"))) {

            int character;
            while ((character = reader.read()) != -1) {
                if (Character.isLetter(character)) {
                    char encryptedChar = (char) (character + key);
                    if (Character.isUpperCase((char) character)) {
                        if (encryptedChar > 'Z') {
                            encryptedChar -= 26;
                        }
                    } else {
                        if (encryptedChar > 'z') {
                            encryptedChar -= 26;
                        }
                    }
                    writer.write(encryptedChar);
                } else {
                    writer.write(character);
                }
            }

            System.out.println("File encrypted successfully. Encrypted data saved in 'encrypted.txt'.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptFile(String inputFileName, int key) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted.txt"))) {

            int character;
            while ((character = reader.read()) != -1) {
                if (Character.isLetter(character)) {
                    char decryptedChar = (char) (character - key);
                    if (Character.isUpperCase((char) character)) {
                        if (decryptedChar < 'A') {
                            decryptedChar += 26;
                        }
                    } else {
                        if (decryptedChar < 'a') {
                            decryptedChar += 26;
                        }
                    }
                    writer.write(decryptedChar);
                } else {
                    writer.write(character);
                }
            }

            System.out.println("File decrypted successfully. Decrypted data saved in 'decrypted.txt'.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
