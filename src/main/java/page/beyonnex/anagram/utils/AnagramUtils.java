package page.beyonnex.anagram.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AnagramUtils {

    private AnagramUtils() {}

    private static Map<String, Set<String>> anagramsMap = new HashMap<>();

    public static void clearMemory() {
        anagramsMap.clear();
        System.out.println("Memory cleared successfully");
    }

    public static void getAnagrams(Scanner scanner) {
        System.out.print("Enter the text for which you want to get the anagrams: ");
        String text = scanner.nextLine();
        if (anagramsMap.containsKey(getSortedChars(text))) {
            Set<String> anagramSet = anagramsMap.get(getSortedChars(text));
            anagramSet.remove(text);
            System.out.println("The anagrams for the given text are: " + anagramSet);
        } else {
            System.out.println("No anagrams found for the given text");
        }
    }

    public static void checkAnagrams(Scanner scanner) {
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

    public static void updateAnagramsMap(String text1, String text2, boolean isAnagram) {
        String key = getSortedChars(text1);
        if (isAnagram) {
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
            addNonAnagramsToAnagramMap(text1, key);
            key = getSortedChars(text2);
            addNonAnagramsToAnagramMap(text2, key);
        }
    }

    public static void addNonAnagramsToAnagramMap(String text, String key) {
        Set<String> anagramSet;
        if (anagramsMap.containsKey(key)) {
            anagramSet = anagramsMap.get(key);
        } else {
            anagramSet = new HashSet<>();
        }
        anagramSet.add(text);
        anagramsMap.put(key, anagramSet);
    }

    public static boolean areAnagrams(String text1, String text2) {
        return (getSortedChars(text1).equals(getSortedChars(text2)));
    }

    public static String getSortedChars(String text) {
        text = text.trim().replace(" ", "").toLowerCase();
        char[] charArray = text.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}
