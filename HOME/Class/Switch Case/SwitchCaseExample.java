import java.util.Scanner;

public class SwitchCaseExample
 {
    
    public static void main(String[] args) throws Exception 
    {
        //Example of if else statement
        Scanner scnr = new Scanner(System.in);
        System.out.println("Input the Code");
        int choice = scnr.nextInt();
        if (choice == 226)
        {
            System.out.println("Here is your Gatorade");
        }
        else if(choice == 227)
        {
            System.out.println("Here is your Twix");
        }
        else if(choice == 228)
        {
            System.out.println("Here is your Potato Chips");
        }
        else if (choice == 326)
        {
            System.out.println("Here is your pepsi");
        }
        else if (choice == 327)
        {
            System.out.println("Here is your water bottle");
        }
        else if (choice == 328)
         {
            System.out.println("Here is your pop tarts");         
         }
         else
         System.out.println("Invalid Code");
// code ends here for if else statement
        switch (choice) 
        {
            case 226:
                System.out.println("Here is your Geterote");
                break;
            case (227):
                System.out.println("Here is your Twix");
                break;   
            case (228):
                System.out.println("Here is your Potato Chips");
                break;
            case (326):
                System.out.println("Here is your Pepsi");
                break;
            case (327):
                System.out.println("Here is your Water bottle");
            case (328):
                System.out.println("Here is your Pop tarts");
                break;
            default:
                System.out.println("Invalid Code Entered");
                break;  
            }// Do not forget to put the break else it runs next case and goes on until it reaches to next break. is "fal through" 
            scnr.close();
    }
}
