import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayString {
    public static void main(String[] args) {
        
      readFromFileToArray("MovieNames.txt");
    }
    public static String[] readFromFileToArray(String[] args) 
    {
        FileInputStream inputStream = null;
        int tokenCount = 0;
        String[] movieWords = null;
        try(Scanner scnr = new Scanner(new FileInputStream(String fileName)))
        {
            while (scnr.hasNext()) {
                tokenCount++;
                System.out.println(scnr.next());  
            }
            movieWords = new String[tokenCount];
            int index =0;
            while (scnr.hasNext()) 
                {
                movieWords[index]=scnr.next();
                index++;
                }
            
        }catch(FileNotFoundException e)
        {
            System.out.println("File Name is incorrect");
        }
        return movieWords;
    }
    public static void printArray(String[] args) {
        
    }

}
