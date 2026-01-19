/*A tech startup, AlgoStart, is planning to get acquired by a larger company. To negotiate a higher 
acquisition price, AlgoStart wants to increase its revenue by launching a few high-return projects. 
However, due to limited resources, the startup can only work on at most k distinct projects before the 
acquisition. 
You are given n potential projects, where the i-th project has a projected revenue gain of revenues[i] 
and requires a minimum investment capital of investments[i] to launch. 
Initially, AlgoStart has c capital. When a project is completed, its revenue gain is added to the 
startup’s total capital, which can then be reinvested into other projects. */


import java.util.*;

// Define the main public class for Question 1a
public class Question_1a {
    
    // Static method to find maximum capital - can be called without creating class instance
    public static int findMaximizedCapital(int k, int c, int[] revenues, int[] investments) {
        /**
         * Method documentation explaining the purpose and parameters
         * Find the maximum capital after completing at most k projects
         * 
         * @param k Maximum number of projects to complete
         * @param c Initial capital available
         * @param revenues Array of revenue gains for each project
         * @param investments Array of investment requirements for each project
         * @return Maximum possible capital after completing at most k projects
         */
        
        // Create an ArrayList to store project data as integer arrays [investment, revenue]
        List<int[]> projects = new ArrayList<>();
        
        // Loop through all projects to create project pairs
        for (int i = 0; i < investments.length; i++) {
            // Create a new array containing investment and revenue for each project
            // Add this project array to the projects list
            projects.add(new int[]{investments[i], revenues[i]});
        }
        
        // Sort projects by investment requirement (ascending order)
        // Lambda expression compares first element (investment) of each project array
        projects.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        // Create a max heap (priority queue) for available projects based on revenue
        // Collections.reverseOrder() makes it a max heap instead of default min heap
        PriorityQueue<Integer> availableProjects = new PriorityQueue<>(Collections.reverseOrder());
        
        // Initialize current capital with the starting capital
        int currentCapital = c;
        
        // Initialize index to track which projects we've considered so far
        int projectIndex = 0;
        
        // Main loop: complete at most k projects
        for (int i = 0; i < k; i++) {
            // Inner loop: add all currently affordable projects to the heap
            while (projectIndex < projects.size() && 
                   projects.get(projectIndex)[0] <= currentCapital) {
                
                // Extract investment amount from current project (index 0)
                int investment = projects.get(projectIndex)[0];
                
                // Extract revenue amount from current project (index 1)
                int revenue = projects.get(projectIndex)[1];
                
                // Add revenue to max heap (we only care about revenue for selection)
                availableProjects.offer(revenue);
                
                // Move to next project in sorted list
                projectIndex++;
            }
            
            // Check if we have any projects available to execute
            if (availableProjects.isEmpty()) {
                // No affordable projects available, exit the loop early
                break;
            }
            
            // Select and remove the project with maximum revenue from heap
            int maxRevenue = availableProjects.poll();
            
            // Add the revenue to our current capital
            currentCapital += maxRevenue;
        }
        
        // Return the final capital amount after completing projects
        return currentCapital;
    }
    
    // Main method - entry point of the program
    public static void main(String[] args) {
        
        // Test case 1: k=2, c=0, revenues=[2,5,8], investments=[0,2,3]
        // Create array for revenues in test case 1
        int[] revenues1 = {2, 5, 8};
        
        // Create array for investments in test case 1
        int[] investments1 = {0, 2, 3};
        
        // Call the method with test case 1 parameters and store result
        int result1 = findMaximizedCapital(2, 0, revenues1, investments1);
        
        // Print the result with expected vs actual comparison
        System.out.println("Test 1 - Expected: 7, Got: " + result1);
        
        // Test case 2: k=3, c=1, revenues=[3,6,10], investments=[1,3,5]
        // Create array for revenues in test case 2
        int[] revenues2 = {3, 6, 10};
        
        // Create array for investments in test case 2
        int[] investments2 = {1, 3, 5};
        
        // Call the method with test case 2 parameters and store result
        int result2 = findMaximizedCapital(3, 1, revenues2, investments2);
        
        // Print the result with expected vs actual comparison
        System.out.println("Test 2 - Expected: 19, Got: " + result2);
        
        // Additional test case for edge case testing
        // Create array for revenues in test case 3
        int[] revenues3 = {1, 2, 3};
        
        // Create array for investments in test case 3
        int[] investments3 = {0, 1, 1};
        
        // Call the method with test case 3 parameters and store result
        int result3 = findMaximizedCapital(1, 0, revenues3, investments3);
        
        // Print the result with expected vs actual comparison
        System.out.println("Test 3 - Expected: 3, Got: " + result3);
        
        // Print detailed walkthrough explanation for better understanding
        System.out.println("\nDetailed walkthrough for Test 1:");
        
        // Explain initial state
        System.out.println("Initial capital: 0");
        
        // Show sorted projects after processing
        System.out.println("Projects: [(0,2), (2,5), (3,8)]");
        
        // Explain step 1 of algorithm execution
        System.out.println("Step 1: Can afford project (0,2), gain 2, capital = 2");
        
        // Explain step 2 of algorithm execution
        System.out.println("Step 2: Can afford project (2,5), gain 5, capital = 7");
        
        // Show final result
        System.out.println("Final capital: 7");
    }
}
