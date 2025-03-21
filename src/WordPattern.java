import java.util.*;

public class WordPattern {
    public static boolean followsPattern(String pattern, char delimiter, String s) {
        String[] words = s.split("\\" + delimiter);

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> letterToWord = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            String word = words[i];

            if (letterToWord.containsKey(letter)) {
                if (!letterToWord.get(letter).equals(word)) {
                    return false;
                }
            } else {

                if (usedWords.contains(word)) {
                    return false;
                }

                letterToWord.put(letter, word);
                usedWords.add(word);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(followsPattern("abba", '?', "dog?cat?cat?dog")); // true
        System.out.println(followsPattern("abba", '|', "apple|banana|grape|apple")); // false
        System.out.println(followsPattern("aaaa", ',', "dog,cat,cat,dog")); // false
        System.out.println(followsPattern("aaaa", ' ', "ice cream taco day")); // false
        System.out.println(followsPattern("adxp", ' ', "ice cream taco day")); // true
    }
}
