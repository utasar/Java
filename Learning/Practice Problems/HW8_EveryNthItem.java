import java.util.*;

public class HW8_EveryNthItem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] randomNumbers = randomArray();
        boolean exitLoop = false;
        int N = 0;

        // Print all values in array
        System.out.println("The array contains " + Arrays.toString(randomNumbers));

        // Check for valid input else reprompt
        while (!exitLoop) {
            System.out.print("What is the value of N? ");
            try {
                exitLoop = true; // Exit loop if input is valid
                N = input.nextInt();
                if (!(N <= 10 && N >= 1)) { // Check that input is between 1 and 10
                    System.out.println("Invalid input. Please enter a number between 1-10.");
                    exitLoop = false; // Keep looping if input is invalid
                }
            } catch (Exception e) {  // Catches error when input is not an integer
                System.out.println("Invalid input. Please enter a number between 1-10.");
                exitLoop = false;
                input.next();
            }
        }
        input.close();

        // Print every Nth item in array
        System.out.println(Arrays.toString(EveryNthItem(randomNumbers, N))); 
    }

    public static int[] randomArray() {
        Random random = new Random();
        int[] randomNumbers = new int[10]; // Create array of size 10

        // Generate 10 random values between 1 - 20 for array
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(20) + 1; 
        }
        return randomNumbers;
    }

    public static int[] EveryNthItem(int[] randomNumbers, int N) {
        int finalArraySize = (int)(randomNumbers.length / N); // Calculate size of final array
        int[] finalArray = new int[finalArraySize];

        // Loop through array and add every Nth item to new array
        for (int i = 1; i <= randomNumbers.length; i++) {
            if (i % N == 0) { // If i is divisible by N, add to final array
                finalArray[i / N - 1] = randomNumbers[i - 1];
            }
        }
        return finalArray;
    }
}

/*
Create an array of ten random integers with values between 1 and 20 using a loop and display the 
contents of the full array. Next, ask the user to input a number between 1 and 10, and use this as your N 
value. Print every Nth item in the array.

The array contains 13 10 4 7 10 9 2 18 1 5
What is the value of N? 3
4 9 1

The array contains 17 4 7 3 9 8 9 14 12 17
What is the value of N? 11
Error: the value must be between 1 and 10
*/
