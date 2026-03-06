package HW9_LetsPlay;

public class Player {
    private String name = "";
    private int health = 0;
    private int maxDamage = 0;

    public Player(String name, int health, int maxDamage) {
        this.name = name;
        this.health = health;
        this.maxDamage = maxDamage;
    }

    public void hit(Player other) {
        int damage = (int) (Math.random() * maxDamage) + 1;
        other.health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return (name + " (" + health +")");
    }
}
