package Exceptions;

import java.util.*;

public class ExceptionAcitivity {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int x = getInput(5, 15);
        System.out.println("You entered: " + x);
    }

    // Prompt user for an integer between the lower bound and upper bounds,
    // inclusive and reprompt them until they give us something viable
    public static int getInput(int lower, int upper) {
        System.out.print("Enter a number between " + lower + " and " + upper + ": ");
        int input = 0;

        while (true) {
            try {
                input = in.nextInt();
                
                while (input < lower || input > upper) {
                    if (input < lower) {
                        System.out.println("Input is too low!");
                    } else {
                        System.out.println("Input is too high!");
                    }
        
                    System.out.print("Please enter an integer between " + lower + " and " + upper + ": ");
                    input = in.nextInt();
                }
                return input;
            } catch (InputMismatchException e1) {
                System.out.println("Input is not a number!");
                System.out.print("Enter a number between " + lower + " and " + upper + ": ");
                in.nextLine();
            }
        }
    }
}
