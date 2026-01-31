import java.util.Random;
import java.util.Scanner;

public class ArraySuffle {
  public static void main(String[] args) 
  {
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter the original word to suffle");
    char [] CharArray1 = scnr.nextLine().toCharArray();
    
    for(int i=0; i<CharArray1.length; i++)
        {
            char tempChar = CharArray1[i];
            int randPos = randomPosition(CharArray1.length-i)+i;
            CharArray1[i]=CharArray1[randPos];
            CharArray1[randPos] = tempChar;
        }
    for(int i=0; i<CharArray1.length; i++)
        {
            System.out.print(CharArray1[i]);
        }
        
       scnr.close();
  }
  public static int randomPosition(int seed)
  {
    Random rand = new Random();
    return(rand.nextInt(seed));
  } 

}
