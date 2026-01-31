import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter the number of iteration for whille loop:");
        int noOfIterations = scnr.nextInt(); // blocking methods
        //while loop
        //initia expression for while-loop
        int i =0;
        while (i<noOfIterations) {// condition expression i=0, noOfIterations = 5
            System.out.println("This is the value of i in each iteration "+i);
            i++;
        }
        for(int j = 0; j < noOfIterations; j++ ){
            System.out.println("This is the value of i in each iteration "+j);
        }
       scnr.close();
    }
}
