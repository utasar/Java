import java.util.Scanner;

public class ScannerWithMethods {
   private static int abc;
   public static int bcd;
   public static void main(String[] args) 
   {
    Scanner scnr = new Scanner(System.in);
    scnr.close();
    newInput(scnr);
   } 
   public static void newInput(Scanner scnr)
   {
    int numberA = scnr.nextInt();
    System.out.println(numberA); 
    int numberB = scnr.nextInt();
    System.out.println(numberB); 
    abc = scnr.nextInt();
    bcd = scnr.nextInt();
      
   }
}

