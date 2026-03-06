package HW9_LetsPlay; 

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Iron Man", 50, 10);
        Player player2 = new Player("Thanos", 100, 20);

        System.out.println(player1.getName() + " vs. " + player2.getName() + "\n");
        System.out.println(player1.toString() + " vs. " + player2.toString());
        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            player1.hit(player2);
            player2.hit(player1);
            System.out.print(player1.toString() + " vs. " + player2.toString() + "\n");
        }

        if (player1.getHealth() > 0) {
            System.out.println("\n" + player1.getName() + " wins!");
        } else {
            System.out.println("\n" + player2.getName() + " wins!");
        }

    }
    
}

/*
Your task is to write a class called Player for an RPG game. The class should have the following fields and
methods (all fields should be private, and all methods should be public):

private String name – the player’s name.
private int health – the health of the player
private int maxDamage – the maximum damage the player does to enemies per hit

public Player(String name, int health, int maxDamage)
This constructor should initialize the Player object’s fields

public void hit(Player other)
Decrease the other player’s health by a random number between 1 and the maxDamage this player
does.

public String toString()
Override the toString() method to return a String containing the Player’s name and health the form
Name (health).

Getter and setter methods for all fields

Write a main method that creates two Player objects and repeatedly prints each one to the console and
then has each one hit the other until one runs out of health, as shown in the example below.

Example

Here I have two characters, Iron Man (initial health 50, max damage 10) and Thanos (initial health 100,
max damage 20).

Iron Man (50) Thanos (100)
Iron Man (47) Thanos (94)
Iron Man (44) Thanos (91)
Iron Man (40) Thanos (85)
Iron Man (27) Thanos (79)
Iron Man (23) Thanos (74)
Iron Man (10) Thanos (66)
Iron Man (7) Thanos (64)
Iron Man (-11) Thanos (59)
 */
