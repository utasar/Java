import java.util.Random;
class Treasure {
    private int row;
    private int col;
    private int healthBoost;

    public Treasure(int dungeonSize) {
        Random rand = new Random();
        this.row = rand.nextInt(dungeonSize);
        this.col = rand.nextInt(dungeonSize);
        // healthboost point is number of boxes available in the 
        this.healthBoost = dungeonSize * dungeonSize;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    @Override
    public String toString() {
        return "Congratulations!!! You got Treasure at " + row + ", " + col + " with health boost of " + healthBoost;
    }
}
