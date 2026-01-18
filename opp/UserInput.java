import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        //To take input import Scanner class at the top of the file
        //import java.util.scanner;
        //make an object of the scanner and take input from object 
        Scanner scan = new Scanner(System.in);
        System.out.println("Your age:");
        int ageInput = scan.nextInt();
        System.out.println("You are" +ageInput);

        System.out.println("over age?");
        boolean over18Input =scan.nextBoolean();

        System.out.println("Your weight:");
        double weightInput = scan.nextDouble();

        //After using scanner for primitive data and want input for string 
        //you need to clear the enter input
        scan.next();
        System.out.println("Your name?");
        String name =scan.nextLine();
        scan.close(); //must close scanner object to avoid input locks
    }
}
