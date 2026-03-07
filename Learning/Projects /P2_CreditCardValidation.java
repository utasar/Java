import java.util.Scanner;

public class P2_CreditCardValidation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long creditCardInput = 0;
        boolean exitLoop = false;

        // Checks that input is an integer of correct length else reprompt
        while (!exitLoop) {
            System.out.print("Please enter a credit card number as a long integer: ");
            try {
                exitLoop = true; // Exit loop if input is valid
                creditCardInput = input.nextLong();
                if (!(String.valueOf(creditCardInput).length() >= 13 && String.valueOf(creditCardInput).length() <= 16)) {
                    System.out.println("Invalid input. Please enter an integer between 13 and 16 characters long.");
                    exitLoop = false; // Keep looping if input is invalid
                }
            } catch (Exception e) { // Catches error when input is not an integer
                System.out.println("Invalid input. Please enter only integers.");
                exitLoop = false;
                input.next();
            }
        }
        input.close();

        // Checks if luhnCheck method is true
        if (luhnCheck(creditCardInput) == true) {
            System.out.print(creditCardInput + " is a valid " + getCardType(creditCardInput) + " credit card.");
        } else {
            System.out.print(creditCardInput + " is an invalid " + getCardType(creditCardInput) + " credit card.");
        }
    }

    // Assigns card type info based on starting digits
    public static String getCardType(long creditCardInput) {
        String creditCardType = "";

        if (Long.toString(creditCardInput).charAt(0) == '4') {
            creditCardType = "Visa";
        } else if (Long.toString(creditCardInput).charAt(0) == '5') {
            creditCardType = "Mastercard";
        } else if (Long.toString(creditCardInput).charAt(0) == '6') {
            creditCardType = "American Express";
        } else if (Long.toString(creditCardInput).substring(0, 2).equals("37")) {
            creditCardType = "Discover";
        } else {
            creditCardType = "unknown";
        }
        return creditCardType;
    }

    // Calculates the sum of every other digit from right to left starting at the rightmost digit
    public static int oddSum(long creditCardInput) {
        int sumOdd = 0;

        while (creditCardInput > 0) {
            sumOdd += creditCardInput % 10; // Returns the remainder when the card number is divided by 10 (last digit) and adds it to the overall sum
            creditCardInput /= 100; // Skips two digits from right to left
        }
        return sumOdd;
    }

    // Calculates sum of every other digit right to left starting from second rightmost digit
    public static int evenSum(long creditCardInput) {
        int sumEven = 0;
        while (creditCardInput > 0) {
            double evenSingleDigit = (2 * Math.floor((creditCardInput % 100) / 10)); // Returns the remainder when the card number is divided by 100(last two digits), 
                                                                                     // then divide by 10 then floor it for the first digit (ex. 26 = 2)
            if (evenSingleDigit > 9) { // If evenSingleDigit is two digits, add each digit together
                evenSingleDigit = (evenSingleDigit - 10) + 1;
            }
            sumEven += evenSingleDigit; // Add evenSingleDigit to the overall sum
            creditCardInput /= 100; // Skips two digits from right to left
        }
        return sumEven;
    }

    // Checks if total sum is divisible by 10 (valid)
    public static Boolean luhnCheck(long creditCardInput) {
        int totalSum = evenSum(creditCardInput) + oddSum(creditCardInput);
        boolean valid = false;

        if ((totalSum % 10) == 0) {
            valid = true;
        }
        return valid;
    }
}

/*
Credit card numbers follow certain patterns. A credit card number must have between
13 and 16 digits. It must start with:

4 for Visa cards
5 for Master cards
37 for American Express cards
6 for Discover cards

In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card numbers.
The algorithm is useful to determine if a card number is entered correctly or if a credit
card is scanned correctly by a scanner. Almost all credit card numbers are generated
following this validity check, commonly known as the Luhn check or the Mod 10 check,
which can be described as follows (for illustration, consider the card number
4388576018402626):

1. Double every second digit from right to left. If doubling of a digit results in a 
two-digit number, add up the two digits to get a single-digit number.
2 * 2 = 4
2 * 2 = 4
4 * 2 = 8
1 * 2 = 2
6 * 2 = 12 (1 + 2 = 3)
5 * 2 = 10 (1 + 0 = 1)
8 * 2 = 16 (1 + 6 = 7)
4 * 2 = 8

2. Now add all single-digit numbers from Step 1.
4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37

3. Add all digits in the odd places from right to left in the card number.
6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38

4. Sum the results from Step 2 and Step 3.
37 + 38 = 75

5. If the result from Step 4 is divisible by 10, the card number is valid; otherwise, it is
invalid. For example, the number 4388576018402626 is invalid, but the number 
4388576018410707 is valid.

Write a program that prompts the user to enter a credit card number as a long integer.
Display whether the number is valid or invalid.

Here are sample runs of the program:

Sample 1:
Enter a credit card number as a long integer: 4246345689049834
4246345689049834 is invalid

Sample 2:
Enter a credit card number as a long integer: 4388576018410707
4388576018410707 is valid
*/
