import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
           Scanner scnr = new Scanner(System.in);
           int noOfFriends;
            int[] arrayName=  new int[6];// This is the way we put the array value
           arrayName[0] = 20; // array assignment
           arrayName[1] = 10; // array assignment
           // it can be declared like:
           int [] arrayName1 = {1,2,8,4,6,3};


            System.out.println("Enter no of best friends");
            noOfFriends = scnr.nextInt();
            
                String [] bestFriend = new String[noOfFriends];// declaration for storing 3 variables
           for(int arrayIndex=0; arrayIndex<bestFriend.length+1; arrayIndex++)
           {
            System.out.println("Enter your Friend "+arrayIndex+":");
            bestFriend[arrayIndex]=scnr.next();
           }

         scnr.close();
    }
}
