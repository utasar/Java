/*
Question 5a: Maze Solver with GUI

Functionality:
- Graph representation of the maze where each cell is a node
- Stack (DFS) / Queue (BFS) to find a path from start to finish
- GUI with grid-based maze, start/end points, and algorithm selection buttons
*/

import java.awt.*; // Import Swing components for GUI
import java.util.*; // Import AWT for graphics and layout
import javax.swing.*; // Import for action events

public class Question_5a {
    // Main MazeSolver class with GUI components
    static class MazeSolver extends JFrame {
        private int width = 20; // Width of the maze grid
        private int height = 20; // Height of the maze grid
        private int cellSize = 25; // Size of each cell in pixels
        private int[][] maze; // 2D array representing the maze (0=path, 1=wall)
        private Point start = new Point(0, 0); // Starting position
        private Point end = new Point(height-1, width-1); // Ending position
        private java.util.List<Point> solutionPath = new ArrayList<>(); // Path solution
        private JPanel mazePanel; // Panel to draw the maze
        
        // Constructor to initialize the maze solver
        public MazeSolver() {
            setTitle("Maze Solver"); // Set window title
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
            setResizable(false); // Make window non-resizable
            
            initializeComponents(); // Initialize GUI components
            generateMaze(); // Generate initial maze
            pack(); // Pack components
            setLocationRelativeTo(null); // Center window on screen
        }
        
        // Method to initialize GUI components
        private void initializeComponents() {
            setLayout(new BorderLayout()); // Set layout manager
            
            // Create maze panel
            mazePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) { // Override paint method
                    super.paintComponent(g); // Call parent paint method
                    drawMaze(g); // Draw the maze
                }
            };
            mazePanel.setPreferredSize(new Dimension(width * cellSize, height * cellSize)); // Set panel size
            mazePanel.setBackground(Color.WHITE); // Set background color
            add(mazePanel, BorderLayout.CENTER); // Add panel to center
            
            // Create control panel with buttons
            JPanel controlPanel = new JPanel(); // Create control panel
            controlPanel.setLayout(new FlowLayout()); // Set flow layout
            
            // Generate maze button
            JButton generateButton = new JButton("Generate Maze"); // Create button
            generateButton.addActionListener(e -> { // Add action listener
                generateMaze(); // Generate new maze
                solutionPath.clear(); // Clear solution path
                mazePanel.repaint(); // Repaint maze
            });
            controlPanel.add(generateButton); // Add button to panel
            
            // Solve with DFS button
            JButton dfsButton = new JButton("Solve DFS"); // Create DFS button
            dfsButton.addActionListener(e -> { // Add action listener
                solveDFS(); // Solve using DFS
                mazePanel.repaint(); // Repaint maze
            });
            controlPanel.add(dfsButton); // Add button to panel
            
            // Solve with BFS button
            JButton bfsButton = new JButton("Solve BFS"); // Create BFS button
            bfsButton.addActionListener(e -> { // Add action listener
                solveBFS(); // Solve using BFS
                mazePanel.repaint(); // Repaint maze
            });
            controlPanel.add(bfsButton); // Add button to panel
            
            // Clear solution button
            JButton clearButton = new JButton("Clear Solution"); // Create clear button
            clearButton.addActionListener(e -> { // Add action listener
                solutionPath.clear(); // Clear solution path
                mazePanel.repaint(); // Repaint maze
            });
            controlPanel.add(clearButton); // Add button to panel
            
