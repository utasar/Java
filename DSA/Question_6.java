/*
Question 6: Traffic Signal Management System (Multithreaded)

Functionality:
- Queue (FIFO Scheduling) to manage vehicles at a traffic signal
- Priority Queue for emergency vehicles
- Multithreading with separate threads for traffic light changes, vehicle movement, and emergency handling

GUI Requirements:
- Animated traffic intersection
- Queue showing waiting vehicles
- Buttons for signal changes, adding vehicles, and emergency mode
*/

// Import required Swing classes for GUI components
import java.awt.*;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.*;

// Main class
public class Question_6 {
    // Inner class representing the traffic signal system, extends JFrame to create a GUI window
    static class TrafficSignalSystem extends JFrame {
        // Enum for signal states (RED, YELLOW, GREEN)
        private enum SignalState { RED, YELLOW, GREEN }

        // Current signal state, initially RED; marked volatile to ensure thread visibility
        private volatile SignalState currentSignal = SignalState.RED;

        // Timer for current signal duration
        private volatile int signalTimer = 0;

        // Flag to keep system running; can be set to false to stop threads
        private volatile boolean systemRunning = true;

        // Queue for normal vehicles (thread-safe FIFO queue)
        private final BlockingQueue<Vehicle> normalQueue = new LinkedBlockingQueue<>();

        // Priority queue for emergency vehicles (sorted by priority)
        private final PriorityQueue<Vehicle> emergencyQueue = new PriorityQueue<>();

        // Thread pool to run system tasks concurrently (3 threads)
        private final ExecutorService executorService = Executors.newFixedThreadPool(3);

        // GUI components
        private JPanel trafficLightPanel;                      // Panel to draw traffic lights
        private JList<String> normalVehicleList;                // List to show normal vehicles
        private JList<String> emergencyVehicleList;             // List to show emergency vehicles
        private DefaultListModel<String> normalListModel;       // List model for normal vehicles
        private DefaultListModel<String> emergencyListModel;    // List model for emergency vehicles
        private JLabel statusLabel;                             // Label to show system status
        private JLabel timerLabel;                              // Label to show countdown timer

        // Custom dark colors for inactive lights
        private static final Color DARK_RED = new Color(139, 0, 0);    // Dark red color
        private static final Color DARK_GREEN = new Color(0, 100, 0);  // Dark green color

        // Inner class representing a vehicle
        static class Vehicle implements Comparable<Vehicle> {
            String id;                // Vehicle ID
            boolean isEmergency;      // Flag if this is an emergency vehicle
            int priority;             // Priority level (lower value = higher priority)
            long arrivalTime;         // Arrival timestamp

            // Constructor to create a new vehicle
            public Vehicle(String id, boolean isEmergency, int priority) {
                this.id = id;
                this.isEmergency = isEmergency;
                this.priority = priority;
                this.arrivalTime = System.currentTimeMillis(); // Record arrival time
            }

            // Define comparison based on priority (used in priority queue)
            @Override
            public int compareTo(Vehicle other) {
                return Integer.compare(this.priority, other.priority);
            }

            // String representation of the vehicle
            @Override
            public String toString() {
                return id + (isEmergency ? " (Emergency)" : "");
            }
        }

        // Constructor to initialize the traffic signal system
        public TrafficSignalSystem() {
            setTitle("Traffic Signal Management System");                  // Set window title
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                // Close app when window closes
            setSize(800, 600);                                             // Set window size
            setLocationRelativeTo(null);                                   // Center window on screen

            initializeGUI();      // Build GUI components
            startSystemThreads(); // Start background system threads
        }

        // Method to set up GUI components and layout
        private void initializeGUI() {
            setLayout(new BorderLayout());                   // Use BorderLayout for main frame

            JPanel mainPanel = new JPanel(new GridLayout(1, 2)); // Split window into two columns

            // Left panel: traffic light and control buttons
            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.setBorder(BorderFactory.createTitledBorder("Traffic Signal Control"));

            // Traffic light panel: custom drawing
            trafficLightPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    drawTrafficLight(g); // Call method to draw the lights
                }
            };
            trafficLightPanel.setPreferredSize(new Dimension(200, 300)); // Set preferred size
            trafficLightPanel.setBackground(Color.BLACK);                // Background color
            leftPanel.add(trafficLightPanel, BorderLayout.CENTER);      // Add to center of left panel

