/**
 * Hangman.java
 * Abstract: tbd
 * Tanner Yost
 * 9/10/2018
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        //char[] phrase = getPhrase().toCharArray();
        char[] phrase = "look a phrase".toCharArray();
        boolean[] letterFound = new boolean[phrase.length];
        boolean solved = false;
        int guesses = 4;

        displayWord(phrase, letterFound);

        do {
            try {
                System.out.print("\nEnter either 1 for guessing or 2 for hint: ");
                Scanner sc = new Scanner(System.in);

                int choice = sc.nextInt();

                if (choice == 1) {
                    solved = makeGuess(phrase, letterFound, guesses);
                } else if (choice == 2) {
                    getHint();
                } else {
                    System.out.println("Incorrect input, only valid entries are 1 or 2.");
                }
            }
            catch (InputMismatchException e) { System.out.println("Invalid input type."); }
        } while(!solved);

    }

    /**
     * Asks the user for a phrase to use for the game.
     * @return
     */
    private static String getPhrase() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        return sc.nextLine().toUpperCase().trim();
    }

    public static boolean makeGuess(char[] word, boolean[] display, int guesses) {
        //TODO: create method that proceeds with making a guess
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1)
            return true;
        else if (choice == 2)
            return false;
        else
            return false;
    }

    public static void getHint() {
        //TODO: create method that generates a hint for the user
    }

    public static void displayWord(char[] word, boolean[] display) {
        int index = 0;
        System.out.print("So far, the word is: ");
        for (char item : word) {
            if (item==' ')
                System.out.print("# ");
            else if (display[index])
                System.out.print(item+" ");
            else
                System.out.print("_ ");
            index++;
        }
    }
}
