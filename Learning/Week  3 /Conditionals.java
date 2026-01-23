import java.util.Scanner;

public class Conditionals
{
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        String stringOne = "abc";

        System.out.println("Type a string: ");
        String input = scnr.next();

        if (stringOne == input)
        {
            System.out.println("These string references are equal!!!");
        }
        if (stringOne.equalsIgnoreCase(input))
        {
            System.out.println("These strings are equal!");
        }

        System.out.println("Enter your favorite number:");
        double favNum = scnr.nextDouble();



        if (favNum >= -10 && favNum <= 10)
        {
            System.out.println("Number is in range!");
        }
        else
        {
            double difference = favNum - 10;
            favNum = favNum - difference;

            if (difference < 0)
            {
                favNum = favNum - 20;
            }
        }
        System.out.println(favNum);
    }
}