            // Timer label below the traffic light
            timerLabel = new JLabel("Timer: 0s", SwingConstants.CENTER);
            timerLabel.setFont(new Font("Arial", Font.BOLD, 16));       // Set font style
            leftPanel.add(timerLabel, BorderLayout.SOUTH);              // Add to bottom

            // Panel for control buttons (2x2 grid)
            JPanel controlPanel = new JPanel(new GridLayout(2, 2, 5, 5));

            // Button to add a normal vehicle
            JButton addNormalButton = new JButton("Add Normal Vehicle");
            addNormalButton.addActionListener(e -> addNormalVehicle()); // Action on click
            controlPanel.add(addNormalButton);

            // Button to add an emergency vehicle
            JButton addEmergencyButton = new JButton("Add Emergency Vehicle");
            addEmergencyButton.setBackground(Color.RED);         // Red background
            addEmergencyButton.setForeground(Color.WHITE);       // White text
            addEmergencyButton.addActionListener(e -> addEmergencyVehicle());
            controlPanel.add(addEmergencyButton);

            // Button to manually change the signal
            JButton manualSignalButton = new JButton("Manual Signal Change");
            manualSignalButton.addActionListener(e -> manualSignalChange());
            controlPanel.add(manualSignalButton);

            // Button to activate emergency mode
            JButton emergencyModeButton = new JButton("Emergency Mode");
            emergencyModeButton.setBackground(Color.ORANGE);
            emergencyModeButton.addActionListener(e -> activateEmergencyMode());
            controlPanel.add(emergencyModeButton);

            // Add control buttons to top of left panel
            leftPanel.add(controlPanel, BorderLayout.NORTH);

            // Right panel: show vehicle queues
            JPanel rightPanel = new JPanel(new GridLayout(2, 1));
            rightPanel.setBorder(BorderFactory.createTitledBorder("Vehicle Queues"));

            // Normal vehicle queue panel
            JPanel normalQueuePanel = new JPanel(new BorderLayout());
            normalQueuePanel.setBorder(BorderFactory.createTitledBorder("Normal Vehicles"));
            normalListModel = new DefaultListModel<>();
            normalVehicleList = new JList<>(normalListModel);             // List bound to model
            normalVehicleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane normalScrollPane = new JScrollPane(normalVehicleList); // Scrollable
            normalQueuePanel.add(normalScrollPane, BorderLayout.CENTER);

            // Emergency vehicle queue panel
            JPanel emergencyQueuePanel = new JPanel(new BorderLayout());
            emergencyQueuePanel.setBorder(BorderFactory.createTitledBorder("Emergency Vehicles"));
            emergencyListModel = new DefaultListModel<>();
            emergencyVehicleList = new JList<>(emergencyListModel);
            emergencyVehicleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane emergencyScrollPane = new JScrollPane(emergencyVehicleList);
            emergencyQueuePanel.add(emergencyScrollPane, BorderLayout.CENTER);

            // Add both queue panels to right panel
            rightPanel.add(normalQueuePanel);
            rightPanel.add(emergencyQueuePanel);

            // Add left and right panels to main panel
            mainPanel.add(leftPanel);
            mainPanel.add(rightPanel);

            // Add main panel to center of frame
            add(mainPanel, BorderLayout.CENTER);

