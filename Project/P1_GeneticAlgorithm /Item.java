
package P1_GeneticAlgorithm;

public class Item {
    private final String name;      // Label for the item
    private final double weight;    // Weight of the item in pounds
    private final int value;        // Value of the item rounded to the nearest dollar
    private boolean included;       // Whether the item should be taken or not

    public Item(String name, double weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.included = false;
    }

    public Item(Item other) {
        this.name = other.name;
        this.weight = other.weight;
        this.value = other.value;
        this.included = other.included;
    }

    public String toString() {
        return name + " (" + weight + " lbs, $" + value + ')';
    }

    // Getters and Setters
    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }
}
