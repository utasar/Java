package P3_BabyNameRanking;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitLoop = false;
        int year = 0;

        // Prompt and assign year input
        while (!exitLoop) {
            System.out.print("Enter the year: ");
            try {
                exitLoop = true; // Exit loop if input is valid
                year = input.nextInt();
                if (!(year >= 2001 && year <= 2010)) { // Check if year is between 2001 and 2010
                    System.out.print("Invalid input. Please enter a year between 2001-2010: ");
                    exitLoop = false; // Keep looping if input is invalid
                }
            } catch (Exception e) { // Catches error when input is not an integer
                System.out.println("Invalid input. Please enter only numbers.");
                exitLoop = false;
                input.next();
            }
        }

        // Prompt and assign gender input
        System.out.print("Enter the gender (M/F): ");
        char gender = input.next().toUpperCase().charAt(0); // Accepts both uppercase and lowercase input
        if (!(gender == 'M' || gender == 'F')) {
            System.out.print("Invalid input. Please type only M or F: ");
            gender = input.next().toUpperCase().charAt(0);
        }

        // Prompt and assign name input
        System.out.print("Enter the name: ");
        String name = input.next();
        input.close();

        // Check if inputted name has a ranking or not
        if (getRanking(year, gender, name) == -1) {
            System.out.println(name + " is not ranked in the year " + year);
        } else {
            System.out.println(name + " is ranked #" + getRanking(year, gender, name) + " in the year " + year);
        }
    }

    public static int getRanking(int year, char gender, String name) {
        String next = "";
        String[] boyNames = new String[1000]; // .txt file is 1000 lines long
        String[] girlNames = new String[1000];
        File file = new File(
            "P3_BabyNameRanking\\babynamesranking" + year + ".txt"); // Picks file based on year inputted

        try (Scanner fileScanner = new Scanner(file);) {
            for (int i = 0; i < 1000; i++) { // Rows
                for (int j = 0; j < 5; j++) { // Columns
                    next = fileScanner.next();
                    
                    // Second column contains boy names
                    if (j == 1) {
                        boyNames[i] = next;
                        if (boyNames[i].equals(name) && gender == 'M') { // Checks name input against array and gender
                            fileScanner.close();
                            return i + 1; // Returns index of ranking for name
                        }
                    }

                    // Fourth column contains girl names
                    if (j == 3) {
                        girlNames[i] = next;
                        if (girlNames[i].equals(name) && gender == 'F') { // Checks name input against array and gender
                            fileScanner.close();
                            return i + 1; // Returns index of ranking for name
                        }
                    }
                }
            }
            fileScanner.close();
        } catch (IOException e) {
            e.printStackTrace(); // Catches and outputs any IO errors
        }
        return -1; // Return -1 if name is not in .txt file
    }
}

/*
(Baby name popularity ranking)
The popularity ranking of baby names from years 2001 to 2010
is downloaded from <URL>www.ssa.gov/oact/babynames</URL> and stored in files
named babynameranking2001.txt, babynameranking2002.txt, …,
babynameranking2010.txt. Each file contains one thousand lines. Each line contains a
ranking, a boy’s name, number for the boy’s name, a girl’s name, and number for the girl’s
name. For example, the first two lines in the file babynameranking2010.txt are as follows:
1 Jacob 21,875 Isabella 22,731
2 Ethan 17,866 Sophia 20,477

So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s name
Ethan and girl’s name Sophia are ranked #2. 21,875 boys are named Jacob and 22,731 girls are
named Isabella. Write a program that prompts the user to enter the year, gender, and followed
by a name, and displays the ranking of the name for the year. Here is a sample run:
<Output>
Enter the year: 2010 <Enter icon>
Enter the gender: M <Enter icon>
Enter the name: Javier <Enter icon>
Javier is ranked #190 in year 2010
<End Output>
<Output>
Enter the year: 2010 <Enter icon>
Enter the gender: F <Enter icon>
Enter the name: ABC <Enter icon>
*/
