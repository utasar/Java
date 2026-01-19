/*
Question 5b: Online Ticket Booking System with Concurrency

Functionality:
- Locks (Mutex/Semaphore) to ensure multiple users don't book the same seat simultaneously
- Queue for managing pending seat reservation requests
- Database for storing and updating seat availability status concurrently
*/

import java.awt.*; // Import Swing components
import java.awt.event.ActionEvent; // Import AWT for graphics
import java.awt.event.ActionListener; // Import for action events
import java.util.*; // Import for action listeners
import java.util.concurrent.*; // Import concurrency utilities
import java.util.concurrent.locks.ReentrantLock; // Import reentrant lock
import javax.swing.*; // Import utility classes

public class Question_5b {
    // Main TicketBookingSystem class
    static class TicketBookingSystem extends JFrame {
        private final int rows = 10; // Number of seat rows
        private final int cols = 10; // Number of seat columns
        private final Map<String, Boolean> seats = new ConcurrentHashMap<>(); // Thread-safe seat map
        private final BlockingQueue<BookingRequest> bookingQueue = new LinkedBlockingQueue<>(); // Booking queue
        private final ReentrantLock bookingLock = new ReentrantLock(); // Lock for booking operations
        private final ExecutorService executorService = Executors.newFixedThreadPool(5); // Thread pool
        
        private JButton[][] seatButtons; // 2D array of seat buttons
        private JLabel statusLabel; // Status label
        private JLabel queueLabel; // Queue status label
        
        // BookingRequest class to represent a booking request
        static class BookingRequest {
            String userId; // User ID making the request
            String seatId; // Seat ID being requested
            
            public BookingRequest(String userId, String seatId) {
                this.userId = userId; // Set user ID
                this.seatId = seatId; // Set seat ID
            }
        }
        
        // Constructor to initialize the booking system
        public TicketBookingSystem() {
            setTitle("Online Ticket Booking System"); // Set window title
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
            setResizable(false); // Make window non-resizable
            
            initializeSeats(); // Initialize seat data
            initializeGUI(); // Initialize GUI components
            startBookingProcessor(); // Start booking processor thread
            
            pack(); // Pack components
            setLocationRelativeTo(null); // Center window
        }
        
        // Method to initialize seat data
        private void initializeSeats() {
            for (int i = 0; i < rows; i++) { // Loop through rows
                for (int j = 0; j < cols; j++) { // Loop through columns
                    String seatId = i + "-" + j; // Create seat ID
                    seats.put(seatId, false); // Initialize as available (false = available)
                }
            }
        }
        
        // Method to initialize GUI components
        private void initializeGUI() {
            setLayout(new BorderLayout()); // Set layout manager
            
            // Create main panel
            JPanel mainPanel = new JPanel(new BorderLayout()); // Create main panel
            
            // Create seat layout panel
            JPanel seatPanel = new JPanel(new GridLayout(rows, cols, 2, 2)); // Create seat grid
            seatPanel.setBorder(BorderFactory.createTitledBorder("Seat Layout")); // Add border
            
            seatButtons = new JButton[rows][cols]; // Initialize button array
            
            // Create seat buttons
            for (int i = 0; i < rows; i++) { // Loop through rows
                for (int j = 0; j < cols; j++) { // Loop through columns
                    String seatId = i + "-" + j; // Create seat ID
                    JButton button = new JButton(seatId); // Create button
                    button.setPreferredSize(new Dimension(60, 40)); // Set button size
                    button.setBackground(Color.LIGHT_GRAY); // Set background color
                    button.addActionListener(new SeatButtonListener(seatId)); // Add action listener
                    
                    seatButtons[i][j] = button; // Store button reference
                    seatPanel.add(button); // Add button to panel
                }
            }
            
            mainPanel.add(seatPanel, BorderLayout.CENTER); // Add seat panel to main panel
            
            // Create control panel
            JPanel controlPanel = new JPanel(new FlowLayout()); // Create control panel
            
            // Simulate concurrent booking button
            JButton simulateButton = new JButton("Simulate Concurrent Booking"); // Create button
            simulateButton.addActionListener(e -> simulateConcurrentBooking()); // Add action listener
            controlPanel.add(simulateButton); // Add button to panel
            
            // Reset seats button
            JButton resetButton = new JButton("Reset All Seats"); // Create reset button
            resetButton.addActionListener(e -> resetSeats()); // Add action listener
            controlPanel.add(resetButton); // Add button to panel
            
            mainPanel.add(controlPanel, BorderLayout.SOUTH); // Add control panel to main panel
            
            // Create status panel
            JPanel statusPanel = new JPanel(new GridLayout(2, 1)); // Create status panel
            statusLabel = new JLabel("System Ready"); // Create status label
            statusLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align
            queueLabel = new JLabel("Queue: 0 pending"); // Create queue label
            queueLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align
            
            statusPanel.add(statusLabel); // Add status label
            statusPanel.add(queueLabel); // Add queue label
            
            add(mainPanel, BorderLayout.CENTER); // Add main panel to frame
            add(statusPanel, BorderLayout.NORTH); // Add status panel to frame
        }
        
