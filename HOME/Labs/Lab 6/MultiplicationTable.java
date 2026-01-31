/*
 * @author: Utsav Acharya
 * @version 1.0.0 2026
 */
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) throws Exception 
        {
            Scanner scnr = new Scanner(System.in);
            System.out.print("What is the value of n?");
            int inputNum = scnr.nextInt();
            if (verifyNum(inputNum))
                {//if true goes here
                    printTable(inputNum);

                }
            else
                {//false goes here
                System.out.println("n must be between 0 and 50");                    
                }
            scnr.close();;
        }
    /*
     * Method printTable to display the multiplication table from 1 to n-number by user
     * @param integer n as parameter for method printTable
     * @return void since the operation and output will be printed within the
     */
    public static void printTable(int n)
        {
            for(int i=1; i<=n; i++)
                {
                    for(int j=1;j<=n;j++)
                    {
                        System.out.printf("%d\t",i*j);
                    }
                    System.out.println("");
                    
                }
        }
    /*
     * Method verifyNum takes integer as arguement and returns true if it is greater than 0 & less than 50
     * @param integer n as parameter type integer
     * @return boolean to return true if it is greater than 0 and less than 50
     */
    public static boolean verifyNum(int n)
        {
            
            if ((n>0)&&(n<50))
            {
              return true;
            }
            else
                return false;
        }
}
