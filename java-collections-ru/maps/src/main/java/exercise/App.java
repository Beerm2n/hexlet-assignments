package exercise;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {

    public static Map<String, Integer> getWordCount(String sentence) {
        if (sentence.length() == 0) {
            Map<String, Integer> vocablurary = new HashMap<>();
            return vocablurary;
        }
        String[] word = sentence.split(" ");
        List<String> words = new ArrayList<String>(Arrays.asList(word));
        Map<String, Integer> vocablurary = new HashMap<>();
        for (String s : words) {
            if (!vocablurary.containsKey(s)) {
                vocablurary.put(s, Collections.frequency(words, s));
            }
        }
        return vocablurary;
    }

    public static String toString(Map<String, Integer> vocablurary) {
        if (vocablurary.isEmpty()) {
            return "{}";
        }
        StringBuilder result = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> word: vocablurary.entrySet()) {
            result.append("  " + word.getKey() + ": " + word.getValue() + "\n");
        }
        result.append("}");
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(getWordCount(""));
        System.out.println(toString(getWordCount("")));
    }

}
//END
