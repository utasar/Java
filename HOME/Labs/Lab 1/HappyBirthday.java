
import java.util.Scanner;
public class HappyBirthday {
    public static void main(String[] args) throws Exception 
    {
        System.out.println("When were you born?");//input the birthday in format given
        Scanner scnr= new Scanner(System.in);
        String birthDay=scnr.nextLine(); // to take user input 

        String[] dOB = birthDay.split(" "); // split all the words separated by white space
        //Way 1
        /* 
        int bornDay = Integer.parseInt(dOB[0]); // to convert second word to integer
        String bornMonth = dOB[1]; // Assign month section to month
        int bornYear = Integer.parseInt(dOB[2]); // to convert third word to integer for year
        
            System.out.println("Day: "+bornDay);
            System.out.println("Month: "+bornMonth);
            System.out.println("Year:"+bornYear);
        */
        //Way 2
        // int bornDay=scnr.nextInt();
        // String bornMonth=scnr.nextLine();
        // int bornYear=scnr.nextInt();
        // System.out.println("Day:"+bornDay);
        // System.out.println("Month:"+bornMonth);
        // System.out.println("Year:"+bornYear);

        System.out.println("Day: "+dOB[0]);
            System.out.println("Month: "+dOB[1]);
            System.out.println("Year:"+dOB[2]);

    }
}
