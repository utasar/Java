import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int number=0;
        boolean inputCheck=true;
        while(inputCheck){
                try{
                    System.out.println("Enter a number:");
                    number = scnr.nextInt();
                    inputCheck=false;
                }catch(InputMismatchException e)
                {
                    System.out.println("The input must be a number"+number);
                    scnr.nextLine();
                }
        }
        scnr.close();

    }
}
