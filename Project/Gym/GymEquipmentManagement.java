import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
 
public class GymEquipmentManagement extends JFrame {
    private JTable equipmentTable;
    private JTextField searchField;
    private JPanel addEquipmentPanel;
    private JPanel equipmentListPanel;
 
    public GymEquipmentManagement() {
        setTitle("GYM FITNESS CENTER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeUI();
        pack();
        setSize(1200, 700);
        setLocationRelativeTo(null);
    }
 
    private void initializeUI() {
        // Main layout
        setLayout(new BorderLayout(10, 10));
       
        // Top bar
        add(createTopBar(), BorderLayout.NORTH);

        // Gym Fitness Logo
        JLabel logo = new JLabel(); // Create a JLabel for the logo
        
        // Load and resize the logo
        ImageIcon logoIcon = new ImageIcon("C:logo.png"); // Update with your logo path
        Image img = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Resize to 200x200
        logo.setIcon(new ImageIcon(img)); // Set the resized logo
        
        // Set logo bounds (x, y, width, height)
        logo.setBounds(950, 10, 200, 200); // Position the logo at (700, 10) for top right corner
        add(logo); // Add the logo to the frame
       
        // Content panel
        JPanel contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.setOpaque(false);
       
        equipmentListPanel = createEquipmentListPanel();
        equipmentListPanel.setPreferredSize(new Dimension(600, 400)); // Reduced size from 800x500 to 600x400
        contentPanel.add(equipmentListPanel);
       
        add(contentPanel, BorderLayout.CENTER);
    }
 
    private JPanel createTopBar() {
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
       
        JLabel contactButton = new JLabel("Contact US");
        JLabel feedbackButton = new JLabel("Feedback");
        JLabel notificationButton = new JLabel("🔔");
       
        topBar.add(contactButton);
        topBar.add(feedbackButton);
        topBar.add(notificationButton);
       
        return topBar;
    }
 
    private JPanel createEquipmentListPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(220, 230, 240));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
 
        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout(0, 10));  // Added vertical gap
        headerPanel.setOpaque(false);
 
        // Add Equipment button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setOpaque(false);
        JButton addEquipmentBtn = new JButton("Add Equipment");
        addEquipmentBtn.setBackground(Color.WHITE);
        addEquipmentBtn.addActionListener(e -> showAddEquipmentDialog());
        buttonPanel.add(addEquipmentBtn);
 
        // Title Panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("Manage Equipments");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titlePanel.add(titleLabel, BorderLayout.WEST);
 
        // Add components to header
        headerPanel.add(buttonPanel, BorderLayout.NORTH);
        headerPanel.add(titlePanel, BorderLayout.CENTER);
 
        // Controls Panel
        JPanel controlsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlsPanel.setOpaque(false);
       
        JLabel showLabel = new JLabel("Show Entities");
        JComboBox<String> showEntities = new JComboBox<>(new String[]{"10", "20", "50", "100"});
        searchField = new JTextField(20);
        JButton searchButton = new JButton("🔍");
       
        controlsPanel.add(showLabel);
        controlsPanel.add(showEntities);
        controlsPanel.add(Box.createHorizontalStrut(20));
        controlsPanel.add(searchField);
        controlsPanel.add(searchButton);
 
        // Table
        String[] columns = {"Equipment Name", "Total no.", "Status", "Actions"};
        Object[][] data = {
            {"Treadmill", "10", "Active", "Edit"},
            {"10 lbs Dumbell", "20", "Active", "Edit"},
            {"15 lbs barbell", "15", "Active", "Edit"},
            {"25 lbs Dumbell", "15", "Active", "Edit"}
        };
 
        equipmentTable = new JTable(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Only Actions column is editable
            }
        };
 
        // Table styling
        equipmentTable.setRowHeight(35);
        equipmentTable.setBackground(new Color(220, 230, 240));  // Match panel background
        equipmentTable.setShowGrid(false);  // Remove grid lines
        equipmentTable.setIntercellSpacing(new Dimension(0, 0));  // Remove spacing between cells
       
        // Style the header
        JTableHeader header = equipmentTable.getTableHeader();
        header.setBackground(new Color(220, 230, 240));  // Match panel background
        header.setBorder(BorderFactory.createEmptyBorder());  // Remove header border
       
        // Create a scrollPane without borders
        JScrollPane scrollPane = new JScrollPane(equipmentTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(new Color(220, 230, 240));
        scrollPane.getViewport().setBackground(new Color(220, 230, 240));
 
        // Pagination panel
        JPanel paginationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        paginationPanel.setOpaque(false);
       
        JButton previousButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
       
        paginationPanel.add(previousButton);
        paginationPanel.add(nextButton);
 
        // Add components to main panel
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(paginationPanel, BorderLayout.SOUTH);
 
        return panel;
    }
 
    private void showAddEquipmentDialog() {
        JDialog dialog = new JDialog(this, "Add Equipment", true);
        dialog.setLayout(new BorderLayout());
        dialog.add(createAddEquipmentPanel());
        dialog.pack();
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
 
    private JPanel createAddEquipmentPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(230, 230, 250));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
 
        // Title
        JLabel titleLabel = new JLabel("Add Equipment");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel, BorderLayout.NORTH);
 
        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
 
        // Attach photo
        JPanel photoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        photoPanel.setOpaque(false);
        JLabel photoLabel = new JLabel("Attach Photo");
        JButton attachButton = new JButton("📎");
        photoPanel.add(photoLabel);
        photoPanel.add(attachButton);
 
        // Equipment name
        JLabel nameLabel = new JLabel("Equipment Name");
        JTextField nameField = new JTextField(20);
 
        // Status and Total No panel
        JPanel statusTotalPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        statusTotalPanel.setOpaque(false);
 
        // Status
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setOpaque(false);
        JLabel statusLabel = new JLabel("Status");
        JTextField statusField = new JTextField();
        statusPanel.add(statusLabel, BorderLayout.NORTH);
        statusPanel.add(statusField, BorderLayout.CENTER);
 
        // Total No
        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.setOpaque(false);
        JLabel totalLabel = new JLabel("Total No.");
        JTextField totalField = new JTextField();
        totalPanel.add(totalLabel, BorderLayout.NORTH);
        totalPanel.add(totalField, BorderLayout.CENTER);
 
        statusTotalPanel.add(statusPanel);
        statusTotalPanel.add(totalPanel);
 
        // Buttons panel in Add Equipment dialog
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 5));
       
        JButton cancelButton = new JButton("Cancel");
        JButton saveButton = new JButton("Save Changes");
        saveButton.setBackground(new Color(255, 215, 0));
        cancelButton.setPreferredSize(new Dimension(100, 30));
        saveButton.setPreferredSize(new Dimension(120, 30));
       
        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);
 
        // Add components to form
        gbc.gridy = 0;
        formPanel.add(photoPanel, gbc);
        gbc.gridy = 1;
        formPanel.add(nameLabel, gbc);
        gbc.gridy = 2;
        formPanel.add(nameField, gbc);
        gbc.gridy = 3;
        formPanel.add(statusTotalPanel, gbc);
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.SOUTHEAST; // Align to bottom right
        gbc.weighty = 1.0; // Push buttons to bottom
        formPanel.add(buttonPanel, gbc);
 
        panel.add(formPanel, BorderLayout.CENTER);
 
        return panel;
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new GymEquipmentManagement().setVisible(true);
        });
    }
}
 
 
