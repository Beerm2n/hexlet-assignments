package exercise;


import java.util.ArrayList;

// BEGIN
public class App {

    public static boolean scrabble(String inputString, String word) {
        if (inputString.length() < word.length()) {
            return false;
        }
        ArrayList<Character> listInputString = new ArrayList<Character>();
        for (char c : inputString.toLowerCase().toCharArray()) {
            listInputString.add(c);
        }
        ArrayList<Character> listWord = new ArrayList<Character>();
        for (char c : word.toLowerCase().toCharArray()) {
            listWord.add(c);
        }
        for (Character c : listWord) {
            if (listInputString.contains(c)) {
                listInputString.remove(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("1 - Greet");
        System.out.println("Hello hexlet");
        System.out.println(scrabble("rkqodlw", "woorld"));
    }
}
//END
