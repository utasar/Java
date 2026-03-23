
package P2_GUIBasedGame;

import javax.swing.*;
import java.awt.*;

public class Driver extends JFrame {

    public Driver() {
        JPanel root = new JPanel();
        Instructions iPanel = new Instructions();
        Game gPanel = new Game();
        Score sPanel = new Score();
        
        root.setLayout(new BorderLayout());
        root.add(gPanel, BorderLayout.CENTER);
        root.add(iPanel, BorderLayout.NORTH);
        root.add(sPanel, BorderLayout.SOUTH);
        
        iPanel.setBackground(Color.gray);
        gPanel.setBackground(Color.gray);
        sPanel.setBackground(Color.gray);

        this.getContentPane().add(root);
        this.setTitle("Catch the Fruit!");
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        gPanel.setFocusable(true);
        gPanel.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new Driver();
    }
}
