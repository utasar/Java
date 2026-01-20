import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class Premium extends JFrame {
    private JTable premiumTable, standardTable;
    private JComboBox<String> premiumEntriesBox, standardEntriesBox;
    private JTextField planNameField, validityField, amountField;

    public Premium() {
        setTitle("Gym Fitness Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);

        // Gym Fitness Logo
        JLabel logo = new JLabel(); // Create a JLabel for the logo
        
        // Load and resize the logo
        ImageIcon logoIcon = new ImageIcon("C:logo.png"); // Update with your logo path
        Image img = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Resize to 200x200
        logo.setIcon(new ImageIcon(img)); // Set the resized logo
        
        // Set logo bounds (x, y, width, height)
        logo.setBounds(700, 10, 200, 200); // Position the logo at (700, 10) for top right corner
        add(logo); // Add the logo to the frame

        // Top Panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        topPanel.setBounds(0, 0, 900, 40);
        topPanel.setBackground(Color.WHITE);

        JLabel contactUsBtn = new JLabel("Contact US");
        JLabel feedbackBtn = new JLabel("Feedback");
        JLabel notificationBtn = new JLabel("🔔");
        
        topPanel.add(contactUsBtn);
        topPanel.add(feedbackBtn);
        topPanel.add(notificationBtn);
        add(topPanel);

        // Premium Section
        JPanel premiumPanel = new JPanel(null);
        premiumPanel.setBounds(20, 50, 550, 200);
        premiumPanel.setBackground(new Color(217, 229, 237));
        
        JLabel premiumLabel = new JLabel("Premium");
        premiumLabel.setBounds(10, 10, 100, 25);
        premiumLabel.setForeground(new Color(255, 193, 7));
        premiumPanel.add(premiumLabel);

        // Premium Table Controls
        JPanel premiumControlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        premiumControlPanel.setBounds(10, 40, 530, 30);
        premiumControlPanel.setOpaque(false);

        JLabel showEntriesLabel1 = new JLabel("Show Entries");
        premiumEntriesBox = new JComboBox<>(new String[]{"10", "25", "50", "100"});
        JTextField searchPremiumField = new JTextField(15);
        JLabel searchLabel1 = new JLabel("Search:");
        
        premiumControlPanel.add(showEntriesLabel1);
        premiumControlPanel.add(premiumEntriesBox);
        premiumControlPanel.add(Box.createHorizontalStrut(150));
        premiumControlPanel.add(searchLabel1);
        premiumControlPanel.add(searchPremiumField);
        premiumPanel.add(premiumControlPanel);

        // Premium Table
        String[] columnNames = {"Plan Name", "Validity", "Amount", "Edit"};
        Object[][] premiumData = {
            {"1 month", "1", "4000", "Edit"},
            {"3 months", "3", "10000", "Edit"},
            {"6 months", "6", "20000", "Edit"},
            {"Annual", "12", "30000", "Edit"}
        };
        
        DefaultTableModel premiumModel = new DefaultTableModel(premiumData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };
        
        premiumTable = new JTable(premiumModel);
        JScrollPane premiumScrollPane = new JScrollPane(premiumTable);
        premiumScrollPane.setBounds(10, 80, 530, 100);
        premiumPanel.add(premiumScrollPane);
        
        // Customize the Edit column
        TableColumn editColumn = premiumTable.getColumnModel().getColumn(3);
        editColumn.setCellRenderer(new ButtonRenderer());
        editColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

        add(premiumPanel);

        // Standard Section
        JPanel standardPanel = new JPanel(null);
        standardPanel.setBounds(20, 270, 550, 200);
        standardPanel.setBackground(new Color(230, 230, 250));
        
        JLabel standardLabel = new JLabel("Standard");
        standardLabel.setBounds(10, 10, 100, 25);
        standardPanel.add(standardLabel);

        // Standard Table Controls
        JPanel standardControlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        standardControlPanel.setBounds(10, 40, 530, 30);
        standardControlPanel.setOpaque(false);

        JLabel showEntriesLabel2 = new JLabel("Show Entries");
        standardEntriesBox = new JComboBox<>(new String[]{"10", "25", "50", "100"});
        JTextField searchStandardField = new JTextField(15);
        JLabel searchLabel2 = new JLabel("Search:");
        
        standardControlPanel.add(showEntriesLabel2);
        standardControlPanel.add(standardEntriesBox);
        standardControlPanel.add(Box.createHorizontalStrut(150));
        standardControlPanel.add(searchLabel2);
        standardControlPanel.add(searchStandardField);
        standardPanel.add(standardControlPanel);

        // Standard Table
        Object[][] standardData = {
            {"1 month", "1", "2000", "Edit"},
            {"3 months", "3", "7000", "Edit"},
            {"6 months", "6", "10000", "Edit"},
            {"Annual", "12", "20000", "Edit"}
        };
        
        DefaultTableModel standardModel = new DefaultTableModel(standardData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };
        
        standardTable = new JTable(standardModel);
        JScrollPane standardScrollPane = new JScrollPane(standardTable);
        standardScrollPane.setBounds(10, 80, 530, 100);
        standardPanel.add(standardScrollPane);
        
        // Customize the Edit column for standard table
        TableColumn standardEditColumn = standardTable.getColumnModel().getColumn(3);
        standardEditColumn.setCellRenderer(new ButtonRenderer());
        standardEditColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

        add(standardPanel);

        // Add Plan Panel
        JPanel addPlanPanel = new JPanel(null);
        addPlanPanel.setBounds(590, 350, 280, 200);
        addPlanPanel.setBackground(new Color(255, 228, 196));
        addPlanPanel.setBorder(BorderFactory.createTitledBorder("Add Plan"));

        JLabel planNameLabel = new JLabel("Plan Name");
        planNameLabel.setBounds(20, 30, 100, 25);
        planNameField = new JTextField();
        planNameField.setBounds(20, 55, 240, 25);

        JLabel validityLabel = new JLabel("Validity");
        validityLabel.setBounds(20, 85, 100, 25);
        validityField = new JTextField();
        validityField.setBounds(20, 110, 240, 25);

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(20, 140, 100, 25);
        amountField = new JTextField();
        amountField.setBounds(20, 165, 240, 25);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(160, 200, 80, 25);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 200, 80, 25);

        addPlanPanel.add(planNameLabel);
        addPlanPanel.add(planNameField);
        addPlanPanel.add(validityLabel);
        addPlanPanel.add(validityField);
        addPlanPanel.add(amountLabel);
        addPlanPanel.add(amountField);
        addPlanPanel.add(saveButton);
        addPlanPanel.add(cancelButton);

        add(addPlanPanel);

        setLocationRelativeTo(null);
    }

    // Custom Button Renderer for Edit buttons
    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Edit");
            return this;
        }
    }

    // Custom Button Editor for Edit buttons
    static class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            label = "Edit";
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Handle edit button click
                JOptionPane.showMessageDialog(button, "Edit button clicked");
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Premium().setVisible(true);
        });
    }
}
