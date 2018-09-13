/**
 * Hangman.java
 * Abstract: tbd
 * Tanner Yost
 * 9/10/2018
 */
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        String phrase = getPhrase();
    }

    /**
     * Asks the user for a phrase to use for the game.
     * @return
     */
    public static String getPhrase() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        return sc.nextLine().toUpperCase().trim();
    }

    public static void makeGuess() {
        //TODO: create method that proceeds with making a guess
    }

    public static void getHint() {
        //TODO: create method that generates a hint for the user
    }

    public static void displayWord() {
        //TODO: create method that prints out the word as it currently stands
    }
}
