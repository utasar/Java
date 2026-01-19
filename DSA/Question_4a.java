/*
Question 4a: Secure Transmission Network

A company's offices are connected by secure communication links, where each office is represented as a node and each communication link is represented as an edge with a signal strength limit.

Task: Implement the SecureTransmission class with methods to verify if a message can be securely transmitted from one office to another without exceeding the maximum signal strength.
*/

import java.util.*; // Import utility classes

public class Question_4a {
    // SecureTransmission class to manage network transmission
    static class SecureTransmission {
        private int n; // Number of offices (nodes)
        private List<List<int[]>> graph; // Adjacency list representation of graph
        
        // Constructor to initialize the network
        public SecureTransmission(int n, int[][] links) {
            this.n = n; // Set number of nodes
            this.graph = new ArrayList<>(); // Initialize graph
            
            // Initialize adjacency list for each node
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>()); // Add empty list for each node
            }
            
            // Build adjacency list from links
            for (int[] link : links) {
                int a = link[0]; // First office
                int b = link[1]; // Second office
                int strength = link[2]; // Signal strength
                
                // Add bidirectional edges (undirected graph)
                graph.get(a).add(new int[]{b, strength}); // Add edge from a to b
                graph.get(b).add(new int[]{a, strength}); // Add edge from b to a
            }
        }
        
        // Method to check if transmission is possible within signal strength limit
        public boolean canTransmit(int sender, int receiver, int maxStrength) {
            // Use DFS to find if there's a path with all edges < maxStrength
            boolean[] visited = new boolean[n]; // Array to track visited nodes
            return dfs(sender, receiver, maxStrength, visited); // Start DFS
        }
        
        // DFS method to find path within strength limit
        private boolean dfs(int node, int target, int maxStrength, boolean[] visited) {
            // Base case: reached target
            if (node == target) {
                return true; // Found path to target
            }
            
            visited[node] = true; // Mark current node as visited
            
            // Explore all neighbors
            for (int[] edge : graph.get(node)) {
                int neighbor = edge[0]; // Neighbor node
                int strength = edge[1]; // Edge strength
                
                // Check if neighbor is unvisited and edge strength is within limit
                if (!visited[neighbor] && strength < maxStrength) {
                    if (dfs(neighbor, target, maxStrength, visited)) { // Recursive call
                        return true; // Found path through this neighbor
                    }
                }
            }
            
            return false; // No path found from this node
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Create network with 6 offices and given links
        int[][] links = {{0, 2, 4}, {2, 3, 1}, {2, 1, 3}, {4, 5, 5}}; // Network links
        SecureTransmission st = new SecureTransmission(6, links); // Create network
        
        // Test cases
        System.out.println(st.canTransmit(2, 3, 2)); // Expected: true
        System.out.println(st.canTransmit(1, 3, 3)); // Expected: false  
        System.out.println(st.canTransmit(2, 0, 3)); // Expected: true
        System.out.println(st.canTransmit(0, 5, 6)); // Expected: false
    }
}
