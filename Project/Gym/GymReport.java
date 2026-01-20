import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class GymReport extends JFrame {
    public GymReport() {
        setTitle("GYM Fitness Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        // Main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        // Create header panel for logo and top bar
        JPanel headerPanel = new JPanel(new BorderLayout(10, 10));
        headerPanel.setBackground(Color.WHITE);

        // Gym Fitness Logo
        JLabel logo = new JLabel();
        logo.setOpaque(true);
        logo.setBackground(Color.WHITE);

        // Load and resize the logo
        java.net.URL imgURL = getClass().getResource("/logo.png");
        if (imgURL != null) {
            ImageIcon logoIcon = new ImageIcon(imgURL);
            Image img = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            logo.setIcon(new ImageIcon(img));
        } else {
            logo.setText("Logo not found");
            logo.setHorizontalAlignment(SwingConstants.CENTER);
            logo.setPreferredSize(new Dimension(100, 100));
            System.err.println("Couldn't find file: logo.png");
        }

        // Logo panel with right alignment
        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        logoPanel.setBackground(Color.WHITE);
        logoPanel.add(logo);

        // Add logo and top bar to header
        headerPanel.add(logoPanel, BorderLayout.EAST);
        headerPanel.add(createTopBar(), BorderLayout.CENTER);

        // Add header to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Content panel for stats and bottom section
        JPanel contentPanel = new JPanel(new BorderLayout(15, 15));
        contentPanel.setBackground(Color.WHITE);

        // Statistics Panel
        JPanel statsPanel = createStatsPanel();
        contentPanel.add(statsPanel, BorderLayout.CENTER);

        // Bottom Panel containing Coaches, Calendar and Inventory
        JPanel bottomPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        bottomPanel.add(createCoachesPanel());
        bottomPanel.add(createCalendarPanel());
        bottomPanel.add(createInventoryPanel());
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add content panel to main panel
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);

        // Window settings
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(1000, 750));
        pack();
        setLocationRelativeTo(null);
    }
   
    private JPanel createTopBar() {
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(Color.WHITE);
       
        // Center buttons (changed from right alignment)
        JPanel centerButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerButtons.setBackground(Color.WHITE);
       
        JButton contactButton = new JButton("Contact US");
        contactButton.setBorderPainted(false);
        contactButton.setContentAreaFilled(false);
       
        JButton feedbackButton = new JButton("Feedback");
        feedbackButton.setBorderPainted(false);
        feedbackButton.setContentAreaFilled(false);
       
        JButton notificationButton = new JButton("🔔");
        notificationButton.setBorderPainted(false);
        notificationButton.setContentAreaFilled(false);
       
        centerButtons.add(contactButton);
        centerButtons.add(feedbackButton);
        centerButtons.add(notificationButton);
       
        // Add Report label to the left with vertical padding
        JPanel reportPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        reportPanel.setBackground(Color.WHITE);
        JLabel reportLabel = new JLabel("Report");
        reportLabel.setFont(new Font("Arial", Font.BOLD, 20));
        reportLabel.setForeground(Color.RED);
        reportPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 0));
        reportPanel.add(reportLabel);
       
        topBar.add(reportPanel, BorderLayout.WEST);
        topBar.add(centerButtons, BorderLayout.CENTER); // Changed from EAST to CENTER
       
        return topBar;
    }
   
    private JPanel createStatsPanel() {
        JPanel statsPanel = new JPanel(new GridLayout(1, 3, 15, 0));
        statsPanel.setBackground(Color.WHITE);  // Add background color
        statsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));  // Remove padding (already added in parent)
       
        // Members Card
        JPanel membersCard = createStatCard("Members", "23,400", "65%", new Color(230, 240, 255));
       
        // Profit Card
        JPanel profitCard = createStatCard("Profit", "$19.5m", "48%", new Color(240, 235, 245));
       
        // Satisfaction Card
        JPanel satisfactionCard = createStatCard("Satisfaction", "21,060", "93%", new Color(255, 235, 235));
       
        statsPanel.add(membersCard);
        statsPanel.add(profitCard);
        statsPanel.add(satisfactionCard);
       
        return statsPanel;
    }
   
    private JPanel createStatCard(String title, String value, String percentage, Color bgColor) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(bgColor);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
       
        // Icon and Title in one row
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        headerPanel.setBackground(bgColor);
       
        String iconText = title.equals("Members") ? "👤" :
                         title.equals("Profit") ? "📈" : "😊";
        JLabel iconLabel = new JLabel(iconText);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 14));
       
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
       
        headerPanel.add(iconLabel);
        headerPanel.add(titleLabel);
       
        // Value
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 20));
        valueLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
       
        // Graph Panel
        JPanel graphPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
               
                int w = getWidth();
                int h = getHeight();
               
                Color startColor = title.equals("Members") ? new Color(64, 159, 255, 100) :
                                 title.equals("Profit") ? new Color(156, 39, 176, 100) :
                                 new Color(255, 128, 171, 100);
                Color endColor = new Color(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), 20);
                GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, h, endColor);
               
                int[] xPoints = new int[w + 1];
                int[] yPoints = new int[w + 1];
               
                for (int x = 0; x < w; x++) {
                    xPoints[x] = x;
                    double progress = (double) x / w;
                    double amplitude = 8;
                    double frequency = 2;
                    yPoints[x] = (int) (h/2 + amplitude * Math.sin(progress * frequency * Math.PI) +
                                      amplitude * Math.cos(progress * 3 * Math.PI));
                }
                xPoints[w] = w;
                yPoints[w] = h;
                xPoints[0] = 0;
                yPoints[0] = h;
               
                g2d.setPaint(gradient);
                g2d.fillPolygon(xPoints, yPoints, xPoints.length);
               
                g2d.setColor(startColor.darker());
                g2d.setStroke(new BasicStroke(1.5f));
                for (int i = 1; i < w; i++) {
                    g2d.drawLine(xPoints[i-1], yPoints[i-1], xPoints[i], yPoints[i]);
                }
            }
           
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(180, 40);
            }
        };
        graphPanel.setBackground(bgColor);
        graphPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
       
        // Percentage with arrow
        JLabel percentageLabel = new JLabel("↑ " + percentage);
        percentageLabel.setForeground(new Color(75, 181, 67));
        percentageLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        percentageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
       
        card.add(headerPanel);
        card.add(Box.createVerticalStrut(5));
        card.add(valueLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(graphPanel);
        card.add(Box.createVerticalStrut(3));
        card.add(percentageLabel);
       
        return card;
    }
   
    private JPanel createCoachesPanel() {
        JPanel coachesPanel = new JPanel(new BorderLayout(10, 10));
        coachesPanel.setBackground(Color.WHITE);
        coachesPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
 
        // Header with title and options button
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("Coaches");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JButton optionsButton = new JButton("⋮");
        optionsButton.setBorderPainted(false);
        optionsButton.setContentAreaFilled(false);
        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(optionsButton, BorderLayout.EAST);
 
        // Coaches list with colored dots
        JPanel coachesListPanel = new JPanel();
        coachesListPanel.setLayout(new BoxLayout(coachesListPanel, BoxLayout.Y_AXIS));
        coachesListPanel.setBackground(Color.WHITE);
 
        String[][] coaches = {
            {"Rajiv", "blue"},
            {"Iana", "pink"},
            {"Selena", "blue"},
            {"Zyan", "blue"}
        };
 
        for (String[] coach : coaches) {
            JPanel coachRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
            coachRow.setBackground(Color.WHITE);
           
            // Colored dot
            JLabel dot = new JLabel("●");
            dot.setForeground(coach[1].equals("blue") ? new Color(64, 159, 255) : new Color(255, 128, 171));
           
            JLabel nameLabel = new JLabel(coach[0]);
            nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
           
            coachRow.add(dot);
            coachRow.add(nameLabel);
            coachesListPanel.add(coachRow);
        }
 
        coachesPanel.add(headerPanel, BorderLayout.NORTH);
        coachesPanel.add(coachesListPanel, BorderLayout.CENTER);
        return coachesPanel;
    }
   
    private JPanel createCalendarPanel() {
        JPanel calendarPanel = new JPanel(new BorderLayout(10, 10));
        calendarPanel.setBackground(Color.WHITE);
        calendarPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
 
        // Date header
        JPanel dateHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dateHeader.setBackground(Color.WHITE);
        JLabel dateLabel = new JLabel("Jan 12, 2025");
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        dateLabel.setForeground(new Color(156, 39, 176)); // Purple color for date
        dateHeader.add(dateLabel);
 
        // Calendar grid
        JPanel calendarGrid = new JPanel(new GridLayout(7, 7, 5, 5));
        calendarGrid.setBackground(Color.WHITE);
 
        // Days of week
        String[] daysOfWeek = {"M", "T", "W", "T", "F", "S", "S"};
        for (String day : daysOfWeek) {
            JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
            dayLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            calendarGrid.add(dayLabel);
        }
 
        // Calendar dates
        for (int i = 1; i <= 31; i++) {
            JLabel dateCell = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            dateCell.setFont(new Font("Arial", Font.PLAIN, 12));
            if (i == 17) { // Highlighted date
                dateCell.setForeground(Color.WHITE);
                dateCell.setOpaque(true);
                dateCell.setBackground(new Color(156, 39, 176));
            }
            calendarGrid.add(dateCell);
        }
 
        calendarPanel.add(dateHeader, BorderLayout.NORTH);
        calendarPanel.add(calendarGrid, BorderLayout.CENTER);
        return calendarPanel;
    }
   
    private JPanel createInventoryPanel() {
        JPanel inventoryPanel = new JPanel(new BorderLayout(10, 10));
        inventoryPanel.setBackground(new Color(255, 248, 225)); // Light cream background
        inventoryPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
 
        // Header
        JLabel titleLabel = new JLabel("Inventory");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        inventoryPanel.add(titleLabel, BorderLayout.NORTH);
 
        // Table panel
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
        tablePanel.setBackground(new Color(255, 248, 225));
 
        // Column headers
        JPanel headerRow = new JPanel(new GridLayout(1, 3));
        headerRow.setBackground(new Color(255, 248, 225));
        String[] headers = {"Equipment ↓", "Total no. ↓", "Status ↓"};
        for (String header : headers) {
            JLabel headerLabel = new JLabel(header);
            headerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            headerRow.add(headerLabel);
        }
 
        // Data rows
        String[][] data = {
            {"Treadmill", "10", "Active"},
            {"10 lbs dumbbell", "20", "Active"},
            {"15 lbs dumbbell", "15", "Active"},
            {"25 lbs dumbbell", "15", "Active"}
        };
 
        tablePanel.add(headerRow);
        for (String[] row : data) {
            JPanel dataRow = new JPanel(new GridLayout(1, 3));
            dataRow.setBackground(new Color(255, 248, 225));
            for (String cell : row) {
                JLabel cellLabel = new JLabel(cell);
                cellLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                dataRow.add(cellLabel);
            }
            tablePanel.add(dataRow);
        }
 
        inventoryPanel.add(tablePanel, BorderLayout.CENTER);
        return inventoryPanel;
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GymReport().setVisible(true);
        });
    }
}
 
