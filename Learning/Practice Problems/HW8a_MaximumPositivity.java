import java.util.*;

public class HW8a_MaximumPositivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = 0;

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("Enter row (+/-): ");
            String temp = input.next();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = temp.charAt(0);
            }
        }
        input.close();

        System.out.println("Output Matrix: " + matrix.length + " rows and " + matrix[0].length + " columns: ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '+') {
                    sum++;
                } 
            }
            if (sum > max) {
                max = sum;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == '+') {
                    sum++;
                } 
            }
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println('\n' + "The max is " + max);
    }
}

/*
For this problem you will read in the number of rows and columns in a two-dimensional array, followed
by a two-dimensional array of characters of that size. Each value in the array will be either a plus sign (+)
or a minus sign (-). Your task is to output the maximum number of plus signs in any row or column.

Hint: To read in a single character, you can use the Scanner’s next method and then get the first
character, as shown here:

Scanner in = new Scanner(System.in);
String temp = in.next();
char c = temp.charAt(0);

Example

If the input is:

10
10
+ - - - + - - - - -
- - + - - - + + - +
+ + - - - - - + + -
+ - - + - + - + - +
- - - + - - + - - +
+ + + - + - - + + -
- - + + - - + + - +
+ + - - + + - - - -
- + + - - + - + - +
- + + + - - - - - -

The output would be:

6
 */
