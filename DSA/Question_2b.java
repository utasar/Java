
import java.util.*; // Import utility classes

public class Question_2b {
    // Method to solve cryptarithmetic puzzle using backtracking
    public static boolean solveCryptarithmetic(String equation) {
        // Remove spaces and split equation by '='
        equation = equation.replace(" ", ""); // Remove all spaces
        String[] parts = equation.split("="); // Split by equals sign
        String left_side = parts[0]; // Left side of equation
        String right_side = parts[1]; // Right side of equation

        // Split left side by '+' sign
        String[] operands = left_side.split("\\+"); // Split by plus sign
        String word1 = operands[0]; // First operand
        String word2 = operands[1]; // Second operand
        String result_word = right_side; // Result word

        // Get all unique letters from the equation
        Set<Character> all_letters_set = new HashSet<>(); // Set to store unique letters
        for (char c : word1.toCharArray()) all_letters_set.add(c); // Add letters from word1
        for (char c : word2.toCharArray()) all_letters_set.add(c); // Add letters from word2
        for (char c : result_word.toCharArray()) all_letters_set.add(c); // Add letters from result

        List<Character> letters = new ArrayList<>(all_letters_set); // Convert set to list

        // Check if we have too many letters (max 10 digits available)
        if (letters.size() > 10) {
            return false; // Impossible to solve with more than 10 unique letters
        }

        // Get letters that cannot be zero (leading letters)
        Set<Character> leading_letters = new HashSet<>(); // Set for leading letters
        if (word1.length() > 1) leading_letters.add(word1.charAt(0)); // Add first letter of word1
        if (word2.length() > 1) leading_letters.add(word2.charAt(0)); // Add first letter of word2
        if (result_word.length() > 1) leading_letters.add(result_word.charAt(0)); // Add first letter of result

        // Start backtracking to find valid assignment
        return backtrack(0, letters, new HashMap<>(), new boolean[10], 
                        word1, word2, result_word, leading_letters);
    }

    // Backtracking method to try all possible digit assignments
    private static boolean backtrack(int index, List<Character> letters, 
                                   Map<Character, Integer> assignment, boolean[] used_digits,
                                   String word1, String word2, String result_word,
                                   Set<Character> leading_letters) {
        
        // Base case: all letters assigned
        if (index == letters.size()) {
            return isValidAssignment(word1, word2, result_word, assignment); // Check if assignment is valid
        }

        char letter = letters.get(index); // Get current letter to assign

        // Try each digit from 0-9
        for (int digit = 0; digit <= 9; digit++) {
            if (!used_digits[digit]) { // If digit is not already used
                // Check leading zero constraint
                if (digit == 0 && leading_letters.contains(letter)) {
                    continue; // Skip if leading letter cannot be zero
                }

                // Make assignment
                assignment.put(letter, digit); // Assign digit to letter
                used_digits[digit] = true; // Mark digit as used

                // Recursively try next letter
                if (backtrack(index + 1, letters, assignment, used_digits,
                            word1, word2, result_word, leading_letters)) {
                    return true; // Found valid solution
                }

                // Backtrack
                assignment.remove(letter); // Remove assignment
                used_digits[digit] = false; // Mark digit as unused
            }
        }

        return false; // No valid assignment found
    }

    // Method to check if current assignment satisfies the equation
    private static boolean isValidAssignment(String word1, String word2, String result_word,
                                           Map<Character, Integer> assignment) {
        // Convert words to numbers using current assignment
        Integer num1 = wordToNumber(word1, assignment); // Convert word1 to number
        Integer num2 = wordToNumber(word2, assignment); // Convert word2 to number
        Integer result_num = wordToNumber(result_word, assignment); // Convert result to number

        // Check if all conversions were successful
        if (num1 == null || num2 == null || result_num == null) {
            return false; // Invalid assignment
        }

        // Check if equation is satisfied
        return num1 + num2 == result_num;
    }

    // Method to convert word to number using current assignment
    private static Integer wordToNumber(String word, Map<Character, Integer> assignment) {
        int number = 0; // Initialize number
        for (char c : word.toCharArray()) { // Loop through each character
            if (!assignment.containsKey(c)) {
                return null; // Assignment incomplete
            }
            number = number * 10 + assignment.get(c); // Build number digit by digit
        }
        return number; // Return converted number
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test case 1: SEND + MORE = MONEY
        String equation1 = "SEND + MORE = MONEY"; // Test equation
        boolean result1 = solveCryptarithmetic(equation1); // Solve puzzle
        System.out.println("'" + equation1 + "' -> " + result1); // Output result

        // Test case 2: Simple example
        String equation2 = "AB + CD = EFG"; // Test equation
        boolean result2 = solveCryptarithmetic(equation2); // Solve puzzle
        System.out.println("'" + equation2 + "' -> " + result2); // Output result
    }
}
