import java.util.*;

public class HW6_HollowShapes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitLoop = false;
        int shape = 0;

        // Prompt for shape input and check that input is valid else reprompt 
        while (!exitLoop) {
            System.out.print("Please choose a shape (1 for square, 2 for circle, 3 for triangle): ");
            try {
                exitLoop = true; // Exit loop if input is valid
                shape = input.nextInt();
                if (!(shape == 1 || shape == 2 || shape == 3)) {
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
                    exitLoop = false; // Keep looping if input is invalid
                }
            } catch (Exception e) {  // Catches error when input is not an integer
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                exitLoop = false;
                input.next();
            }
        }

        // Check for valid size input else reprompt
        System.out.print("Enter the size of the shape (or radius of circle): ");
        while (!input.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            input.next();
          }
        int size = input.nextInt();
        
        // Prompt for character input
        System.out.print("Enter the character to be used: ");
        char character = input.next().charAt(0);
        input.close();

        // Print the shape chosen
        if (shape == 1) {
            System.out.println("The hollow square is:");
            printHollowSquare(size, character);
        } else if (shape == 2) {
            System.out.println("The hollow circle is:");
            printHollowCircle(size, character);
        } else if (shape == 3) {
            System.out.println("The hollow triangle is:");
            printHollowTriangle(size, character);
        }
    }

    public static void printHollowSquare(int size, char character) {
        for (int x = 0; x < size; x++) { // rows
            for (int y = 0; y < size; y++) { // columns
                if (x == 0 || y == 0 || x == size - 1 || y == size - 1) { // first row || first column || last row || last column
                    System.out.print(character);
                } else { // hollow part
                    System.out.print(" ");
                }
            }
            System.out.println();
        } 
    }

    public static void printHollowCircle(int size, char character) {
        int diameter = size * 2;

        for (int x = 0; x <= diameter; x++) { // rows
            for (int y = 0; y <= diameter; y++) { // columns
                double distance = Math.sqrt((x - size) * (x - size) + (y - size) * (y - size));

                if (distance > size - 0.5 && distance < size + 0.5) { // check if distance is within (radius - 0.5) and (radius + 0.5)
                    System.out.print(character);
                } else { // hollow part
                    System.out.print(" ");
                }
            }
            System.out.println();
        } 
    }

    public static void printHollowTriangle(int size, char character) {
        for (int x = 1; x <= size; x++) { // rows
            for (int y = 1; y <= x; y++) { // columns
                if (y == 1 || y == x || x == size) {
                    System.out.print(character);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

/*
Write a method that outputs a hollow square. It must take the length of a side (Integer) and the
character to draw the square with (Character). The method must output a hollow square of height
“length” using the given character. You must use a method to do this – if you write the code in main,
you will not receive credit.

Enter Height: 5
Enter Character: o
ooooo
o   o
o   o
o   o
ooooo
*/
