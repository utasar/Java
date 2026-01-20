import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
 
public class ActiveMember extends JFrame {
    private JTable membersTable;
    private JTable coachesTable;
   
    public ActiveMember() {
        setTitle("GYM FITNESS CENTER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // Use absolute positioning
       
        // Top bar
        JPanel topBar = createTopBar();
        topBar.setBounds(0, 0, 1200, 100);
        add(topBar);
       
        // Left panel - Active Members
        JPanel membersPanel = createMembersPanel();
        membersPanel.setBounds(20, 120, 550, 400);
        add(membersPanel);
       
        // Right bottom panel - Active Coaches
        JPanel coachesPanel = createCoachesPanel();
        coachesPanel.setBounds(600, 300, 550, 400);  // Positioned at right bottom
        add(coachesPanel);
       
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
    }
   
    private JPanel createTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
       
        // Right buttons
        JPanel rightButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton contactButton = new JButton("Contact US");
        JButton feedbackButton = new JButton("Feedback");
        JButton notificationButton = new JButton("🔔");
       
        // Style buttons
        for (JButton button : new JButton[]{contactButton, feedbackButton, notificationButton}) {
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setFont(new Font("Arial", Font.PLAIN, 14));
        }
       
        rightButtons.add(contactButton);
        rightButtons.add(feedbackButton);
        rightButtons.add(notificationButton);
       
        topBar.add(rightButtons, BorderLayout.EAST);
       
        // Add Active Members title
        JLabel titleLabel = new JLabel("Active Members");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.RED);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(40, 20, 0, 0));
        topBar.add(titleLabel, BorderLayout.WEST);
       
        return topBar;
    }
   
    private JPanel createMembersPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(217, 231, 241));
       
        // Header section
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(217, 231, 241));
       
        JLabel titleLabel = new JLabel("Gym Members");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
       
        // Controls in header
        JPanel controlsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        controlsPanel.setBackground(new Color(217, 231, 241));
       
        JLabel showLabel = new JLabel("Show Entities");
        JComboBox<String> showEntities = new JComboBox<>(new String[]{"10"});
        showEntities.setPreferredSize(new Dimension(60, 25));
       
        JTextField searchField = new JTextField(15);
        searchField.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 5));
       
        controlsPanel.add(showLabel);
        controlsPanel.add(showEntities);
        controlsPanel.add(Box.createHorizontalStrut(20));
        controlsPanel.add(searchField);
       
        headerPanel.add(titleLabel, BorderLayout.NORTH);
        headerPanel.add(controlsPanel, BorderLayout.CENTER);
        panel.add(headerPanel, BorderLayout.NORTH);
 
        // Table with background color
        String[] columns = {"Name ↓", "Member ID", "Date Enrolled", "Date Expiration", "Actions"};
        Object[][] data = {
            {"Member 1", "SFM2301N1", "Jan 11", "Feb 11", "Edit"},
            {"Member 2", "SFM2301N2", "Mar 11", "Apl 11", "Edit"},
            {"Member 3", "SFM2301N3", "Oct 14", "Nov 14", "Edit"},
            {"Member 4", "SFM2301N4", "Dec 24", "Jan 24", "Edit"}
        };
       
        membersTable = new JTable(data, columns) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                c.setBackground(new Color(217, 231, 241));
                return c;
            }
        };
        membersTable.setRowHeight(35);
        membersTable.setShowGrid(false);
        membersTable.setOpaque(true);
        membersTable.setFillsViewportHeight(true);
        membersTable.setBackground(new Color(217, 231, 241));
        membersTable.getTableHeader().setBackground(new Color(217, 231, 241));
        membersTable.getTableHeader().setPreferredSize(new Dimension(100, 30));
       
        JScrollPane scrollPane = new JScrollPane(membersTable);
        scrollPane.setBackground(new Color(217, 231, 241));
        scrollPane.getViewport().setBackground(new Color(217, 231, 241));
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);
       
        // Pagination panel with same background
        JPanel paginationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        paginationPanel.setBackground(new Color(217, 231, 241));
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        paginationPanel.add(prevButton);
        paginationPanel.add(nextButton);
        panel.add(paginationPanel, BorderLayout.SOUTH);
       
        return panel;
    }
   
    private JPanel createCoachesPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(new Color(255, 233, 201));
       
        // Header with title and add coach button
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(255, 233, 201));
       
        // Title and Add Coach button in one row
        JPanel titleRow = new JPanel(new BorderLayout());
        titleRow.setBackground(new Color(255, 233, 201));
       
        JLabel titleLabel = new JLabel("Active Coaches");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(218, 165, 32));
       
        JButton addCoachButton = new JButton("Add coach");
        addCoachButton.setFont(new Font("Arial", Font.PLAIN, 14));
        addCoachButton.setForeground(new Color(64, 159, 255));
        addCoachButton.setBorderPainted(false);
        addCoachButton.setContentAreaFilled(false);
       
        titleRow.add(titleLabel, BorderLayout.WEST);
        titleRow.add(addCoachButton, BorderLayout.EAST);
       
        // Controls below title
        JPanel controlsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        controlsPanel.setBackground(new Color(255, 233, 201));
       
        JLabel manageLabel = new JLabel("Manage coach");
        JComboBox<String> showEntities = new JComboBox<>(new String[]{"10"});
        showEntities.setPreferredSize(new Dimension(60, 25));
       
        JTextField searchField = new JTextField(15);
        searchField.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 5));
       
        controlsPanel.add(manageLabel);
        controlsPanel.add(showEntities);
        controlsPanel.add(Box.createHorizontalStrut(20));
        controlsPanel.add(searchField);
       
        headerPanel.add(titleRow, BorderLayout.NORTH);
        headerPanel.add(controlsPanel, BorderLayout.CENTER);
        panel.add(headerPanel, BorderLayout.NORTH);
       
        // Table with background color
        String[] columns = {"Name ↓", "Coach ID", "Date Enrolled", "Date Expiration", "Actions"};
        Object[][] data = {
            {"Rajiv 1", "CFM2301N1", "Jan 11", "Feb 11", "Edit"},
            {"Lana 2", "CFM2301N2", "Mar 11", "Apl 11", "Edit"},
            {"Selena 3", "CFM2301N3", "Oct 14", "Nov 14", "Edit"},
            {"Zyan 4", "CFM2301N4", "Dec 24", "Jan 24", "Edit"}
        };
       
        coachesTable = new JTable(data, columns) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                c.setBackground(new Color(255, 233, 201));
                return c;
            }
        };
        coachesTable.setRowHeight(35);
        coachesTable.setShowGrid(false);
        coachesTable.setOpaque(true);
        coachesTable.setFillsViewportHeight(true);
        coachesTable.setBackground(new Color(255, 233, 201));
        coachesTable.getTableHeader().setBackground(new Color(255, 233, 201));
        coachesTable.getTableHeader().setPreferredSize(new Dimension(100, 30));
       
        JScrollPane scrollPane = new JScrollPane(coachesTable);
        scrollPane.setBackground(new Color(255, 233, 201));
        scrollPane.getViewport().setBackground(new Color(255, 233, 201));
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);
       
        // Pagination panel with same background
        JPanel paginationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        paginationPanel.setBackground(new Color(255, 233, 201));
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        paginationPanel.add(prevButton);
        paginationPanel.add(nextButton);
        panel.add(paginationPanel, BorderLayout.SOUTH);
       
        return panel;
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new ActiveMember().setVisible(true);
        });
    }
}
