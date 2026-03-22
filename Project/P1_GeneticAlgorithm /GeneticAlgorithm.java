

package P1_GeneticAlgorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GeneticAlgorithm {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "Projects/P1_GeneticAlgorithm/items.txt"; // alternative more_items.txt
        int popSize = 10;   // 100 for more_items.txt
        int gens = 20;  // 5000 for more_items.txt 

        Random rng = new Random();
        ArrayList<Item> items = new ArrayList<>();
        items = readData(filename);
        
        // Create a set of ten random individuals to serve as the initial population 
        ArrayList<Chromosome> initialPop = initializePopulation(items, popSize);
            
        for (int i = 0; i < gens; i++) {
            // Add each of the individuals in the current population to the next generation 
            ArrayList<Chromosome> nextGen = new ArrayList<>();
            nextGen.addAll(initialPop);
        
            // Randomly pair off the individuals and perform crossover to create a child and add it to 
            // the next generation as well. 
            while (nextGen.size() < popSize * 2) {
                Chromosome parent1 = initialPop.get(rng.nextInt(initialPop.size()));
                Chromosome parent2 = initialPop.get(rng.nextInt(initialPop.size()));
                Chromosome child = parent1.crossover(parent2);
                nextGen.add(child);
            }

            // Randomly choose ten percent of the individuals in the next generation and expose them 
            // to mutation 
            for (int j = 0; j < nextGen.size() * 0.1; j++) {
                Chromosome individual = nextGen.get(rng.nextInt(nextGen.size()));
                individual.mutate();
            }

            // Sort the individuals in the next generation according to their fitness
            nextGen.sort(null);

            // Clear out the current population and add the top ten of the next generation back into the 
            // population
            initialPop.clear();
            for (int k = 0; k < popSize; k++) {
                initialPop.add(nextGen.get(k));
            }
        }
        // Sort the population and display the fittest individual to the console
        initialPop.sort(null);
        System.out.println(initialPop.get(0));
    }
    

    public static ArrayList<Item> readData(String filename) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filename));
        ArrayList<Item> items = new ArrayList<>();

        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] tokens = line.split(", ");

            String name = tokens[0];
            double weight = Double.parseDouble(tokens[1]);
            int value = Integer.parseInt(tokens[2]);
            
            items.add(new Item(name, weight, value));
        }
        input.close();
        return items;
    }

    
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize) {
        ArrayList<Chromosome> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(new Chromosome(items));
        }
        return population;
    }
}
