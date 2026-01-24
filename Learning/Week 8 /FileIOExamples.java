import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileIOExamples
{
    public static void main(String[] args) throws IOException
    {
        FileWriter fwriter = new FileWriter("1.txt", true);
        PrintWriter fileOut = new PrintWriter(fwriter);
        //fileOut.println("one");
        fileOut.close();

        boolean incorrectInput = true;

        while (incorrectInput)
        {
            try
            {
                Scanner readConsole = new Scanner(System.in);
                System.out.println("Please enter the name of the file that you would like to read:");
                int fileName = readConsole.nextInt();

                File fileHandle = new File(fileName + ".txt");
                Scanner readFile = new Scanner(fileHandle);

                while (readFile.hasNextLine())
                {
                    System.out.println(readFile.nextLine());
                }
                incorrectInput = false;
            }
            catch (InputMismatchException ime)
            {
                System.out.println("You need to input an integer!");
                System.out.println("Try again!");
            }
            catch (FileNotFoundException fnfe)
            {
                System.out.println("That was not a valid file name!");
                System.out.println("Try again!");
            }
        }
    }
}
