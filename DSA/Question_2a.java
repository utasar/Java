/*
Question 2a: Weather Anomaly Detection

A climate scientist is analyzing temperature variations over a given period to detect unusual patterns in weather changes.

The scientist has a dataset containing the daily temperature changes (increase or decrease in °C) relative to the previous day. They want to count the number of continuous time periods where the total temperature change falls within a specified anomaly range [low_threshold, high_threshold].

Task: Count the number of continuous time periods where the total temperature change falls within the specified range.
*/

public class Question_2a {
    // Method to count anomaly periods within the specified threshold range
    public static int countAnomalyPeriods(int[] temperature_changes, int low_threshold, int high_threshold) {
        int n = temperature_changes.length; // Get the length of the temperature changes array
        int count = 0; // Initialize counter for anomaly periods

        // Check all possible subarrays (continuous time periods)
        for (int i = 0; i < n; i++) { // Start index of subarray
            int current_sum = 0; // Initialize sum for current subarray
            
            for (int j = i; j < n; j++) { // End index of subarray
                current_sum += temperature_changes[j]; // Add current element to sum
                
                // Check if current sum is within the threshold range
                if (current_sum >= low_threshold && current_sum <= high_threshold) {
                    count++; // Increment count if within range
                }
            }
        }

        return count; // Return total count of anomaly periods
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test case 1
        int[] temperature_changes1 = {3, -1, -4, 6, 2}; // Temperature changes array
        int result1 = countAnomalyPeriods(temperature_changes1, 2, 5); // Call method
        System.out.println("Test 1 - Expected: 3, Got: " + result1); // Output result

        // Test case 2
        int[] temperature_changes2 = {-2, 3, 1, -5, 4}; // Temperature changes array
        int result2 = countAnomalyPeriods(temperature_changes2, -1, 2); // Call method
        System.out.println("Test 2 - Expected: 4, Got: " + result2); // Output result
    }
}
