import java.util.Scanner;

public class PrintX {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        System.out.print("What is the value of n?");
        int valueN = scnr.nextInt();
        if ((valueN<3)||(valueN%2==0))
        {
            System.out.println("n must be an odd number greater than 3");
        } 
        else
        {
            
            for(int i=0;i<valueN;i++)
                {
                    for (int j=0; j<valueN; j++)
                        {
                            if ((j==i)||(i==(valueN-j-1)))
                            System.out.print("*");
                            else
                            System.out.print(" ");
                        }
                    System.out.println("");

                }
            
        }
        scnr.nextLine();

    }
}
