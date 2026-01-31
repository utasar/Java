import java.util.Scanner;

public class FloatingPointComperator {
    public static void main(String[] args) 
    {
        //absollan 2.0 can be almost equal to 2.00001
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter Model 1 measurement (length -inch)");
        double tableLength1 = scnr.nextDouble();
        double tableLength2 = scnr.nextDouble();
        // Decision making scheme for floating point double values

        if (Math.abs(tableLength1 - tableLength2) < 0.01)
         {
            System.out.printf("The difference is %f therefore the check has passed",Math.abs(tableLength1-tableLength2));
         }
         else
            System.out.printf("Thhe difference is %f therefore the check has failed",Math.abs(tableLength1-tableLength2));
    scnr.close();;
     }
}
