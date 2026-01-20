import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SalesReport extends JFrame {
    public SalesReport() {
        setTitle("GYM FITNESS CENTER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBounds(0, 0, 800, 60);
        headerPanel.setBackground(Color.WHITE);
        
        // Header buttons
        JLabel contactButton = new JLabel("Contact US", SwingConstants.CENTER);
        contactButton.setBounds(300, 15, 100, 30);
        
        JLabel feedbackButton = new JLabel("Feedback", SwingConstants.CENTER);
        feedbackButton.setBounds(410, 15, 100, 30);
        
        // Notification Icon
        JLabel notificationIcon = new JLabel("🔔", SwingConstants.RIGHT);
        notificationIcon.setBounds(750, 15, 30, 30);
        
          // Gym Fitness Logo
          JLabel logo = new JLabel(); // Create a JLabel for the logo

          // Load and resize the logo
          java.net.URL imgURL = getClass().getResource("logo.png"); // Ensure the logo.png is in the resources folder
          if (imgURL != null) {
              ImageIcon logoIcon = new ImageIcon(imgURL);
              Image img = logoIcon.getImage().getScaledInstance(130, 150, Image.SCALE_SMOOTH); // Resize to 130x150
              logo.setIcon(new ImageIcon(img)); // Set the resized logo
          } else {
              logo.setHorizontalAlignment(SwingConstants.CENTER);
              logo.setPreferredSize(new Dimension(130, 150));
          }
          // Set logo bounds (x, y, width, height)
          logo.setBounds(100, 25, 130, 150); // Position the logo at (750, 25)

        // Sales Report Panel
        JPanel salesPanel = new JPanel(null);
        salesPanel.setBounds(20, 100, 600, 100);
        salesPanel.setBackground(new Color(230, 230, 250));
        salesPanel.setBorder(BorderFactory.createTitledBorder("Sales Report"));
        
        // Date inputs
        JLabel fromLabel = new JLabel("From Date");
        fromLabel.setBounds(30, 30, 80, 25);
        JTextField fromDate = new JTextField();
        fromDate.setBounds(100, 30, 100, 25);

        JLabel toLabel = new JLabel("To Date");
        toLabel.setBounds(210, 30, 80, 25);
        JTextField toDate = new JTextField();
        toDate.setBounds(270, 30, 100, 25);

        JLabel totalLabel = new JLabel("Total");
        totalLabel.setBounds(380, 30, 80, 25);
        JTextField totalField = new JTextField();
        totalField.setBounds(460, 30, 100, 25);
        
        // Payment History Panel
        JPanel paymentPanel = new JPanel(null);
        paymentPanel.setBounds(20, 220, 760, 300);
        paymentPanel.setBackground(new Color(208, 224, 235));
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Payment History"));
        
        // Show Entries Dropdown
        JLabel showLabel = new JLabel("Show Entries");
        showLabel.setBounds(30, 30, 80, 25);
        JComboBox<String> entriesCombo = new JComboBox<>(new String[]{"10", "25", "50", "100"});
        entriesCombo.setBounds(110, 30, 60, 25);
        
        // Search field
        JTextField searchField = new JTextField();
        searchField.setBounds(560, 30, 150, 25);
        JLabel searchLabel = new JLabel("Search");
        searchLabel.setBounds(510, 30, 50, 25);
        
        // Payment History Table
        String[] columns = {"Member Name", "Member ID", "Plan", "Month", "Date Paid", "Amount"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable paymentTable = new JTable(model);
        paymentTable.setShowGrid(false); // Disable table grid lines
        paymentTable.setBackground(new Color(208, 224, 235)); // Set background color
        JScrollPane scrollPane = new JScrollPane(paymentTable);
        scrollPane.setBounds(30, 70, 700, 200);
        // Add sample data
        model.addRow(new Object[]{"Member 1", "SFM2301N1", "1 Month - PT", "JAN", "10-01-2023", "1300"});
        model.addRow(new Object[]{"Member 2", "SFM2301N2", "6 Months - PT", "JAN", "10-01-2023", "6000"});
        model.addRow(new Object[]{"Member 3", "SFM2301N3", "1 Month - M", "JAN", "10-01-2023", "1200"});
        model.addRow(new Object[]{"Member 4", "SFM2301N4", "3 Months", "JAN", "10-01-2023", "3500"});
        model.addRow(new Object[]{"Member 4", "SFM2301N4", "3 Months", "JAN", "10-01-2023", "3500"});
        model.addRow(new Object[]{"Member 4", "SFM2301N4", "3 Months", "JAN", "10-01-2023", "3500"});
        model.addRow(new Object[]{"Member 4", "SFM2301N4", "3 Months", "JAN", "10-01-2023", "3500"});
        model.addRow(new Object[]{"Member 4", "SFM2301N4", "3 Months", "JAN", "10-01-2023", "3500"});
        model.addRow(new Object[]{"Member 4", "SFM2301N4", "3 Months", "JAN", "10-01-2023", "3500"});
        model.addRow(new Object[]{"Member 4", "SFM2301N4", "3 Months", "JAN", "10-01-2023", "3500"});
        model.addRow(new Object[]{"Member 4", "SFM2301N4", "3 Months", "JAN", "10-01-2023", "3500"});
        model.addRow(new Object[]{"Member 4", "SFM2301N4", "3 Months", "JAN", "10-01-2023", "3500"});
        
        // Add components to panels
        headerPanel.add(contactButton);
        headerPanel.add(feedbackButton);
        headerPanel.add(notificationIcon);
        
        salesPanel.add(fromLabel);
        salesPanel.add(fromDate);
        salesPanel.add(toLabel);
        salesPanel.add(toDate);
        
        paymentPanel.add(showLabel);
        paymentPanel.add(entriesCombo);
        paymentPanel.add(searchLabel);
        paymentPanel.add(searchField);
        paymentPanel.add(scrollPane);

        // Add total label and field to salesPanel
        salesPanel.add(totalLabel);
        salesPanel.add(totalField);
        
        // Add panels to frame
        add(headerPanel);
        add(salesPanel);
        add(paymentPanel);
        
        // Set frame properties
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SalesReport().setVisible(true);
        });
    }
}
