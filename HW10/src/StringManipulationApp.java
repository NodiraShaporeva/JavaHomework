import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringManipulationApp {

    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }

    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static int countConsonants(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch) && !isVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static int countOccurrences(String str, String word) {
        int count = 0;
        int index = 0;
        while (index != -1) {
            index = str.indexOf(word, index);
            if (index != -1) {
                count++;
                index += word.length();
            }
        }
        return count;
    }

    @Test
    public void testIsPalindrome() {
        Assertions.assertTrue(isPalindrome("level"));
        Assertions.assertTrue(isPalindrome("Deleveled"));
        Assertions.assertFalse(isPalindrome("hello"));
    }

    @Test
    public void testCountVowels() {
        Assertions.assertEquals(3, countVowels("hello"));
        Assertions.assertEquals(5, countVowels("aeiou"));
        Assertions.assertEquals(0, countVowels("bcdfg"));
    }

    @Test
    public void testCountConsonants() {
        Assertions.assertEquals(3, countConsonants("hello"));
        Assertions.assertEquals(2, countConsonants("aeiou"));
        Assertions.assertEquals(5, countConsonants("bcdfg"));
    }

    @Test
    public void testCountOccurrences() {
        Assertions.assertEquals(2, countOccurrences("hello hello world", "hello"));
        Assertions.assertEquals(3, countOccurrences("aaaaa", "aa"));
        Assertions.assertEquals(0, countOccurrences("abc", "def"));
    }

}
