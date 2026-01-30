import java.util.Scanner;

public class UpToHundred {
    public static void main(String[] args) throws Exception {
        //problem was to solve the problem with using conditionals and loop. But there is no use of conditionals for solving this

        Scanner scnr = new Scanner(System.in);
        int sumInt = 0;
        int iteration =0;
        while (sumInt <100) // before or reaches 100
        {
            System.out.print("Enter a number: ");
            sumInt = sumInt + scnr.nextInt();
            iteration++;
        }
        System.out.printf("You entered %d values before the total was greater than 100. \n",iteration-1);
        scnr.close();
    }
}
