
package P2_GUIBasedGame;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game extends JPanel implements KeyListener {
    private int xCoordPlate = 450;
    private int changePlate = 20;

    private static int score = 0;
    private static int lives = 3;

    Fruit apple = new Fruit("Projects/P2_GUIBasedGame/pictures/apple.png");
    
    public Game() {
        this.addKeyListener(this);

        // Updates the position of the apple and repaints the screen every 5 milliseconds
        Timer t = new Timer(5, e -> {
            apple.setYCoord(apple.getYCoord() + apple.getSpeed());
            this.repaint();
        });
        t.setRepeats(true);
        t.start();
    }

    public void paintComponent(Graphics g) {
        ArrayList<String> fruits = new ArrayList<String>();
        fruits.add("Projects/P2_GUIBasedGame/pictures/grape.png");
        fruits.add("Projects/P2_GUIBasedGame/pictures/apple.png");
        fruits.add("Projects/P2_GUIBasedGame/pictures/pear.png");
        fruits.add("Projects/P2_GUIBasedGame/pictures/watermelon.png");

        super.paintComponent(g);

        // Plate image
        ImageIcon plate = new ImageIcon("Projects/P2_GUIBasedGame/pictures/plate.png");
        Image plate1 = plate.getImage();
        // Allow to be resized
        Image newPlate = plate1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        plate = new ImageIcon(newPlate);
        plate.paintIcon(this, g, xCoordPlate, this.getSize().height - 100);

        // Add apple to game
        apple.paintComponent(g);
        apple.repaint();

        // Collision logic with apple
        if (apple.getYCoord() >= this.getSize().height - 150) {
            if (apple.getXCoord() >= xCoordPlate && apple.getXCoord() <= xCoordPlate + 100) {
                // Make apple fall faster and increase score by 1
                apple.setYCoord(0);
                apple.setXCoord((int)(Math.random() * this.getSize().width));
                score++;
                // Set image to random fruit
                apple.setImage(fruits.get((int)(Math.random() * fruits.size())));
                apple.setSpeed(apple.getSpeed() + 1);
            } else {
                // Game over
                apple.setYCoord(0);
                lives--;
                // Set images to random fruit
                apple.setImage(fruits.get((int)(Math.random() * fruits.size())));
                if (lives == 0) {
                    JLabel gameOver = new JLabel("Game over");
                    gameOver.setFont(new Font("", Font.BOLD, 50));
                    gameOver.setForeground(Color.RED);
                    this.add(gameOver);
                } else if (score == 10) {
                    JLabel gameOver = new JLabel("You win!");
                    gameOver.setFont(new Font("", Font.BOLD, 50));
                    gameOver.setForeground(Color.GREEN);
                    this.add(gameOver);
                }
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Move plate left
        if (key == KeyEvent.VK_LEFT) {
            xCoordPlate = xCoordPlate - changePlate;
            checkBoundsX();
            this.repaint();
        // Move plate right
        } else if (key == KeyEvent.VK_RIGHT) {
            xCoordPlate = xCoordPlate + changePlate;
            checkBoundsX();
            this.repaint();
        // Move plate left FAST when A is pressed
        } else if (key == KeyEvent.VK_A) {
            xCoordPlate = xCoordPlate - changePlate * 3;
            checkBoundsX();
            this.repaint();
        // Move plate right FAST when D is pressed
        } else if (key == KeyEvent.VK_D) {
            xCoordPlate = xCoordPlate + changePlate * 3;
            checkBoundsX();
            this.repaint();
        } else  {
            System.out.println("Invalid input");
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void checkBoundsX() {
        if (xCoordPlate < -50) { // Left half off window
            xCoordPlate = this.getSize().width - 50;   // Teleport to right side
        } else if (xCoordPlate > this.getSize().width - 50) { // Right half off window
            xCoordPlate = -50;   // Teleport to left side
        }
    }

    // Getters and Setters
    public static int getScore() {
        return score;
    }

    public static int getLives() {
        return lives;
    }

    public static void setScore(int score) {
        Game.score = score;
    }

    public static void setLives(int lives) {
        Game.lives = lives;
    }
}