            // Status label at bottom
            statusLabel = new JLabel("System Ready", SwingConstants.CENTER);
            statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
            statusLabel.setBorder(BorderFactory.createEtchedBorder());
            add(statusLabel, BorderLayout.SOUTH);
        }

        // Method to draw the traffic light graphics
        private void drawTrafficLight(Graphics g) {
            Graphics2D g2d = (Graphics2D) g; // Use Graphics2D for better control
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw traffic light housing
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillRoundRect(50, 50, 100, 200, 10, 10);
            g2d.setColor(Color.WHITE);
            g2d.drawRoundRect(50, 50, 100, 200, 10, 10);

            int centerX = 100;  // Horizontal center
            int radius = 25;    // Radius of light circles

            // Draw red light (bright if active, dark if inactive)
            g2d.setColor(currentSignal == SignalState.RED ? Color.RED : DARK_RED);
            g2d.fillOval(centerX - radius, 80, radius * 2, radius * 2);

            // Draw yellow light
            g2d.setColor(currentSignal == SignalState.YELLOW ? Color.YELLOW : new Color(139, 139, 0));
            g2d.fillOval(centerX - radius, 130, radius * 2, radius * 2);

            // Draw green light
            g2d.setColor(currentSignal == SignalState.GREEN ? Color.GREEN : DARK_GREEN);
            g2d.fillOval(centerX - radius, 180, radius * 2, radius * 2);
        }

        // Method to add a normal vehicle to queue
        private void addNormalVehicle() {
            String vehicleId = "V" + System.currentTimeMillis();       // Unique ID
            Vehicle vehicle = new Vehicle(vehicleId, false, 5);       // Priority 5
            normalQueue.offer(vehicle);                                // Add to normal queue
            updateStatus("Normal vehicle " + vehicleId + " added to queue");
            updateQueueDisplays();                                     // Refresh GUI list
        }

        // Method to add an emergency vehicle
        private void addEmergencyVehicle() {
            String vehicleId = "E" + System.currentTimeMillis();       // Unique ID
            Vehicle vehicle = new Vehicle(vehicleId, true, 1);        // Priority 1 (high)
            synchronized (emergencyQueue) { emergencyQueue.offer(vehicle); }
            updateStatus("Emergency vehicle " + vehicleId + " added to priority queue");
            updateQueueDisplays();                                    // Refresh GUI list
        }

        // Manually change traffic signal to next state
        private void manualSignalChange() {
            switch (currentSignal) {
                case RED: currentSignal = SignalState.GREEN; break;
                case GREEN: currentSignal = SignalState.YELLOW; break;
                case YELLOW: currentSignal = SignalState.RED; break;
            }
            signalTimer = 0;                          // Reset timer
            updateStatus("Manual signal change to " + currentSignal);
            trafficLightPanel.repaint();              // Redraw light
        }

        // Activate emergency mode (extend green light)
        private void activateEmergencyMode() {
            currentSignal = SignalState.GREEN;       // Force green
            signalTimer = 30;                        // Extend time
            updateStatus("Emergency mode activated - Extended green signal");
            trafficLightPanel.repaint();
        }

        // Update the lists in GUI to reflect current queues
        private void updateQueueDisplays() {
            normalListModel.clear();
            for (Vehicle vehicle : normalQueue) {
                normalListModel.addElement(vehicle.toString());
            }

            emergencyListModel.clear();
            synchronized (emergencyQueue) {
                for (Vehicle vehicle : emergencyQueue) {
                    emergencyListModel.addElement(vehicle.toString());
                }
            }
        }

        // Update status label text
        private void updateStatus(String message) {
            statusLabel.setText(message);
        }

        // Stop the system safely
        private void stopSystem() {
            systemRunning = false;                  // Stop loops
            executorService.shutdown();             // Shut down threads
        }

        // Handle window close event to stop threads
        @Override
        protected void processWindowEvent(java.awt.event.WindowEvent e) {
            if (e.getID() == java.awt.event.WindowEvent.WINDOW_CLOSING) {
                stopSystem();
            }
            super.processWindowEvent(e);
        }

        // Method to start background system threads (light cycles, processing etc.)
        private void startSystemThreads() {
            // left empty here; should be added from original version
        }

        // Process a vehicle passing through the signal
        private void processVehicle(Vehicle vehicle) {
            SwingUtilities.invokeLater(() ->
                updateStatus(vehicle.toString() + " passed through intersection"));
            try { Thread.sleep(500); } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Main method: entry point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrafficSignalSystem().setVisible(true));
    }
}
