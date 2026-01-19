

public class Question_3a {
    // Method to find maximum repetitions of p2 that can be extracted from seqA
    public static int getMaxRepetitions(String p1, int t1, String p2, int t2) {
        // Create the full sequence A by repeating p1 t1 times
        StringBuilder seqA = new StringBuilder(); // StringBuilder for efficient string building
        for (int i = 0; i < t1; i++) { // Repeat p1 t1 times
            seqA.append(p1); // Append p1 to sequence
        }
        
        // Count how many times we can extract p2 from seqA
        int maxExtractions = countPatternOccurrences(seqA.toString(), p2); // Count occurrences
        
        // Return minimum of max extractions and t2 (we can't extract more than t2 times)
        return Math.min(maxExtractions, t2);
    }
    
    // Method to count pattern occurrences using two pointers approach
    private static int countPatternOccurrences(String s, String pattern) {
        int count = 0; // Initialize count
        int s_idx = 0; // Index for string s
        
        // Continue until we've processed all of string s
        while (s_idx < s.length()) {
            int p_idx = 0; // Index for pattern
            int temp_s_idx = s_idx; // Temporary index for s
            
            // Try to match pattern starting from current position
            while (temp_s_idx < s.length() && p_idx < pattern.length()) {
                if (s.charAt(temp_s_idx) == pattern.charAt(p_idx)) { // If characters match
                    p_idx++; // Move to next character in pattern
                }
                temp_s_idx++; // Always move to next character in s
            }
            
            // If we matched the entire pattern
            if (p_idx == pattern.length()) {
                count++; // Increment count
                s_idx = temp_s_idx; // Move s_idx to position after match
            } else {
                s_idx++; // Move to next position if no match
            }
        }
        
        return count; // Return total count
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Test case 1
        String p1 = "bca"; // Base pattern 1
        int t1 = 6; // Repetitions of p1
        String p2 = "ba"; // Base pattern 2
        int t2 = 3; // Maximum repetitions of p2
        int result1 = getMaxRepetitions(p1, t1, p2, t2); // Call method
        System.out.println("Test 1 - Expected: 3, Got: " + result1); // Output result
        
        // Test case 2
        String p1_2 = "abc"; // Base pattern 1
        int t1_2 = 4; // Repetitions of p1
        String p2_2 = "ab"; // Base pattern 2
        int t2_2 = 2; // Maximum repetitions of p2
        int result2 = getMaxRepetitions(p1_2, t1_2, p2_2, t2_2); // Call method
        System.out.println("Test 2 - Expected: 2, Got: " + result2); // Output result
    }
}
