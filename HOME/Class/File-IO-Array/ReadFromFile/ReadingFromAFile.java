import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadingFromAFile {
    public static void main(String[] args) throws IOException {
        int sumAccumulator =0;
        Scanner scnrUserInput = new Scanner(System.in);
        System.out.println("Enter file Name:");
        String fileName = scnrUserInput.nextLine();
        System.out.println(fileName);
        FileInputStream fileInputStream=null;
        try(Scanner scnr = new Scanner(new FileInputStream(fileName))){
            //
            while(scnr.hasNextLine())
            {
                int dataFromFile = scnr.nextInt();
                sumAccumulator =sumAccumulator +dataFromFile;
            }
        }catch(FileNotFoundException e){
            System.out.println("The requested file could not be found.");
        } finally{
            System.out.println("The sum of all values until reaching the exception is"+sumAccumulator);
        }
    scnrUserInput.close();
    }
}
