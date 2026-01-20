import javax.swing.*;
import java.awt.*;

public class GymPOSUI extends JFrame {
    public GymPOSUI() {
        setTitle("Gym Management System - POS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Header Panel
        JPanel headerPanel = new JPanel(null);
        headerPanel.setBounds(0, 0, 800, 60);
        headerPanel.setBackground(Color.WHITE);

        JLabel contactLabel = new JLabel("Contact US");
        contactLabel.setFont(new Font("Arial", Font.BOLD, 14));
        contactLabel.setBounds(300, 15, 100, 30);

        JLabel feedbackLabel = new JLabel("Feedback");
        feedbackLabel.setFont(new Font("Arial", Font.BOLD, 14));
        feedbackLabel.setBounds(410, 15, 100, 30);

        JLabel notificationIcon = new JLabel("🔔");
        notificationIcon.setFont(new Font("Arial", Font.PLAIN, 18));
        notificationIcon.setBounds(750, 15, 30, 30);

        // Gym Logo
        ImageIcon logoIcon = new ImageIcon("logo.png"); // Replace with actual path
        Image img = logoIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(img));
        logoLabel.setBounds(650, 5, 80, 50);

        headerPanel.add(contactLabel);
        headerPanel.add(feedbackLabel);
        headerPanel.add(notificationIcon);
        headerPanel.add(logoLabel);

        // Point of Sale Title
        JLabel titleLabel = new JLabel("Point of Sale");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(184, 134, 11)); // Gold color
        titleLabel.setBounds(30, 80, 200, 30);

        JLabel subTitleLabel = new JLabel("Add Payment");
        subTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        subTitleLabel.setForeground(new Color(0, 102, 255)); // Blue color
        subTitleLabel.setBounds(30, 120, 200, 25);

        // Form Panel (Rounded Box)
        JPanel formPanel = new JPanel(null);
        formPanel.setBounds(30, 160, 400, 180);
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));

        // Form Fields
        JLabel nameLabel = new JLabel("Name of");
        nameLabel.setBounds(20, 20, 80, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(100, 20, 200, 25);
        nameField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel planLabel = new JLabel("Plan");
        planLabel.setBounds(20, 55, 80, 25);
        JTextField planField = new JTextField();
        planField.setBounds(100, 55, 90, 25);
        planField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setBounds(200, 55, 80, 25);
        JTextField priceField = new JTextField();
        priceField.setBounds(250, 55, 90, 25);
        priceField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        JLabel dateLabel = new JLabel("Date of Join");
        dateLabel.setBounds(20, 90, 80, 25);
        JTextField dateField = new JTextField();
        dateField.setBounds(100, 90, 150, 25);
        dateField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        // Buttons
        JButton saveButton = new JButton("Save");
        saveButton.setBounds(100, 130, 80, 30);
        saveButton.setBackground(new Color(255, 215, 0)); // Yellow
        saveButton.setForeground(Color.BLACK);
        saveButton.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 130, 80, 30);
        cancelButton.setBackground(Color.WHITE);
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Add components to form panel
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(planLabel);
        formPanel.add(planField);
        formPanel.add(priceLabel);
        formPanel.add(priceField);
        formPanel.add(dateLabel);
        formPanel.add(dateField);
        formPanel.add(saveButton);
        formPanel.add(cancelButton);

        // Add components to frame
        add(headerPanel);
        add(titleLabel);
        add(subTitleLabel);
        add(formPanel);

        setSize(800, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GymPOSUI().setVisible(true));
    }
}
