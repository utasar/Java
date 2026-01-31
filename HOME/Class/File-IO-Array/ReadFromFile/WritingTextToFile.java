import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
public class WritingTextToFile {
    public static void main(String[] args) throws IOException
        {
          File fileOut = new File("OutPutData.txt");  
          FileOutputStream outputStream = new FileOutputStream(fileOut);
          PrintWriter writer = new PrintWriter(outputStream);
         // writer.append("GU");
          writer.println("AMPTWRS"); 
          //above code writes the append
          writer.close();
        }
}
