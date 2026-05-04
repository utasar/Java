package Exceptions;

// import java.io.*;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        /*
        String s = "hello";

        if (Math.random() < 1.0) {
            s = null;
        }
        System.out.println(s.length());
        */
        /*
        String filename = "Lecture Programs/Exceptions/name.txt";
        Scanner keyboard = new Scanner(System.in);
        
        try {
            Scanner in = new Scanner(new File(filename));
            System.out.println("Hello " + in.nextLine());
            int x = 9;
            int y = 0;
            int z = x / y;
        } catch (FileNotFoundException e1) {
            System.out.print("Greetings! What is your name? ");
            String name = keyboard.nextLine();

            try {
                PrintWriter pw = new PrintWriter(filename);
                pw.println(name);
                pw.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }  
        } catch (ArithmeticException e3) {
            System.out.println("Error: Can not divide by zero.");
        } catch (Exception e4) {
            System.out.println("Error: General");
        } finally {
            // this block always executes (whether or not an exception happened)
            // we normally use it to free up any system resources
            keyboard.close();
        }
        */

        int input = 0;
        try {
            input = getInput();
            System.out.println("You entered: " + input);
        } catch (DumbUserException e) {
            System.out.println("Error: Value set to 5");
            input = 5;
        }
    }


        public static int getInput() throws DumbUserException {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a number between 1 and 10: ");
            int x = in.nextInt();
            in.close();

            if (x < 1 || x > 10) {
                throw new DumbUserException("Wanted 1 to 10; got " + x);
            }
            return x;
        }
    
}
