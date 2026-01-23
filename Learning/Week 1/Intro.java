import java.util.Scanner;

public class Intro
{
    public static void main(String[] args)
    {
        System.out.println("Hello\nHow\n Are\n You");
        System.out.println("He said \"Hi\\how are you?\"");
        int smallNumber;
        smallNumber = 0;
        System.out.println(smallNumber);
        System.out.println("smallNumber");

        int bigNumber = 500;
        smallNumber = -7;
        System.out.println(smallNumber);

        double decimalNumber = 3.5;
        decimalNumber = -65;
        System.out.println(decimalNumber);
        decimalNumber = 7;

        // declaring a boolean variable
        boolean trueFalse = true;
        trueFalse = false;
        System.out.println(trueFalse);

        char letter = ' ';
        letter = 't';
        letter = 'a';

        String sentence = "How are you today?";
        System.out.println(sentence);

        Scanner scnr = new Scanner(System.in);
        String response = scnr.next();

        System.out.println(response);
        response = scnr.next();
        System.out.println(response);

        System.out.println("Give me your favorite integer");
        int num = scnr.nextInt();
        System.out.println(num + 5);
    }
}
