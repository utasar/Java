import java.util.Scanner;

public class HW5_PrimeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean correct = false;
        int n = 0;
        int counter = 0;
        int number = 2;

        // Checks that input is a positive integer else reprompt
        while (!correct) {
            System.out.print("What is the value of n? ");
            try {
                correct = true;
                n = input.nextInt();
                if (!(n > 0)) { // only accept positive integers
                    System.out.println("Invalid input: n cannot be negative.");
                    correct = false;
                }
            } catch (Exception e) { // catches error from inputting non-integers
                System.out.println("Invalid input: Please enter a positive integer.");
                correct = false;
                input.next();
            }
        }
        input.close();

        while (counter != n) { // while counter does not equal number of prime numbers entered (n) it will keep
                               // looping
            boolean prime = true; // determine if number is prime or not

            for (int i = 2; i <= Math.floor(Math.sqrt(number)); i++) { // use foor of sqrt since it is more efficient
                                                                       // than brute force
                if (number % i == 0) { // breaks loop if the number is divisible by any other number (not prime)
                    prime = false;
                    break;
                }
            }

            if (prime) {
                System.out.print(number + " ");
                counter++;
            }
            number++; // continues to next number
        }
    }
}

/*
A prime number is a number that is only divisible by itself and 1. Write a program
that prompts the user for a number n and then displays the first n prime numbers. If
the user enters a negative value for n, display the message Error: n cannot be
negative. Hint: you probably want to use nested loops. An example is shown below:

What is the value of n? 5
2 3 5 7 11

What is the value of n? -4
Error: n cannot be negative
 */
