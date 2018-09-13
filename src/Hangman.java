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
        char[] phrase = "LOOK A PHRASE".toCharArray();
        boolean[] letterFound = new boolean[phrase.length];
        boolean solved = false;
        int guesses = 4;

        while (!solved) {
            try {
                displayWord(phrase, letterFound);
                System.out.print("\nEnter either 1 for guessing or 2 for hint: ");
                Scanner sc = new Scanner(System.in);

                int choice = sc.nextInt();

                if (choice == 1) {
                    makeGuess(phrase, letterFound, guesses);
                } else if (choice == 2) {
                    getHint();
                } else {
                    System.out.println("Incorrect input, only valid entries are 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type.");
            }
        }
    }


    public static String getPhrase() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        return sc.nextLine().toUpperCase().trim();
    }


    public static void makeGuess(char[] word, boolean[] display, int guesses) {
        //TODO: finish makeGuess method, need to work on loop so it doesnt repeat
        //commented line below does not work
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("\nEnter your guess: ");
            char guess = sc.next().toUpperCase().charAt(0);
            int index = 0;
            for (char item : word) {
                if (guess == item) {
                    display[index] = true;
                    System.out.printf("\nThat's right! %c is in the word.", guess);
                }
//                else {
//                    System.out.printf("\nSorry, %c isn't in the word.", guess);
//                }
                index++;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
        }
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
