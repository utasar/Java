import java.util.Random;
import java.util.Scanner;

public class LoopIntro
{
    public static void main(String[] args)
    {
        Random rng = new Random();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scnr.nextInt();

        while (number < 100)
        {
            System.out.println("hello!");
            number++; // number = number + 1;
                      // number += 1;
        }

        int num = 0;

        while (num < 5)
        {
            num = num + 1;
            System.out.println(num);
        }

        System.out.println();
        num = 1;

        while (num < 6)
        {
            System.out.println(num);
            num = num + 1;
        }

        do
        {
            number += 5;
            System.out.println(number);
        }
        while (number > 10);

        for (int i = 0; i < 7; i++)
        {
            System.out.println(i);
        }

        int j = 0;
        while (j < 7)
        {
            System.out.println(j);
            j++;
        }
        boolean flag = true;

        while (flag)
        {
            flag = rng.nextBoolean();
            System.out.println("blah");
        }

        for (flag = true; flag; flag = rng.nextBoolean())
        {
            System.out.println("blah");
        }
    }
}
