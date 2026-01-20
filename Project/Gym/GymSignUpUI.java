import javax.swing.*;
import java.awt.*;
 
public class GymSignUpUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GymSignUpUI::createAndShowGUI);
    }
 
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Gym Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
 
        // Main Panel with Gradient Background
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(245, 245, 255), 0, getHeight(), new Color(204, 204, 255));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);
       
 
        // Sign Up Label
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setFont(new Font("Arial", Font.BOLD, 24));
        signUpLabel.setBounds(50, 20, 200, 40);
        mainPanel.add(signUpLabel);
 
        // Add Logo
        ImageIcon logoIcon = new ImageIcon("C:logo.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Scale the image
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setBounds(700, 50, 200, 200); // Set bounds for the logo
        mainPanel.add(logoLabel);
       
 
        // Form Labels and Fields
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(50, 80, 100, 30);
        JTextField firstNameField = new RoundedTextField();
        firstNameField.setBounds(50, 110, 200, 30);
 
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(400, 80, 100, 30);
        JTextField lastNameField = new RoundedTextField();
        lastNameField.setBounds(400, 110, 200, 30);
 
        JLabel contactNoLabel = new JLabel("Contact No.:");
        contactNoLabel.setBounds(50, 160, 100, 30);
        JTextField contactNoField = new RoundedTextField();
        contactNoField.setBounds(50, 190, 200, 30);
 
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(400, 160, 100, 30);
        JComboBox<String> dayDropdown = new JComboBox<>(generateNumbers(1, 31));
        JComboBox<String> monthDropdown = new JComboBox<>(generateNumbers(1, 12));
        JComboBox<String> yearDropdown = new JComboBox<>(generateNumbers(1900, 2023));
        dayDropdown.setBounds(400, 190, 60, 30);
        monthDropdown.setBounds(470, 190, 80, 30);
        yearDropdown.setBounds(560, 190, 80, 30);
 
        JLabel weightLabel = new JLabel("Body Weight:");
        weightLabel.setBounds(400, 240, 100, 30);
        JComboBox<String> weightDropdown = new JComboBox<>(generateNumbers(30, 200));
        weightDropdown.setBounds(400, 270, 100, 30);
 
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 310, 100, 30);
        JTextField addressField = new RoundedTextField();
        addressField.setBounds(50, 340, 200, 30);
 
        JLabel emailLabel = new JLabel("EMAIL:");
        emailLabel.setBounds(50, 390, 100, 30);
        JTextField emailField = new RoundedTextField();
        emailField.setBounds(50, 420, 200, 30);
 
        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(50, 470, 100, 30);
        JPasswordField passwordField = new RoundedPasswordField();
        passwordField.setBounds(50, 500, 200, 30);
 
        JLabel confirmPasswordLabel = new JLabel("Confirm PASSWORD:");
        confirmPasswordLabel.setBounds(50, 550, 150, 30);
        JPasswordField confirmPasswordField = new RoundedPasswordField();
        confirmPasswordField.setBounds(50, 580, 200, 30);
 
        JCheckBox termsCheckbox = new JCheckBox("I agree with Terms & Conditions.");
        termsCheckbox.setBounds(50, 630, 300, 30);
        termsCheckbox.setBackground(new Color(245, 245, 255));
 
        JButton loginButton = new RoundedButton("Log In");
        loginButton.setBounds(400, 630, 200, 40);
        loginButton.setBackground(new Color(102, 255, 102));
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
 
        // Add components to main panel
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameField);
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastNameField);
        mainPanel.add(contactNoLabel);
        mainPanel.add(contactNoField);
        mainPanel.add(dobLabel);
        mainPanel.add(dayDropdown);
        mainPanel.add(monthDropdown);
        mainPanel.add(yearDropdown);
        mainPanel.add(weightLabel);
        mainPanel.add(weightDropdown);
        mainPanel.add(addressLabel);
        mainPanel.add(addressField);
        mainPanel.add(emailLabel);
        mainPanel.add(emailField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(confirmPasswordLabel);
        mainPanel.add(confirmPasswordField);
        mainPanel.add(termsCheckbox);
        mainPanel.add(loginButton);
 
        // Add main panel to frame
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 
    // Helper method to generate numbers as strings
    private static String[] generateNumbers(int start, int end) {
        String[] numbers = new String[end - start + 1];
        for (int i = start; i <= end; i++) {
            numbers[i - start] = String.valueOf(i);
        }
        return numbers;
    }
 
    // Custom Rounded TextField
    static class RoundedTextField extends JTextField {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            super.paintComponent(g);
        }
    }
 
    // Custom Rounded PasswordField
    static class RoundedPasswordField extends JPasswordField {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            super.paintComponent(g);
        }
    }
 
    // Custom Rounded Button
    static class RoundedButton extends JButton {
        public RoundedButton(String text) {
            super(text);
            setOpaque(false);
            setContentAreaFilled(false);
            setFocusPainted(false);
        }
 
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
            super.paintComponent(g);
        }
 
        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getForeground());
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
    }
}
 
 
 
