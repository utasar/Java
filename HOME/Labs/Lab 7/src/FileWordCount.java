/*
 * @author: Utsav Acharya
 * @version: 1.0.0
 */

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileOutputStream; // commented because of the code change program demands file as return type
import java.io.FileWriter;
//import java.io.PrintWriter; // Printwriter commented because it is no more used.. It was used on the commented code of try catch
import java.io.IOException;
import java.util.Scanner;
public class FileWordCount {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter the file name:");
        String fileName = scnr.nextLine();
        System.out.println("What would you like to print to the file?:");
        String message = scnr.nextLine();
        // Call the writeText method
        writeText(fileName, message);
            
        // Call the countWords method with the filename
        int wordCount = countWords(fileName);
        
        // Display the filename and the word count
        System.out.println("Filename: " + fileName);
        System.out.println("Number of words in the file: " + wordCount);
        scnr.close();
    }
    /**
     * Creates a file, writes provided string to file, returns the file
     * 
     * @param filename the name of the file to create and write to
     * @param s the string to write to the file
     * @return the File object representing the written file 
     * @throws IOException if an I/O error occurs
     */
    public static File writeText(String fileName, String s) throws IOException {
        File f= new File(fileName); 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
            writer.write(s);
        // Following code commented, it was written the way professor taught on class
        // try(FileOutputStream outPutStream = new FileOutputStream(fileName)) {
        //     PrintWriter writer = new PrintWriter(outPutStream);
        //      writer.println(s); 
         writer.close();   
           
        } catch (Exception e) {
            // Handle to exception
            System.out.println("File Cannot be Created");
        }
        return f;
    }
    /**
     * Counts number of words in file
     * A word is any text separated by a whitespace
     * 
     * @param filename the name of the file to count words in
     * @return the number of words in the file
     * @throws IOException if an I/O error occurs
     */
    public static int countWords(String filename) throws IOException {
        int wordCount = 0;

        try (Scanner fileScanner = new Scanner(new FileInputStream(filename)))
        {
            while(fileScanner.hasNextLine())
            {
                fileScanner.next();
               // System.out.println(fileScanner.next());
                wordCount+=1;
        
            }  
        } catch (Exception e) {
            // Exception handling
            System.out.println("File not Found");
        }
        return wordCount;
    }

}
