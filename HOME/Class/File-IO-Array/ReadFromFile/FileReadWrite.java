import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite {
    public static void main(String[] args) {
        String inputFile = "Read.txt";
        String outputFile = "Write.txt";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(inputFile);
            fileOutputStream = new FileOutputStream(outputFile);

            StringBuilder word = new StringBuilder();
            int character;

            while ((character = fileInputStream.read()) != -1) {
                if (character == '\n' || character == '\r') {
                    if (word.length() > 0) {
                        String wordStr = word.toString();
                        System.out.println(wordStr);  // Display word
                        fileOutputStream.write(wordStr.getBytes());
                        fileOutputStream.write(System.lineSeparator().getBytes());
                        word.setLength(0);  // Clear the StringBuilder for the next word
                    }
                    if (character == '\r' && fileInputStream.available() > 0 && fileInputStream.read() == '\n') {
                        // Handle Windows line endings (\r\n)
                    }
                } else {
                    word.append((char) character);
                }
            }

            // Write the last word if there's no newline at the end of the file
            if (word.length() > 0) {
                String wordStr = word.toString();
                System.out.println(wordStr);  // Display word
                fileOutputStream.write(wordStr.getBytes());
                fileOutputStream.write(System.lineSeparator().getBytes());
            }

        } catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Failed to close streams: " + e.getMessage());
            }
        }
    }
}
