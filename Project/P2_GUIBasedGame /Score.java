
package P2_GUIBasedGame;

import java.awt.*;
import javax.swing.*;

public class Score extends JPanel {

    public Score() {
        JPanel root = new JPanel();
        JLabel scoreL = new JLabel();
        JLabel livesL = new JLabel();

        Timer t = new Timer(5, e -> {
            // If score is 10, you win
            if (Game.getScore() == 10) {
                scoreL.setText("Score: " + Game.getScore());
                scoreL.setForeground(Color.green);
            } else {
                scoreL.setText("Score: " + Game.getScore());
            }
            
            // If lives is 0, you lose
            if (Game.getLives() == 0) {
                livesL.setText("Lives: " + Game.getLives());
                livesL.setForeground(Color.red);
            } else {
                livesL.setText("Lives: " + Game.getLives());
            }
        });
        t.setRepeats(true);
        t.start();

        root.setBackground(Color.gray);
        root.add(scoreL);
        root.add(livesL);
        this.add(root);
    }
}
