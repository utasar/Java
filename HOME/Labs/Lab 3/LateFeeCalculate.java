import java.util.Scanner;

public class LateFeeCalculate {
    public static void main(String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        double lateFee = 0;
        System.out.print("Enter number of days late: ");// Ask first question
        int noDaysLate = scnr.nextInt();
        System.out.print("Are you a library VIP (yes / no)? ");// go to next line to ask if student is VIP
        String libraryVIP = scnr.next();
        if (libraryVIP.equals("no")) 
        {
            if (noDaysLate <= 5)
            {
                lateFee = 1.00;
            }
            else if ((noDaysLate>=6)&&(noDaysLate<=10))
            {
                lateFee = 5.00;
            }
            else
            {
                lateFee = 10.00;
            }  
        }
        else if (libraryVIP.equals("yes")) 
        {
            if (noDaysLate <= 5)
            {
                lateFee = 0.50;
            }
            else if ((noDaysLate>=6)&&(noDaysLate<=10))
            {
                lateFee = 2.50;
            }
            else
            {
                lateFee = 5.00;
            }
        }
        else
        {
            System.out.println("Invalid Entry"); // it is written for detecting mistake on typing strings
        }
        System.out.printf("Late fine is %.2f for %d days late\n",lateFee,noDaysLate);
        scnr.close();;

    }
}
