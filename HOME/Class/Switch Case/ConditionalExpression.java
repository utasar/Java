import java.util.Scanner;

public class ConditionalExpression {
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); 
        System.out.println("Enter a number:");
        int number = scnr.nextInt();
        int evenNumber;
        // if (number %2 == 0)
        // {
        //    evenNumber=number; 
        // }
        // else
        // {
        //     evenNumber=0;
        // }

        //implement conditional expression
        evenNumber=(number%2==0)? number:0;// Ternary operator
        System.out.println(evenNumber);
    }
}
