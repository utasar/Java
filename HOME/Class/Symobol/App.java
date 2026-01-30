import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Class 3 Codes goes here
        Scanner scnr=new Scanner(System.in);// take user input from keyword
        System.out.println("Enter your age so that I can determine your birthyear:");// User Prumpt
        // String age=scnr.next();
        // int ageAsInteger =Integer.parseInt(age);
        //above commented codes can be replaced by nextInt
        int ageAsInteger=scnr.nextInt();
        int birthYear=2024-ageAsInteger; //typecasting string to int
        System.out.println("Your birthyear is "+birthYear);
        scnr.close();
    }
}
