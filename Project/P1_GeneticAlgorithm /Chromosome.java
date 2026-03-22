

package P1_GeneticAlgorithm;
import java.util.ArrayList;
import java.util.Random;

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> {
    private static Random rng = new Random();

    public Chromosome() {
        super();
    };

    // Adds a copy of each of the items passed in to this Chromosome. Uses a random 
    // number to decide whether each item’s included field is set to true or false. 
    public Chromosome(ArrayList<Item> items) {
        for (Item item : items) {
            Item newItem = new Item(item);
            newItem.setIncluded(rng.nextBoolean());
            this.add(new Item(newItem));
        }
    }

    // Creates and returns a new child chromosome by performing the crossover 
    // operation on this chromosome and the other one that is passed in (i.e. for each item, use 
    // a random number to decide which parent’s item should be copied and added to the child). 
    public Chromosome crossover(Chromosome other) {
        Chromosome child = new Chromosome();
        for (int i = 0; i < this.size(); i++) {
            if (rng.nextBoolean()) {
                child.add(new Item(this.get(i)));
            } else {
                child.add(new Item(other.get(i)));
            }
        }
        return child;
    }

    // Performs the mutation operation on this chromosome (i.e. for each item in this 
    // chromosome, use a random number to decide whether or not to flip it’s included field from 
    // true to false or vice versa).
    public void mutate() {
        for (Item item : this) {
            if (rng.nextBoolean()) {
                item.setIncluded(!item.isIncluded());
            }
        }
    }

    // Returns the fitness of this chromosome. If the sum of all of the included items’ weights 
    // are greater than 10, the fitness is zero. Otherwise, the fitness is equal to the sum of all of the 
    // included items’ values. 
    public int getFitness() {
        double totalWeight = 0;
        int totalValue = 0;
        for (Item item : this) {
            if (item.isIncluded()) {
                totalWeight += item.getWeight();
                totalValue += item.getValue();
            }
        }
        if (totalWeight > 10) {
            return 0;
        } else {
            return totalValue;
        }
    }

    // Returns -1 if this chromosome’s fitness is greater than the other’s fitness, +1 if 
    // this chromosome’s fitness is less than the other one’s, and 0 if their fitness is the same. 
    public int compareTo(Chromosome other) {
        if (this.getFitness() > other.getFitness()) {
            return -1;
        } else if (this.getFitness() < other.getFitness()) {
            return 1;
        } else {
            return 0;
        }
    }

    // Displays the name, weight and value of all items in this chromosome whose included 
    // value is true, followed by the fitness of this chromosome. 
    public String toString() {
        String result = "";
        for (Item item : this) {
            if (item.isIncluded()) {
                result += item.toString() + " ";
                }        
        }
        return result + "\n" + String.valueOf(getFitness());
    }
}