            add(controlPanel, BorderLayout.SOUTH); // Add control panel to bottom
        }
        
        // Method to generate a random maze
        private void generateMaze() {
            maze = new int[height][width]; // Initialize maze array
            Random random = new Random(); // Create random generator
            
            // Generate random maze (0 = path, 1 = wall)
            for (int i = 0; i < height; i++) { // Loop through rows
                for (int j = 0; j < width; j++) { // Loop through columns
                    maze[i][j] = random.nextBoolean() ? 1 : 0; // Randomly assign wall or path
                }
            }
            
            // Ensure start and end are paths
            maze[start.x][start.y] = 0; // Set start as path
            maze[end.x][end.y] = 0; // Set end as path
            
            // Ensure there's at least one diagonal path
            for (int i = 0; i < Math.min(height, width); i++) { // Loop diagonally
                if (i < height && i < width) { // Check bounds
                    maze[i][i] = 0; // Set diagonal cells as paths
                }
            }
        }
        
        // Method to draw the maze
        private void drawMaze(Graphics g) {
            // Draw maze cells
            for (int i = 0; i < height; i++) { // Loop through rows
                for (int j = 0; j < width; j++) { // Loop through columns
                    int x = j * cellSize; // Calculate x position
                    int y = i * cellSize; // Calculate y position
                    
                    if (maze[i][j] == 1) { // If wall
                        g.setColor(Color.BLACK); // Set color to black
                        g.fillRect(x, y, cellSize, cellSize); // Fill rectangle
                    } else { // If path
                        g.setColor(Color.WHITE); // Set color to white
                        g.fillRect(x, y, cellSize, cellSize); // Fill rectangle
                        g.setColor(Color.GRAY); // Set border color
                        g.drawRect(x, y, cellSize, cellSize); // Draw border
                    }
                }
            }
            
            // Draw start point
            g.setColor(Color.GREEN); // Set color to green
            g.fillRect(start.y * cellSize, start.x * cellSize, cellSize, cellSize); // Fill start cell
            
            // Draw end point
            g.setColor(Color.RED); // Set color to red
            g.fillRect(end.y * cellSize, end.x * cellSize, cellSize, cellSize); // Fill end cell
            
            // Draw solution path
            g.setColor(Color.BLUE); // Set color to blue
            for (Point p : solutionPath) { // Loop through solution path
                if (!p.equals(start) && !p.equals(end)) { // Skip start and end points
                    g.fillRect(p.y * cellSize, p.x * cellSize, cellSize, cellSize); // Fill path cell
                }
            }
        }
        
        // Method to get valid neighbors of a cell
        private java.util.List<Point> getNeighbors(Point point) {
            java.util.List<Point> neighbors = new ArrayList<>(); // Create neighbors list
            int[] dx = {0, 1, 0, -1}; // Direction arrays for x
            int[] dy = {1, 0, -1, 0}; // Direction arrays for y
            
            for (int i = 0; i < 4; i++) { // Loop through 4 directions
                int newX = point.x + dx[i]; // Calculate new x
                int newY = point.y + dy[i]; // Calculate new y
                
                // Check bounds and if cell is a path
                if (newX >= 0 && newX < height && newY >= 0 && newY < width && maze[newX][newY] == 0) {
                    neighbors.add(new Point(newX, newY)); // Add valid neighbor
                }
            }
            
            return neighbors; // Return neighbors list
        }
        
        // Method to solve maze using DFS (Depth-First Search)
        private void solveDFS() {
            solutionPath.clear(); // Clear previous solution
            Set<Point> visited = new HashSet<>(); // Set to track visited cells
            Stack<Point> path = new Stack<>(); // Stack to store current path
            
            if (dfs(start, visited, path)) { // If DFS finds solution
                solutionPath = new ArrayList<>(path); // Copy path to solution
                JOptionPane.showMessageDialog(this, "Path found using DFS!"); // Show success message
            } else {
                JOptionPane.showMessageDialog(this, "No path found!"); // Show failure message
            }
        }
        
        // Recursive DFS method
        private boolean dfs(Point current, Set<Point> visited, Stack<Point> path) {
            if (current.equals(end)) { // If reached end
                path.push(current); // Add end to path
                return true; // Return success
            }
            
            visited.add(current); // Mark current as visited
            path.push(current); // Add current to path
            
            for (Point neighbor : getNeighbors(current)) { // Loop through neighbors
                if (!visited.contains(neighbor)) { // If neighbor not visited
                    if (dfs(neighbor, visited, path)) { // Recursive call
                        return true; // Return success if path found
                    }
                }
            }
            
            path.pop(); // Backtrack - remove current from path
            return false; // Return failure
        }
        
        // Method to solve maze using BFS (Breadth-First Search)
        private void solveBFS() {
            solutionPath.clear(); // Clear previous solution
            Queue<Point> queue = new LinkedList<>(); // Queue for BFS
            Set<Point> visited = new HashSet<>(); // Set to track visited cells
            Map<Point, Point> parent = new HashMap<>(); // Map to track parent cells
            
            queue.offer(start); // Add start to queue
            visited.add(start); // Mark start as visited
            parent.put(start, null); // Start has no parent
            
            while (!queue.isEmpty()) { // While queue is not empty
                Point current = queue.poll(); // Get current cell from queue
                
                if (current.equals(end)) { // If reached end
                    // Reconstruct path
                    java.util.List<Point> path = new ArrayList<>(); // Create path list
                    Point p = end; // Start from end
                    while (p != null) { // While not reached start
                        path.add(0, p); // Add to beginning of path
                        p = parent.get(p); // Move to parent
                    }
                    solutionPath = path; // Set solution path
                    JOptionPane.showMessageDialog(this, "Path found using BFS!"); // Show success message
                    return; // Exit method
                }
                
                for (Point neighbor : getNeighbors(current)) { // Loop through neighbors
                    if (!visited.contains(neighbor)) { // If neighbor not visited
                        visited.add(neighbor); // Mark neighbor as visited
                        parent.put(neighbor, current); // Set parent
                        queue.offer(neighbor); // Add neighbor to queue
                    }
                }
            }
            
            JOptionPane.showMessageDialog(this, "No path found!"); // Show failure message
        }
    }
    
    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Run on EDT
            new MazeSolver().setVisible(true); // Create and show maze solver
        });
    }
}
