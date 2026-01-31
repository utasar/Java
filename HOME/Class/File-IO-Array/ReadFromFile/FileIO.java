import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
public class FileIO {
    public static void main(String[] args) throws IOException {
        Scanner scnrFileName = new Scanner(System.in);
        System.out.print("Enter File Name:");
        String fileName = scnrFileName.nextLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Scanner scnr = new Scanner(fileInputStream);
        while (scnr.hasNext()) 
            {
            //  System.out.println(scnr.nextLine());
              String dataFromFile = scnr.nextLine();
              System.out.println(dataFromFile);
            }
        scnr.close();
        scnrFileName.close();
    }
}
