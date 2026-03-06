import java.util.Scanner;

public class HW4_UpTo100 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        // Prompt for number input while sum below or equal to 100
        while (sum <= 100) {
            System.out.print("Enter a number: ");

            // Check for valid number input else reprompt
            if (input.hasNextInt()) {
                sum += input.nextInt();
                count++;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next();
            }
        }
        input.close();

        System.out.println("You have entered " + (count - 1) + " values before the total was greater than or equal to 100.");
    }
}
