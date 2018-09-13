/**
 * Hangman.java
 * Abstract: asks user for a word to be used for the game, then plays the game of hangman.
 *           4 incorrect guesses and the game is over
 *           to win, correctly guess each character of the phrase entered.
 *
 * Tanner Yost
 * 9/10/2018
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Hangman {
    public static void main(String[] args) {
        char[] phrase = getPhrase().toCharArray();
        ArrayList<Character> madeGuesses = new ArrayList<>();
        boolean[] letterFound = new boolean[phrase.length];
        boolean solved = false;
        int guesses = 4;

        while (!solved) {
            boolean correctGuess = false;
            try {
                displayWord(phrase, letterFound);
                System.out.printf("\nYou have %d incorrect guess left.", guesses);
                System.out.print("\nEnter either 1 for guessing or 2 for hint: ");
                Scanner sc = new Scanner(System.in);

                int choice = sc.nextInt();

                if (choice == 1) {
                    correctGuess = makeGuess(phrase, letterFound, madeGuesses);
                } else if (choice == 2) {
                    getHint(phrase, letterFound, guesses, madeGuesses);
                } else {
                    System.out.println("Incorrect input, only valid entries are 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type.");
                correctGuess=true;
            }
            solved = checkForWin(phrase, letterFound);

            if (solved) {
                System.out.print("\n\nCongratulations! The word was: ");
                for (char item : phrase)
                    System.out.print(item + " ");
                break;
            }

            if (!correctGuess)
                guesses--;
            if (guesses == 0) {
                System.out.print("\nYou failed to guess the word. The word was ");
                for (char item : phrase)
                    System.out.print(item + " ");
                break;
            }
        }
    }

    /**
     * asks the user for a word/phrase to be used for the game.
     *
     * @return the word/phrase used for the remaineder of the game.
     */
    private static String getPhrase() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word/phrase: ");
        return sc.nextLine().toUpperCase().trim();
    }

    /**
     * Asks user for a guess and determines if it is valid or not, then determines if the guess is in the word.
     *
     * @param word, array containing the characters of the phrase entered at the beginning of the program
     * @param display, boolean array which determines if character has been guessed/hinted and if it should be displayed.
     * @param madeGuesses, list of hinted/guessed characters
     * @return
     */
    private static boolean makeGuess(char[] word, boolean[] display, ArrayList<Character> madeGuesses) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("\nEnter your guess: ");
            char guess = sc.next().toUpperCase().charAt(0);
            if (madeGuesses.contains(guess)) {
                System.out.printf("\nNot valid input, you already guessed %c", guess);
                return true;
            }
            madeGuesses.add(guess);
            boolean contains = false;
            int index = 0;

            for (char item : word) {
                if (guess == item)
                    contains = true;
            }

            if (contains) {
                System.out.printf("\nThat's right! %c is in the word.", guess);
                for (char item : word) {
                    if (guess == item) {
                        display[index] = true;
                    }
                    index++;
                }
                return true;
            }

            else
                System.out.printf("\nSorry, %c isn't in the word.", guess);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type.");
        }
        return false;
    }

    /**
     * produces a hint for the user. main() handles decrementing of guesses remaining.
     *
     * @param word, array containing the characters of the phrase entered at the beginning of the program
     * @param display, boolean array which determines if character has been guessed/hinted and if it should be displayed.
     * @param guesses, number of guesses remaining
     * @param madeGuesses, list of hinted/guessed characters
     */
    private static void getHint(char[] word, boolean[] display, int guesses, ArrayList<Character> madeGuesses) {
        int index = 0;
        for (char item : word) {
            if (!display[index] && item!=' ') {
                display[index]=true;
                System.out.printf("\nOK! The hint is %c", item);
                madeGuesses.add(item);
                break;
            }
            index++;
        }
        System.out.printf("\nBut since you used a hint, you can guess incorrectly %d more time(s)", guesses-1);
    }

    /**
     * uses word and display data to display the word as it currently stands to the user
     *
     * @param word, array containing the characters of the phrase entered at the beginning of the program
     * @param display, boolean array which determines if character has been guessed/hinted and if it should be displayed.
     */
    private static void displayWord(char[] word, boolean[] display) {
        int index = 0;
        System.out.print("\n\nSo far, the word is: ");
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

    /**
     * checks for win, not including the spaces.
     * defaults to true unless it can be proven that the user has not guessed the word yet.
     *
     * @param word, array containing the characters of the phrase entered at the beginning of the program
     * @param display, boolean array which determines if character has been guessed/hinted and if it should be displayed.
     * @return
     */
    private static boolean checkForWin(char[] word, boolean[] display) {
        int index = 0;
        for (char item : word) {
            if (!display[index] && item!=' ') {
                return false;
            }
            index++;
        }
        return true;
    }
}
