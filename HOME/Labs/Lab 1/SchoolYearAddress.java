import java.util.Scanner;

public class SchoolYearAddress {
    public static void main(String[] args) 
    {
    System.out.println("Where and when did you go to the school?");
      Scanner scnr = new Scanner(System.in);
      String uni= scnr.next();
      int year= scnr.nextInt();
      System.out.println("You went to "+uni);
      System.out.println("You graduated in "+year);
    }
}
