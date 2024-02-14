package page.beyonnex.anagram.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramUtilsTest {

    @BeforeEach
    void setUp() {
        AnagramUtils.clearMemory();
    }

    @Test
    void testAreAnagramsTrue() {
        assertTrue(AnagramUtils.areAnagrams("army", "mary"));
        assertTrue(AnagramUtils.areAnagrams("A r M y", "m AR y"));
        assertTrue(AnagramUtils.areAnagrams("New York Times", "monkeys write"));
        assertTrue(AnagramUtils.areAnagrams("Church of Scientology", "rich-chosen goofy cult"));
        assertTrue(AnagramUtils.areAnagrams("McDonald's restaurants", "Uncle Sam's standard rot"));
        assertTrue(AnagramUtils.areAnagrams("coronavirus", "carnivorous"));
        assertTrue(AnagramUtils.areAnagrams("William Shakespeare", "I am a weakish speller"));
        assertTrue(AnagramUtils.areAnagrams("Tom Marvolo Riddle", "I am Lord Voldemort"));
    }

    @Test
    void testAreAnagramsFalse() {
        assertFalse(AnagramUtils.areAnagrams("java", "python"));
    }

    @Test
    void testUpdateAnagramsMapAndRetrieve() {
        AnagramUtils.updateAnagramsMap("army", "mary", true);
        Set<String> anagrams = AnagramUtils.getAnagramsOfString("army");
        assertTrue(anagrams.contains("mary"), "The set should contain 'mary' as an anagram of 'army'.");
    }

    @Test
    void testClearMemory() {
        AnagramUtils.updateAnagramsMap("army", "mary", true);
        AnagramUtils.clearMemory();
        assertTrue(AnagramUtils.getAnagramsOfString("army").isEmpty(), "Memory was cleared successfully.");
    }

    @Test
    void testNoAnagramsFound() {
        AnagramUtils.updateAnagramsMap("army", "mary", true);
        Set<String> anagrams = AnagramUtils.getAnagramsOfString("unique");
        assertTrue(anagrams.isEmpty(), "Should return an empty set when no anagrams are found.");
    }

    @Test
    void testAddNonAnagramsToAnagramMap() {
        AnagramUtils.updateAnagramsMap("java", "coffee", false);
        assertTrue(AnagramUtils.getAnagramsOfString("java").isEmpty(), "Map should track 'java'.");
        assertTrue(AnagramUtils.getAnagramsOfString("coffee").isEmpty(), "Map should track 'coffee'.");
    }
}