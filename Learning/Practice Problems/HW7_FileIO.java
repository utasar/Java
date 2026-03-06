import java.util.*;
import java.io.*;

public class HW7_FileIO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is the name of the file? ");
        String filename = input.nextLine();

        System.out.print("What would you like to print to the file? ");
        String s = input.nextLine();
        input.close();

        File f = writeText(filename, s);
        System.out.println(filename + " contains " + countWords(f) + " words.");
    }
    
    public static File writeText(String filename, String s) {
        File f = new File(filename);

        try (java.io.PrintWriter output = new java.io.PrintWriter(f);) {
        output.print(s);
        output.close();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        return f;
    }

    public static int countWords(File f) {
        int count = 0;
        
        try (Scanner sc = new Scanner(new FileInputStream(f))) {
            while(sc.hasNext()){
                String word=sc.next();
                if(word.indexOf("\\")==-1)
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        return count;
    }
}

/*
First, write two methods with the following signatures:
public static File writeText(String filename, String s)
public static int countWords(File f)

The first method should create a File named filename and write the String s to the file. It should 
then return the file object. The second method should count the number of words in the File f 
and return that count. A “word” in this case is any text separated by whitespace. For instance, if 
the file contained “Buy 10 eggs from the grocery.” Then the method would return 6.

Next, in main prompt the user for a filename and a string and call your writeText method. Then 
call your countWords method with the file returned from the writeText method. Display the 
value returned by countWords to the console.

For example: 
What is the name of the file? Test.txt
What would you like to print to the file? Hello World
Test.txt contains 2 words.

After your program runs as shown above, there should also be a file called Test.txt with the
contents Hello World.
 */
