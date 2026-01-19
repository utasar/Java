/*
Question 1b: Secure Bank PIN Policy Upgrade

A bank is implementing a new PIN security policy to strengthen customer account protection. Every customer's banking PIN must meet the following criteria:
1. The PIN must be between 6 and 20 characters (inclusive)
2. It must contain at least one lowercase letter, one uppercase letter, and one digit
3. It must not contain three consecutive repeating characters

Task: Given a string pin_code, return the minimum number of changes required to make it strong. If the PIN is already strong, return 0.
*/

public class Question_1b {
    // Method to compute the minimum number of changes to make the PIN strong
    public static int strongPinPolicy(String pin_code) {
        int n = pin_code.length(); // Get the length of the PIN

        // Check if the PIN contains at least one lowercase letter
        boolean hasLower = false;
        // Check if the PIN contains at least one uppercase letter
        boolean hasUpper = false;
        // Check if the PIN contains at least one digit
        boolean hasDigit = false;

        // Loop through each character in the PIN
        for (int i = 0; i < n; i++) {
            char c = pin_code.charAt(i); // Get the character at position i
            if (Character.isLowerCase(c)) hasLower = true; // Set hasLower if lowercase found
            if (Character.isUpperCase(c)) hasUpper = true; // Set hasUpper if uppercase found
            if (Character.isDigit(c)) hasDigit = true;     // Set hasDigit if digit found
        }

        // Count how many required character types are missing
        int missingTypes = 0;
        if (!hasLower) missingTypes++; // Add 1 if missing lowercase
        if (!hasUpper) missingTypes++; // Add 1 if missing uppercase
        if (!hasDigit) missingTypes++; // Add 1 if missing digit

        // Count the number of changes needed for three consecutive repeating characters
        int consecutiveChanges = 0; // Number of fixes needed
        int i = 0; // Index for looping through the PIN
        while (i < n - 2) { // Loop until third last character
            // Check if three consecutive characters are the same
            if (pin_code.charAt(i) == pin_code.charAt(i + 1) && pin_code.charAt(i) == pin_code.charAt(i + 2)) {
                consecutiveChanges++; // Increment the counter
                i += 3; // Skip the next two to avoid double counting
            } else {
                i++; // Move to the next character
            }
        }

        // Handle case where PIN is too short (less than 6 characters)
        if (n < 6) {
            int insertionsNeeded = 6 - n; // Number of insertions required
            // The answer is the maximum of insertions needed and total fixes for missing types and repeats
            return Math.max(insertionsNeeded, missingTypes + consecutiveChanges);
        }
        // Handle case where PIN is of valid length (6 to 20 characters)
        else if (n <= 20) {
            // The answer is the maximum of missing types and consecutive changes
            return Math.max(missingTypes, consecutiveChanges);
        }
        // Handle case where PIN is too long (more than 20 characters)
        else {
            int deletionsNeeded = n - 20; // Number of deletions required
            // After deletions, we may reduce the number of consecutive changes
            int remainingConsecutive = Math.max(0, consecutiveChanges - deletionsNeeded / 3);
            // The answer is deletions plus the maximum of missing types and remaining consecutive changes
            return deletionsNeeded + Math.max(missingTypes, remainingConsecutive);
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test case 1: PIN is too short and missing lowercase
        System.out.println(strongPinPolicy("X1!")); // Expected output: 3

        // Test case 2: PIN is missing uppercase and lowercase
        System.out.println(strongPinPolicy("123456")); // Expected output: 2

        // Test case 3: PIN is already strong
        System.out.println(strongPinPolicy("Aa1234!")); // Expected output: 0
    }
}
