import java.util.Random;
import java.util.Scanner;
public class RandomGenwithWhile {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        int sumRand =0;
        int upperLimit = 10;

        int iteration = 0;
        while (sumRand<=upperLimit) {
          //int ranNum = rand.nextInt(randSeed);
          int randSeed = scnr.nextInt();
           sumRand = sumRand + randSeed; 
           iteration++;
           System.out.println(ranNum);
        }
        System.out.println(iteration-1);// last iteration already exceeded 50
        System.out.println(sumRand);   
        scnr.close();         
    }
}
