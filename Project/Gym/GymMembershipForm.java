
import javax.swing.*;
import java.awt.*;
 
public class GymMembershipForm {
    private JFrame frame;
    private JTextField nameField, dateField, emailField, contactField, planField, priceField;
    private JButton membershipButton, cancelButton;
 
    public GymMembershipForm() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            createAndShowGUI();
        });
    }
 
    private void createAndShowGUI() {
        // Initialize frame
        frame = new JFrame("Gym Membership Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
 
        // Initialize all components
        initializeComponents();
 
        // Create and set up the main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 
        // Add components to main panel
        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        mainPanel.add(createCenterPanel(), BorderLayout.CENTER);
        mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);
 
        // Add main panel to frame and show
        frame.add(mainPanel);
        frame.setVisible(true);
    }
 
    private void initializeComponents() {
        // Initialize text fields with rounded corners
        nameField = createRoundedTextField();
        dateField = createRoundedTextField();
        emailField = createRoundedTextField();
        contactField = createRoundedTextField();
        planField = createRoundedTextField();
        priceField = createRoundedTextField();
 
        // Initialize buttons
        membershipButton = new JButton("Membership") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
                g2.dispose();
            }
        };
        membershipButton.setBackground(new Color(255, 192, 203));  // Light pink/red color
        membershipButton.setForeground(Color.BLACK);
        membershipButton.setFont(new Font("Arial", Font.BOLD, 14));
        membershipButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        membershipButton.setFocusPainted(false);
        membershipButton.setBorderPainted(false);
        membershipButton.setContentAreaFilled(false);
        membershipButton.setOpaque(false);
        membershipButton.addActionListener(e -> handleMembershipSubmit());
 
        cancelButton = new JButton("Cancel") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
                g2.dispose();
            }
        };
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setOpaque(false);
        cancelButton.setBackground(Color.WHITE);  // White background for cancel button
        cancelButton.addActionListener(e -> handleCancel());
    }
 
    private JTextField createRoundedTextField() {
        JTextField field = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                if (!isOpaque()) {
                    Graphics2D g2 = (Graphics2D) g.create();
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.setColor(getBackground());
                    g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                    g2.dispose();
                }
                super.paintComponent(g);
            }
        };
        field.setOpaque(false);
        field.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return field;
    }
 
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout(20, 0));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
 
        JLabel headerLabel = new JLabel("<html>YOUR <font color='red'>FITNESS</font> JOURNEY<br>STARTS HERE!</html>");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        
       
        // Create a center panel for the contact label
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel contactLabel = new JLabel("Contact US                        Feedback 🔔");
        contactLabel.setFont(new Font("Arial", Font.BOLD, 14));
        contactLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        centerPanel.add(contactLabel);
 
        headerPanel.add(headerLabel, BorderLayout.WEST);
        headerPanel.add(centerPanel, BorderLayout.CENTER);
 
        return headerPanel;
    }
 
    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(createFormPanel());
        return centerPanel;
    }
 
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(null);
        formPanel.setPreferredSize(new Dimension(800, 400));
        formPanel.setBackground(new Color(200, 230, 255));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 
        // Add form fields
        addFormField(formPanel, "Name of Member", 20, 20, nameField, "👤");
        addFormField(formPanel, "Date of Membership", 470, 20, dateField, "📅");
        addFormField(formPanel, "Email Address", 20, 100, emailField, "✉");
        addFormField(formPanel, "Contact No:", 470, 100, contactField, "📞");
        addFormField(formPanel, "Plan", 20, 180, planField, null);
        addFormField(formPanel, "Price", 470, 180, priceField, "💰");
 
        return formPanel;
    }
 
    private void addFormField(JPanel panel, String labelText, int x, int y, JTextField field, String iconText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(x, y, 200, 30);
        panel.add(label);
 
        field.setBounds(x, y + 30, 250, 30);
        panel.add(field);
 
        if (iconText != null) {
            JLabel icon = new JLabel(iconText);
            icon.setBounds(x + 230, y + 30, 30, 30);
            panel.add(icon);
        }
    }
 
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.add(membershipButton);
        buttonPanel.add(cancelButton);
        return buttonPanel;
    }
 
    private void handleMembershipSubmit() {
        if (validateFields()) {
            JOptionPane.showMessageDialog(frame,
                "Membership form submitted successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
    }
 
    private void handleCancel() {
        int result = JOptionPane.showConfirmDialog(frame,
            "Are you sure you want to cancel?",
            "Confirm Cancel",
            JOptionPane.YES_NO_OPTION);
           
        if (result == JOptionPane.YES_OPTION) {
            clearFields();
        }
    }
 
    private boolean validateFields() {
        if (nameField.getText().trim().isEmpty() ||
            dateField.getText().trim().isEmpty() ||
            emailField.getText().trim().isEmpty() ||
            contactField.getText().trim().isEmpty() ||
            planField.getText().trim().isEmpty() ||
            priceField.getText().trim().isEmpty()) {
           
            JOptionPane.showMessageDialog(frame,
                "Please fill in all fields",
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
 
    private void clearFields() {
        nameField.setText("");
        dateField.setText("");
        emailField.setText("");
        contactField.setText("");
        planField.setText("");
        priceField.setText("");
    }
 
    public static void main(String[] args) {
        new GymMembershipForm();
    }
}
 
 
