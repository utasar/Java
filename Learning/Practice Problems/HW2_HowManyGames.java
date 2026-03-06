import java.util.Scanner;

public class HW2_HowManyGames {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many people are playing? ");

        // Check for valid number of people playing else reprompt
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            input.next();
        }
        input.close();

        int numberOfPeople = input.nextInt(); // number of people playing
        int numberOfGames = numberOfPeople / 4; // number of games to play
        System.out.print("There is enough people for " + numberOfGames + " game(s)");
    }
}
