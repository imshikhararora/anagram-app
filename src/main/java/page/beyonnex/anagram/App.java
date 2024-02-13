package page.beyonnex.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static Map<String, Set<String>> anagramsMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("\nAnagram App");
        System.out.println("Please select an option: ");
        System.out.println("1 - Check if two texts are anagrams of each other");
        System.out.println("2 - Get all the anagrams for a given string");
        System.out.println("3 - Clear the memory");
        System.out.println("4 - Exit the program");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                checkAnagrams();
                break;
            case 2:
                getAnagrams();
                break;
            case 3:
                clearMemory();
                break;
            case 4:
                System.out.println("Exiting the program .... ");
                System.exit(0);
                return;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void clearMemory() {
        anagramsMap.clear();
        System.out.println("Memory cleared successfully");
    }

    private static void getAnagrams() {
        System.out.print("Enter the text for which you want to get the anagrams: ");
        String text = scanner.nextLine();
        if (anagramsMap.containsKey(getSortedChars(text))) {
            Set<String> anagramSet = anagramsMap.get(getSortedChars(text));
            System.out.println("The anagrams for the given text are: " + anagramSet);
        } else {
            System.out.println("No anagrams found for the given text");
        }
    }

    private static void checkAnagrams() {
        System.out.println("Checking if two texts are anagrams of each other");
        System.out.print("Enter the first text: ");
        String text1 = scanner.nextLine();
        System.out.print("Enter the second text: ");
        String text2 = scanner.nextLine();
        if (areAnagrams(text1, text2)) {
            updateAnagramsMap(text1, text2, true);
            System.out.println("'" + text1 + "' and '" + text2 + "' are anagrams");
        } else {
            updateAnagramsMap(text1, text2, false);
            System.out.println("The given strings are not anagrams.");

        }
    }

    private static void updateAnagramsMap(String text1, String text2, boolean isAnagram) {
        if (isAnagram) {
            String key = getSortedChars(text1);
            Set<String> anagramSet;
            if (anagramsMap.containsKey(key)) {
                anagramSet = anagramsMap.get(key);
            } else {
                anagramSet = new HashSet<>();
            }
            anagramSet.add(text1);
            anagramSet.add(text2);
            anagramsMap.put(key, anagramSet);
        } else {
            String key = getSortedChars(text1);
            addNonAnagramsToAnagramMap(text1, key);
            key = getSortedChars(text2);
            addNonAnagramsToAnagramMap(text2, key);
        }
    }

    private static void addNonAnagramsToAnagramMap(String text, String key) {
        if (anagramsMap.containsKey(key)) {
            Set<String> anagramSet = anagramsMap.get(key);
            anagramSet.add(text);
            anagramsMap.put(key, anagramSet);
        } else {
            Set<String> anagramSet = new HashSet<>();
            anagramSet.add(text);
            anagramsMap.put(key, anagramSet);
        }
    }

    private static boolean areAnagrams(String text1, String text2) {
        return (getSortedChars(text1).equals(getSortedChars(text2)));
    }

    private static String getSortedChars(String text) {
        text = text.trim().replace(" ", "").toLowerCase();
        char[] charArray = text.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}