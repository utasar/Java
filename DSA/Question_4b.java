/*
Question 4b: Treasure Hunt Game

A Treasure Hunt Game is played on an undirected graph by two players:
- Player 1 starts at node 1 and moves first
- Player 2 starts at node 2 and moves second  
- There is a Treasure at node 0

Task: Determine the winner of the game based on the game rules.
*/

import java.util.*; // Import utility classes

public class Question_4b {
    // Method to determine winner of treasure hunt game
    public static int treasureHuntGame(List<List<Integer>> graph) {
        // Player 1 starts at node 1, Player 2 starts at node 2
        // Treasure is at node 0
        // Returns: 1 if Player 1 wins, 2 if Player 2 wins, 0 if draw

        return dfs(1, 2, 1, new HashSet<>(), graph); // Pass graph into dfs
    }

    // DFS method to simulate game play
    private static int dfs(int p1_pos, int p2_pos, int turn, Set<String> visited_states, List<List<Integer>> graph) {
        // State representation: "p1_pos,p2_pos,turn"
        String state = p1_pos + "," + p2_pos + "," + turn; // Create state string

        // Check for cycle (draw condition)
        if (visited_states.contains(state)) {
            return 0; // Draw due to cycle
        }

        visited_states.add(state); // Add current state to visited

        if (turn == 1) { // Player 1's turn
            // Check win condition for Player 1
            if (p1_pos == 0) {
                return 1; // Player 1 wins by reaching treasure
            }

            // Check if Player 2 catches Player 1
            if (p1_pos == p2_pos) {
                return 2; // Player 2 catches Player 1
            }

            // Try all possible moves for Player 1
            for (int next_pos : graph.get(p1_pos)) {
                Set<String> new_visited = new HashSet<>(visited_states); // Copy visited states
                int result = dfs(next_pos, p2_pos, 2, new_visited, graph); // Pass graph
                if (result == 1) {
                    return 1; // Player 1 can win from this move
                }
            }

            return 2; // Player 1 cannot win, Player 2 wins
        } else { // Player 2's turn
            // Check if Player 2 catches Player 1
            if (p1_pos == p2_pos) {
                return 2; // Player 2 catches Player 1
            }

            // Try all possible moves for Player 2 (except node 0)
            for (int next_pos : graph.get(p2_pos)) {
                if (next_pos != 0) { // Player 2 cannot go to treasure
                    Set<String> new_visited = new HashSet<>(visited_states); // Copy visited states
                    int result = dfs(p1_pos, next_pos, 1, new_visited, graph); // Pass graph
                    if (result == 2) {
                        return 2; // Player 2 can win from this move
                    }
                }
            }

            return 1; // Player 2 cannot catch, Player 1 wins
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create graph representation
        List<List<Integer>> graph = new ArrayList<>(); // Initialize graph

        // Add adjacency lists for each node
        graph.add(Arrays.asList(2, 5));      // Node 0 connected to 2, 5
        graph.add(Arrays.asList(3));         // Node 1 connected to 3
        graph.add(Arrays.asList(0, 4, 5));   // Node 2 connected to 0, 4, 5
        graph.add(Arrays.asList(1, 4, 5));   // Node 3 connected to 1, 4, 5
        graph.add(Arrays.asList(2, 3));      // Node 4 connected to 2, 3
        graph.add(Arrays.asList(0, 2, 3));   // Node 5 connected to 0, 2, 3

        // Test the game
        int result = treasureHuntGame(graph); // Play the game
        System.out.println("Game result: " + result);

        // Interpret result
        if (result == 1) {
            System.out.println("Player 1 wins!");
        } else if (result == 2) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
