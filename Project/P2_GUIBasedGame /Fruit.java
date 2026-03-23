
package P2_GUIBasedGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Fruit extends JComponent {
    Random r = new Random();

    // randomly generate a number in between 0 and 950
    private int xCoord = (int)r.nextInt(950);;
    private int yCoord;
    private int speed;
    private String image;

    public Fruit(String image) {
        xCoord = 0;
        yCoord = 0;
        speed = 2;
        this.image = image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Import image and allow it to be resized
        ImageIcon fruit = new ImageIcon(image);
        Image fruit1 = fruit.getImage();
        Image newFruit = fruit1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        fruit = new ImageIcon(newFruit);
        fruit.paintIcon(this, g, xCoord, yCoord);
    }
    
    // Getters and setters
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public void setSpeed(int change) {
        this.speed = change;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    public int getSpeed() {
        return speed;
    }

    public String getImage() {
        return image;
    }
}
