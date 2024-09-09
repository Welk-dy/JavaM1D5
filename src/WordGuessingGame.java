import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private static final String[] WORDS = {"apple", "banana", "cherry", "date", "fig", "grape", "kiwi"};
    private static final int MAX_ATTEMPTS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a single Scanner instance

        String wordToGuess = selectRandomWord();
        String hiddenWord = hideWord(wordToGuess);
        int attemptsLeft = MAX_ATTEMPTS;

        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("You have " + attemptsLeft + " attempts to guess the word.");

        while (attemptsLeft > 0 && hiddenWord.contains("_")) {
            System.out.println("Word to guess: " + hiddenWord);
            char guess = getPlayerGuess(scanner);

            if (isGuessCorrect(wordToGuess, guess)) {
                hiddenWord = updateHiddenWord(wordToGuess, hiddenWord, guess);
                System.out.println("Good guess!");
            } else {
                attemptsLeft--;
                System.out.println("Wrong guess! Attempts left: " + attemptsLeft);
            }
        }

        displayGameResult(wordToGuess, hiddenWord, attemptsLeft);
        scanner.close(); // Close the Scanner instance at the end
    }

    // Method 1: Select a random word from the WORDS array
    private static String selectRandomWord() {
        Random random = new Random();
        int index = random.nextInt(WORDS.length);
        return WORDS[index];
    }

    // Method 2: Create and return a string of underscores with the same length as the input word
    private static String hideWord(String word) {
        return "_".repeat(word.length());
    }

    // Method 3: Prompt the player for a guess and return the guessed character
    private static char getPlayerGuess(Scanner scanner) {
        System.out.print("Enter your guess (single letter): ");
        String input = scanner.next().toLowerCase(); // Read input and convert to lowercase
        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) { // Validate input
            System.out.print("Invalid input. Enter a single letter: ");
            input = scanner.next().toLowerCase();
        }
        return input.charAt(0); // Return the first character of valid input
    }

    // Method 4: Check if the guessed character is in the word and return a boolean result
    private static boolean isGuessCorrect(String word, char guess) {
        return word.indexOf(guess) >= 0;
    }

    // Method 5: Update the hidden word by revealing the correctly guessed character
    private static String updateHiddenWord(String word, String hiddenWord, char guess) {
        StringBuilder updatedWord = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                updatedWord.setCharAt(i, guess);
            }
        }
        return updatedWord.toString();
    }

    // Method 6: Show the final game result, including whether the player won or lost
    private static void displayGameResult(String wordToGuess, String hiddenWord, int attemptsLeft) {
        if (hiddenWord.equals(wordToGuess)) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Game Over! You've run out of attempts.");
            System.out.println("The word was: " + wordToGuess);
        }
    }
}