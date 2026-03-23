
package P2_GUIBasedGame;

import java.awt.*;
import javax.swing.*;

public class Instructions extends JPanel {
    
    public Instructions() {
        JPanel root = new JPanel();
        JPanel instructions = new JPanel();
        
        JLabel message = new JLabel("How To Play");
        JLabel message2 = new JLabel(
            " 1. Use the left and right arrow keys to move the plate."
        );
        JLabel message3 = new JLabel(
            " 2. Use A and D to move the plate even faster!"
        );
        JLabel message4 = new JLabel(
            " 3. The goal is to catch the falling fruit."
        );
        JLabel message5 = new JLabel(
            " 4. If you miss 3 fruit, you lose."
        );
        JLabel message6 = new JLabel(
            " 5. If you catch 10 fruit, you win."
        );
        JLabel message7 = new JLabel(
            " 6. Good luck!"
        );

        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        root.add(message);
        root.add(instructions);

        instructions.setLayout(new GridLayout(3,2));
        instructions.add(message2);
        instructions.add(message3);
        instructions.add(message4);
        instructions.add(message5);
        instructions.add(message6);
        instructions.add(message7);

        // Set message one to center
        message.setHorizontalAlignment(JLabel.CENTER);

        root.setVisible(true);
        root.setSize(400,200);

        instructions.setBackground(Color.gray);
        root.setBackground(Color.gray);
        this.add(root);
    }
}
