import java.awt.*;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
 
class CurvedImagePanel extends JPanel {
    private Image image;
 
    public CurvedImagePanel(String imagePath) {
        // Load and resize the image
        image = new ImageIcon(imagePath).getImage().getScaledInstance(500, 800, Image.SCALE_SMOOTH); // Resize image
        setBackground(Color.WHITE); // Set background to white
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Create a rounded rectangle clip
        g.setClip(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30)); // Set rounded corners
        g.drawImage(image, 0, 0, this); // Draw the image
    }
}
 
class CurvedButton extends JButton {
    public CurvedButton(String label) {
        super(label);
        setContentAreaFilled(false); // Make the button transparent
        setFocusPainted(false); // Remove focus border
        setBorderPainted(false); // Remove border
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        // Set the button color
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Draw rounded rectangle
        super.paintComponent(g); // Call the superclass method
    }
 
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 50); // Set preferred size for the button
    }
}
 
public class Login {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Gym Fitness Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridLayout(1, 2)); // Two columns: left for image, right for form
 
        // Left Panel: Curved Image Panel
        CurvedImagePanel leftPanel = new CurvedImagePanel("image.png"); // Replace with actual image path
        frame.add(leftPanel);
 
        // Right Panel: Login Form Panel
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null); // Use absolute layout
        rightPanel.setBackground(Color.WHITE); // Ensure the right panel is white
 
        // Gym Fitness Logo
        JLabel logo = new JLabel(); // Create a JLabel for the logo
       
        // Load and resize the logo
        ImageIcon logoIcon = new ImageIcon("C:logo.png"); // Update with your logo path
        Image img = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Resize to 200x200
        logo.setIcon(new ImageIcon(img)); // Set the resized logo
       
        // Set logo bounds (x, y, width, height)
        logo.setBounds(350, 30, 200, 200); // Position the logo at (350, 30) with size 200x200
        rightPanel.add(logo);
 
        // Member ID Label and Text Field
        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Increased font size
        memberIdLabel.setBounds(50, 250, 150, 30); // Set position and size for label
        rightPanel.add(memberIdLabel);
 
        JTextField memberIdField = new JTextField(20); // Increased width
        memberIdField.setFont(new Font("Arial", Font.PLAIN, 18)); // Increased font size
        memberIdField.setBounds(200, 250, 250, 30); // Set position and size for text field
        rightPanel.add(memberIdField);
 
        // Password Label and Password Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Increased font size
        passwordLabel.setBounds(50, 300, 150, 30); // Set position and size for label
        rightPanel.add(passwordLabel);
 
        JPasswordField passwordField = new JPasswordField(20); // Increased width
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18)); // Increased font size
        passwordField.setBounds(200, 300, 250, 30); // Set position and size for password field
        rightPanel.add(passwordField);
 
        // Sign In Button
        CurvedButton signInButton = new CurvedButton("SIGN IN");
        signInButton.setBackground(Color.decode("#93D98D")); // Set button color
        signInButton.setFont(new Font("Arial", Font.BOLD, 20)); // Increased font size
        signInButton.setBounds(50, 380, 400, 50); // Set position and size for button
        rightPanel.add(signInButton);
 
        // Sign Up Button
        CurvedButton signUpButton = new CurvedButton("SIGN UP");
        signUpButton.setBackground(Color.decode("#BEB8E0")); // Set button color
        signUpButton.setFont(new Font("Arial", Font.BOLD, 20)); // Increased font size
        signUpButton.setBounds(50, 460, 400, 50); // Set position and size for button
        rightPanel.add(signUpButton);
 
        // Forget Password Label
        JLabel forgetPassword = new JLabel("Forget password?", JLabel.RIGHT);
        forgetPassword.setFont(new Font("Arial", Font.PLAIN, 18)); // Increased font size
        forgetPassword.setForeground(Color.BLUE);
        forgetPassword.setBounds(300, 430, 200, 30); // Set position and size for forget password label
        rightPanel.add(forgetPassword);
 
        // Add right panel to the frame
        frame.add(rightPanel);
 
        // Set frame visibility
        frame.setVisible(true);
    }
}
 
