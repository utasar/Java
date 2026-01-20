import javax.swing.*;
import java.awt.*;
 
public class Introduction extends JFrame {
 
    public Introduction() {
        setTitle("Gym Fitness Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().setBackground(Color.WHITE);

        // Gym Fitness Logo
        JLabel logo = new JLabel(); // Create a JLabel for the logo

        // Load and resize the logo
        java.net.URL imgURL = getClass().getResource("/logo.png"); // Ensure the logo.png is in the resources folder
        if (imgURL != null) {
            ImageIcon logoIcon = new ImageIcon(imgURL);
            Image img = logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Resize to 200x200
            logo.setIcon(new ImageIcon(img)); // Set the resized logo
        } else {
            logo.setText("Logo not found");
            logo.setHorizontalAlignment(SwingConstants.CENTER);
            logo.setPreferredSize(new Dimension(200, 200));
            System.err.println("Couldn't find file: logo.png");
        }

        // Create a center panel and add the logo to it
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Change alignment to LEFT
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(logo);

        // Add the center panel to the frame
        add(centerPanel);
 
        // Add components
        add(createHeader());
        add(createHeroSection());
        add(createContentPanel());
    }
 
    private JPanel createHeader() {
        JPanel headerWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerWrapper.setBackground(Color.WHITE);
 
        JLabel contactLabel = new JLabel("Contact US");
        JLabel feedbackLabel = new JLabel("Feedback");
        JLabel notificationLabel = new JLabel("🔔");
        
        // Style the navigation items
        Font navFont = new Font("Arial", Font.BOLD, 14);
        contactLabel.setFont(navFont);
        feedbackLabel.setFont(navFont);
        notificationLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JPanel rightNav = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightNav.setBackground(Color.WHITE);
        rightNav.add(contactLabel);
        rightNav.add(feedbackLabel);
        rightNav.add(notificationLabel);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.add(rightNav, BorderLayout.EAST);

        headerWrapper.add(header);
        return headerWrapper;
    }
 
    private JPanel createHeroSection() {
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        wrapperPanel.setBackground(Color.WHITE);
 
        JPanel heroPanel = new JPanel();
        heroPanel.setLayout(new BoxLayout(heroPanel, BoxLayout.Y_AXIS));
        heroPanel.setBackground(Color.WHITE);
        heroPanel.setPreferredSize(new Dimension(800, 300));
 
        JLabel mainTitle = new JLabel("COME & CREATE YOUR");
        JLabel subTitle = new JLabel("OWN NEW BODY");
        JLabel slogan = new JLabel("FASTER, STRONGER FLIGHT TO THE END");
 
        mainTitle.setFont(new Font("Arial", Font.BOLD, 28));
        subTitle.setFont(new Font("Arial", Font.BOLD, 28));
        slogan.setFont(new Font("Arial", Font.PLAIN, 16));
 
        subTitle.setForeground(Color.RED);
 
        JButton moreDetails = new JButton("More Details");
        moreDetails.setBackground(new Color(220, 20, 20));
        moreDetails.setForeground(Color.WHITE);
        moreDetails.setPreferredSize(new Dimension(150, 40));
        moreDetails.setMaximumSize(new Dimension(150, 40));
        moreDetails.setFocusPainted(false);
 
        mainTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        subTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        slogan.setAlignmentX(Component.LEFT_ALIGNMENT);
        moreDetails.setAlignmentX(Component.LEFT_ALIGNMENT);
 
        heroPanel.add(Box.createVerticalStrut(50));
        heroPanel.add(mainTitle);
        heroPanel.add(Box.createVerticalStrut(10));
        heroPanel.add(subTitle);
        heroPanel.add(Box.createVerticalStrut(10));
        heroPanel.add(slogan);
        heroPanel.add(Box.createVerticalStrut(30));
        heroPanel.add(moreDetails);
 
        heroPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
 
        wrapperPanel.add(heroPanel);
        return wrapperPanel;
    }
 
    private JPanel createContentPanel() {
        JPanel wrapperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        wrapperPanel.setBackground(Color.WHITE);
 
        JPanel contentPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setPreferredSize(new Dimension(800, 400));
 
        contentPanel.add(createServicesPanel());
        contentPanel.add(createAboutPanel());
 
        wrapperPanel.add(contentPanel);
        return wrapperPanel;
    }
 
    private JPanel createServicesPanel() {
        JPanel servicesPanel = new JPanel();
        servicesPanel.setLayout(new BoxLayout(servicesPanel, BoxLayout.Y_AXIS));
        servicesPanel.setBackground(Color.WHITE);
 
        JLabel offerLabel = new JLabel("What we offer:");
        offerLabel.setOpaque(true);
        offerLabel.setBackground(new Color(233, 203, 169));
        offerLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelPanel.setBackground(Color.WHITE);
        labelPanel.add(offerLabel);
 
        // Use GridLayout to align service boxes in one row
        JPanel boxesPanel = new JPanel(new GridLayout(1, 3, 20, 0)); // 1 row, 3 columns, 20px spacing
        boxesPanel.setBackground(Color.WHITE);
        boxesPanel.setPreferredSize(new Dimension(650, 150)); // Ensure consistent size
 
        boxesPanel.add(createServiceBox("24/7", "Service"));
        boxesPanel.add(createServiceBox("1 on 1", "Coaching"));
        boxesPanel.add(createServiceBox("Professional Nutrient", "Guide"));
 
        JButton membershipButton = new JButton("GET MEMBERSHIP ▼");
        membershipButton.setBackground(new Color(233, 203, 169));
        membershipButton.setBorderPainted(false);
        membershipButton.setFocusPainted(false);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(membershipButton);
 
        servicesPanel.add(labelPanel);
        servicesPanel.add(Box.createVerticalStrut(10)); // Add spacing
        servicesPanel.add(boxesPanel);
        servicesPanel.add(Box.createVerticalStrut(10)); // Add spacing
        servicesPanel.add(buttonPanel);
 
        return servicesPanel;
    }
 
    private JPanel createServiceBox(String title, String subtitle) {
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        box.setBackground(Color.WHITE);
 
        // Set a fixed size for uniformity
        Dimension boxSize = new Dimension(200, 150); // Ensure all boxes are same size
        box.setPreferredSize(boxSize);
        box.setMinimumSize(boxSize);
        box.setMaximumSize(boxSize);
 
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        box.add(Box.createVerticalGlue());
        box.add(titleLabel);
        box.add(subtitleLabel);
        box.add(Box.createVerticalGlue());
 
        return box;
    }
 
    private JPanel createAboutPanel() {
        JPanel aboutPanel = new JPanel();
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
        aboutPanel.setBackground(new Color(233, 203, 169));
        aboutPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 
        JLabel aboutTitle = new JLabel("About");
        aboutTitle.setFont(new Font("Arial", Font.BOLD, 18));
 
        JTextArea description = new JTextArea(
                "Gym Fitness is one of the most iconic fitness brands globally and is often " +
                        "referred to as the \"Mecca of Bodybuilding.\" Its history spans decades, rooted " +
                        "in the rise of bodybuilding culture and the evolution of modern fitness trends."
        );
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setOpaque(false);
        description.setEditable(false);
        description.setFocusable(false);
 
        JLabel founder = new JLabel("Founded: Mahesh Maharjan");
        JLabel year = new JLabel("Year: 2015");
        JLabel location = new JLabel("Location: Kathmandu");
 
        aboutPanel.add(aboutTitle);
        aboutPanel.add(Box.createVerticalStrut(10));
        aboutPanel.add(description);
        aboutPanel.add(Box.createVerticalStrut(20));
        aboutPanel.add(founder);
        aboutPanel.add(Box.createVerticalStrut(5));
        aboutPanel.add(year);
        aboutPanel.add(Box.createVerticalStrut(5));
        aboutPanel.add(location);
 
        return aboutPanel;
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Introduction frame = new Introduction();
            frame.setVisible(true);
        });
    }
}
 
 
