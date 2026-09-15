import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int round = 1;
        final int MAX_ATTEMPTS = 7;
        System.out.println("===== NUMBER GUESSING GAME =====");
        while (true) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;
            System.out.println("\nRound " + round);
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid integer.");
                    sc.next();
                    continue;
                }
                int guess = sc.nextInt();
                attempts++;
                if (guess == secretNumber) {
                    guessed = true;
                    // More points for fewer attempts.
                    int score = (MAX_ATTEMPTS - attempts + 1) * 10;
                    totalScore += score;
                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Number of attempts: " + attempts);
                    System.out.println("Round score: " + score);
                    break;
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try a smaller number.");
                } else {
                    System.out.println("Too low! Try a larger number.");
                }
                System.out.println("Attempts remaining: "
                                   + (MAX_ATTEMPTS - attempts));
            }
            if (!guessed) {
                System.out.println("\nGame over for this round.");
                System.out.println("The correct number was: " + secretNumber);
            }
            System.out.println("Total score: " + totalScore);
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = sc.next();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
            round++;
        }
        System.out.println("\n===== FINAL RESULT =====");
        System.out.println("Rounds played: " + round);
        System.out.println("Final score: " + totalScore);
        System.out.println("Thank you for playing!");
        sc.close();
    }
}
