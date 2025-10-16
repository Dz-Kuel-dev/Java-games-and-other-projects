import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {

            int targetNumber = (int)(Math.random() * 100) + 1;
            int guess = 0;
            int attempts = 0;

            System.out.println("Guess a number between 1 and 100:");

            while (guess != targetNumber) {

                // validate input
                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number:");
                    scanner.next(); // discard invalid input
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Correct! You guessed the right number in " + attempts + " tries.");
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try a higher number:");
                } else {
                    System.out.println("Too high! Try a lower number:");
                }
            }

            System.out.println("Play again? (y/n)");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("y");
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}


