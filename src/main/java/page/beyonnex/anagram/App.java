package page.beyonnex.anagram;

import java.util.InputMismatchException;
import java.util.Scanner;
import page.beyonnex.anagram.utils.AnagramUtils;

public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Anagram App!\n");
        System.out.println("*************************************************");
        System.out.println("*       Welcome to the Anagram Explorer         *");
        System.out.println("*  Unravel the world of words with Beyonnex.io  *");
        System.out.println("*              and Michael Page!                *");
        System.out.println("*************************************************");

        while (true) {
            System.out.println("\nAnagram App");
            System.out.println("Please select an option: ");
            System.out.println("1 - Check if two texts are anagrams of each other");
            System.out.println("2 - Get all the anagrams for a given string");
            System.out.println("3 - Clear the memory");
            System.out.println("4 - Exit the program");
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        AnagramUtils.checkAnagrams(scanner);
                        break;
                    case 2:
                        AnagramUtils.getAnagrams(scanner);
                        break;
                    case 3:
                        AnagramUtils.clearMemory();
                        break;
                    case 4:
                        System.out.println("Thank you for using the Anagram App!");
                        System.out.println("Hope you liked it!");
                        System.out.println("Exiting the program .... ");
                        System.exit(0);
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number from 1 to 4.");
                scanner.nextLine();
            }
        }
    }
    //
}