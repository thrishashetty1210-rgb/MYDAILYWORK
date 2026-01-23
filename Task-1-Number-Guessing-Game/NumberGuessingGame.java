Task-1-Number-Guessing-Game/NumberGuessingGame.java


import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static int playGame() {
        int number = random.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        int maxAttempts = 7;
        

        System.out.println("\nI have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == number) {
                System.out.println(" Correct! You guessed it in " + attempts + " attempts.");
                return maxAttempts - attempts + 1; // score
            } else if (guess < number) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        System.out.println(" Out of attempts! The number was: " + number);
        return 0;
    }

    public static void main(String[] args) {
        int totalScore = 0;
        int roundsWon = 0;
        char choice;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int score = playGame();
            totalScore += score;

            if (score > 0) {
                roundsWon++;
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);

        } while (choice == 'y');

        System.out.println("\n Game Over!");
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Total Score: " + totalScore);

        sc.close();
    }
}
