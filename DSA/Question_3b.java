

import java.util.*; // Import utility classes

public class Question_3b {
    // Class to represent a palindrome with its start, end positions and length
    static class Palindrome {
        int start, end, length; // Start index, end index, and length of palindrome
        
        public Palindrome(int start, int end, int length) {
            this.start = start; // Set start position
            this.end = end; // Set end position
            this.length = length; // Set length
        }
    }
    
    // Method to find maximum power combination of two non-overlapping magical words
    public static int maxMagicalWordsPower(String M) {
        int n = M.length(); // Get length of manuscript
        
        // Find all palindromes with odd length (magical words)
        List<Palindrome> palindromes = findAllOddPalindromes(M); // Get all odd palindromes
        
        // Find maximum product of two non-overlapping palindromes
        int maxProduct = 0; // Initialize maximum product
        
        // Check all pairs of palindromes
        for (int i = 0; i < palindromes.size(); i++) {
            for (int j = i + 1; j < palindromes.size(); j++) {
                Palindrome p1 = palindromes.get(i); // First palindrome
                Palindrome p2 = palindromes.get(j); // Second palindrome
                
                // Check if they don't overlap
                if (p1.end < p2.start || p2.end < p1.start) {
                    int product = p1.length * p2.length; // Calculate power combination
                    maxProduct = Math.max(maxProduct, product); // Update maximum
                }
            }
        }
        
        return maxProduct; // Return maximum power combination
    }
    
    // Method to find all palindromes with odd length
    private static List<Palindrome> findAllOddPalindromes(String s) {
        List<Palindrome> palindromes = new ArrayList<>(); // List to store palindromes
        
        // Check for odd-length palindromes centered at each position
        for (int center = 0; center < s.length(); center++) {
            // Expand around center
            int left = center, right = center; // Initialize left and right pointers
            
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int length = right - left + 1; // Calculate current length
                if (length % 2 == 1) { // If odd length (magical word)
                    palindromes.add(new Palindrome(left, right, length)); // Add to list
                }
                left--; // Expand left
                right++; // Expand right
            }
        }
        
        return palindromes; // Return list of palindromes
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Test case 1
        String M1 = "xyzyxabc"; // Manuscript string
        int result1 = maxMagicalWordsPower(M1); // Find maximum power
        System.out.println("Test 1 - Expected: 5, Got: " + result1); // Output result
        
        // Test case 2
        String M2 = "levelwowracecar"; // Manuscript string
        int result2 = maxMagicalWordsPower(M2); // Find maximum power
        System.out.println("Test 2 - Expected: 35, Got: " + result2); // Output result
    }
}