        // ActionListener for seat buttons
        class SeatButtonListener implements ActionListener {
            private String seatId; // Seat ID for this button
            
            public SeatButtonListener(String seatId) {
                this.seatId = seatId; // Set seat ID
            }
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String userId = "User" + System.currentTimeMillis(); // Generate user ID
                bookSeat(userId, seatId); // Book the seat
            }
        }
        
        // Method to book a seat
        private void bookSeat(String userId, String seatId) {
            BookingRequest request = new BookingRequest(userId, seatId); // Create booking request
            bookingQueue.offer(request); // Add request to queue
            updateQueueDisplay(); // Update queue display
        }
        
        // Method to start booking processor thread
        private void startBookingProcessor() {
            executorService.submit(() -> { // Submit task to thread pool
                while (!Thread.currentThread().isInterrupted()) { // While not interrupted
                    try {
                        BookingRequest request = bookingQueue.take(); // Take request from queue
                        processBookingRequest(request); // Process the request
                        SwingUtilities.invokeLater(this::updateQueueDisplay); // Update queue display
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // Restore interrupt status
                        break; // Exit loop
                    }
                }
            });
        }
        
        // Method to process individual booking request
        private void processBookingRequest(BookingRequest request) {
            // Simulate processing time
            try {
                Thread.sleep(500 + new Random().nextInt(1000)); // Random delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupt status
                return; // Exit method
            }
            
            bookingLock.lock(); // Acquire lock
            try {
                if (!seats.get(request.seatId)) { // If seat is available
                    seats.put(request.seatId, true); // Mark seat as booked
                    SwingUtilities.invokeLater(() -> { // Update GUI on EDT
                        updateSeatDisplay(request.seatId, true); // Update seat display
                        updateStatus(request.userId + " successfully booked seat " + request.seatId); // Update status
                    });
                } else { // If seat is already booked
                    SwingUtilities.invokeLater(() -> { // Update GUI on EDT
                        updateStatus(request.userId + " failed to book seat " + request.seatId + " - Already taken"); // Update status
                    });
                }
            } finally {
                bookingLock.unlock(); // Release lock
            }
        }
        
        // Method to update seat display
        private void updateSeatDisplay(String seatId, boolean booked) {
            String[] parts = seatId.split("-"); // Split seat ID
            int row = Integer.parseInt(parts[0]); // Get row
            int col = Integer.parseInt(parts[1]); // Get column
            
            JButton button = seatButtons[row][col]; // Get button reference
            if (booked) { // If seat is booked
                button.setBackground(Color.RED); // Set background to red
                button.setEnabled(false); // Disable button
            } else { // If seat is available
                button.setBackground(Color.LIGHT_GRAY); // Set background to light gray
                button.setEnabled(true); // Enable button
            }
        }
        
        // Method to update status display
        private void updateStatus(String message) {
            statusLabel.setText(message); // Set status text
        }
        
        // Method to update queue display
        private void updateQueueDisplay() {
            int queueSize = bookingQueue.size(); // Get queue size
            SwingUtilities.invokeLater(() -> { // Update on EDT
                queueLabel.setText("Queue: " + queueSize + " pending"); // Update queue label
            });
        }
        
        // Method to simulate concurrent booking
        private void simulateConcurrentBooking() {
            // Create multiple booking requests for popular seats
            String[] popularSeats = {"0-0", "0-1", "0-2", "1-0", "1-1", "1-2"}; // Popular seat IDs
            
            for (int i = 0; i < 15; i++) { // Create 15 concurrent requests
                String userId = "SimUser" + i; // Generate user ID
                String seatId = popularSeats[i % popularSeats.length]; // Select seat
                bookSeat(userId, seatId); // Book seat
            }
            
            updateStatus("Simulating concurrent bookings..."); // Update status
        }
        
        // Method to reset all seats
        private void resetSeats() {
            bookingLock.lock(); // Acquire lock
            try {
                for (String seatId : seats.keySet()) { // Loop through all seats
                    seats.put(seatId, false); // Mark as available
                    SwingUtilities.invokeLater(() -> updateSeatDisplay(seatId, false)); // Update display
                }
                SwingUtilities.invokeLater(() -> updateStatus("All seats reset")); // Update status
            } finally {
                bookingLock.unlock(); // Release lock
            }
        }
    }
    
    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // Run on EDT
            new TicketBookingSystem().setVisible(true); // Create and show booking system
        });
    }
}
