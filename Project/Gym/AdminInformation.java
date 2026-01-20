import javax.swing.*;
import java.awt.*;

public class AdminInformation extends JFrame {
    private JTextField usernameField, contactField, emailField;
    private JPasswordField currentPasswordField, newPasswordField, retypePasswordField;
    
    public AdminInformation() {
        setTitle("Gym Fitness Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);

         // Gym Fitness Logo
         JLabel logo = new JLabel(); // Create a JLabel for the logo

         // Load and resize the logo
         java.net.URL imgURL = getClass().getResource("/logo.png"); // Ensure the logo.png is in the resources folder
         if (imgURL != null) {
             ImageIcon logoIcon = new ImageIcon(imgURL);
             Image img = logoIcon.getImage().getScaledInstance(130, 150, Image.SCALE_SMOOTH); // Resize to 130x150
             logo.setIcon(new ImageIcon(img)); // Set the resized logo
         } else {
             logo.setText("Logo not found");
             logo.setHorizontalAlignment(SwingConstants.CENTER);
             logo.setPreferredSize(new Dimension(130, 150));
             System.err.println("Couldn't find file: logo.png");
         }
         // Set logo bounds (x, y, width, height)
         logo.setBounds(750, 25, 130, 150); // Position the logo at (750, 25)
        
        // Create the header
        createHeader();
        
        // Admin Information Panel
        JPanel adminPanel = new JPanel(null);
        adminPanel.setBounds(20, 60, 250, 250);
        adminPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        JLabel adminInfoLabel = new JLabel("Admin Information");
        adminInfoLabel.setForeground(new Color(33, 150, 243));
        adminInfoLabel.setBounds(10, 10, 200, 25);
        adminInfoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Profile Icon
        JLabel profileIcon = new JLabel("👤");
        profileIcon.setBounds(100, 40, 50, 50);
        profileIcon.setFont(new Font("Arial", Font.PLAIN, 40));
        
        JButton updateProfileBtn = new JButton("✎ Update Profile");
        updateProfileBtn.setBounds(60, 100, 130, 25);
        
        JLabel usernameLabel = new JLabel("Username: Mahesh");
        usernameLabel.setBounds(10, 135, 200, 25);
        
        JLabel contactLabel = new JLabel("Contact no. 9812345678");
        contactLabel.setBounds(10, 160, 200, 25);
        
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 185, 200, 25);
        
        JLabel emailValueLabel = new JLabel("example@gmail.com");
        emailValueLabel.setBounds(10, 210, 200, 25);
        
        adminPanel.add(adminInfoLabel);
        adminPanel.add(profileIcon);
        adminPanel.add(updateProfileBtn);
        adminPanel.add(usernameLabel);
        adminPanel.add(contactLabel);
        adminPanel.add(emailLabel);
        adminPanel.add(emailValueLabel);
        
        // Register New Admin Button
        JButton registerAdminBtn = new JButton("Register New Admin Account");
        registerAdminBtn.setBounds(20, 320, 250, 30);
        registerAdminBtn.setBackground(new Color(48, 63, 159));
        registerAdminBtn.setForeground(Color.BLACK);
        registerAdminBtn.setFocusPainted(false);
        
        // Update Profile Panel
        JPanel updatePanel = new JPanel(null);
        updatePanel.setBounds(300, 200, 250, 200);
        updatePanel.setBackground(new Color(209, 229, 241));
        updatePanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        JLabel updateUsernameLabel = new JLabel("Username");
        updateUsernameLabel.setBounds(10, 20, 100, 25);
        usernameField = new JTextField();
        usernameField.setBounds(10, 45, 230, 25);
        
        JLabel updateContactLabel = new JLabel("Contact No.");
        updateContactLabel.setBounds(10, 70, 100, 25);
        contactField = new JTextField();
        contactField.setBounds(10, 95, 230, 25);
        
        JLabel updateEmailLabel = new JLabel("Email Address");
        updateEmailLabel.setBounds(10, 120, 100, 25);
        emailField = new JTextField();
        emailField.setBounds(10, 145, 230, 25);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBounds(10, 170, 230, 30);
        buttonPanel.setOpaque(false);
        
        JButton saveBtn = new JButton("Save");
        JButton cancelBtn = new JButton("Cancel");
        
        buttonPanel.add(saveBtn);
        buttonPanel.add(cancelBtn);
        
        updatePanel.add(updateUsernameLabel);
        updatePanel.add(usernameField);
        updatePanel.add(updateContactLabel);
        updatePanel.add(contactField);
        updatePanel.add(updateEmailLabel);
        updatePanel.add(emailField);
        updatePanel.add(buttonPanel);
        
        // Password Change Panel
        JPanel passwordPanel = new JPanel(null);
        passwordPanel.setBounds(580, 300, 250, 200);
        passwordPanel.setBackground(new Color(226, 175, 104));
        passwordPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        
        JLabel currentPasswordLabel = new JLabel("Current password");
        currentPasswordLabel.setBounds(10, 20, 200, 25);
        currentPasswordField = new JPasswordField();
        currentPasswordField.setBounds(10, 45, 230, 25);
        
        JLabel newPasswordLabel = new JLabel("New password");
        newPasswordLabel.setBounds(10, 70, 200, 25);
        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(10, 95, 230, 25);
        
        JLabel retypePasswordLabel = new JLabel("Re-type password");
        retypePasswordLabel.setBounds(10, 120, 200, 25);
        retypePasswordField = new JPasswordField();
        retypePasswordField.setBounds(10, 145, 230, 25);
        
        JPanel passwordButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        passwordButtonPanel.setBounds(10, 170, 230, 30);
        passwordButtonPanel.setOpaque(false);
        
        JButton changeBtn = new JButton("Change");
        JButton clearBtn = new JButton("Clear");
        
        passwordButtonPanel.add(changeBtn);
        passwordButtonPanel.add(clearBtn);
        
        passwordPanel.add(currentPasswordLabel);
        passwordPanel.add(currentPasswordField);
        passwordPanel.add(newPasswordLabel);
        passwordPanel.add(newPasswordField);
        passwordPanel.add(retypePasswordLabel);
        passwordPanel.add(retypePasswordField);
        // Gym Fitness Logo
        // Logo already loaded and resized above
        // Set logo bounds (x, y, width, height)
        logo.setBounds(750, 25, 200, 200); // Position the logo at (700, 10) for top right corner
        
        // Add all components to frame
        add(adminPanel);
        add(registerAdminBtn);
        add(updatePanel);
        add(passwordPanel);
        add(logo); // Add the logo to the frame
        
        setLocationRelativeTo(null);
    }
    
    private void createHeader() {
        JPanel header = new JPanel(null);
        header.setBounds(0, 0, 900, 60);
        header.setBackground(Color.WHITE);
        
        JLabel contactBtn = new JLabel("Contact US");
        contactBtn.setBounds(350, 15, 100, 30);
        contactBtn.setBackground(Color.WHITE);
       
        JLabel feedbackBtn = new JLabel("Feedback");
        feedbackBtn.setBounds(460, 15, 100, 30);
        feedbackBtn.setBackground(Color.WHITE);
       
        JLabel notificationIcon = new JLabel("🔔");
        notificationIcon.setBounds(570, 15, 30, 30);
       
        header.add(contactBtn);
        header.add(feedbackBtn);
        header.add(notificationIcon);
        add(header);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new AdminInformation().setVisible(true);
        });
    }
}
