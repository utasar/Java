import java.util.Scanner;

public class UserInputLoop
{
    public static void main(String[] args)
    {
        boolean exit = false;
        Scanner scnr = new Scanner(System.in);
        System.out.println("Give me a number!");

        while (!exit && !scnr.hasNextInt())
        {
            if (scnr.hasNext())
            {
                String userInput = scnr.nextLine();

                if (userInput.equals("exit"))
                {
                    exit = true;
                }
                else
                {
                    System.out.println("Try again!");
                    //scnr.nextLine();
                }
            }
        }
    }
}
