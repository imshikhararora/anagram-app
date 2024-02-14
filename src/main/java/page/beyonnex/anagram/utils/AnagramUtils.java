package page.beyonnex.anagram.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnagramUtils {

    private AnagramUtils() {}

    private static Map<String, Set<String>> anagramsMap = new HashMap<>();

    public static void clearMemory() {
        anagramsMap.clear();
    }

    public static Set<String> getAnagramsOfString(String text) {
        if (anagramsMap.containsKey(getSortedChars(text))) {
            Set<String> anagramSet = anagramsMap.get(getSortedChars(text));
            anagramSet.remove(text);
            return anagramSet;
        } else {
            return new HashSet<>();
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
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        char[] charArray = text.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
