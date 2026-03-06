import java.util.Scanner;
import java.text.DecimalFormat;

public class HW1_SphereVolume {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the radius of the sphere: ");

    // Check for valid radius input else reprompt
    while (!input.hasNextDouble()) {
      System.out.println("Invalid input. Please enter a number.");
      input.next();
    }
    double radius = input.nextDouble();
    input.close();

    float c = 4.0f / 3.0f; // constant for volume calculation  (4/3)
    double exactResult = c * Math.PI * Math.pow(radius, 3); // exact result of volume calculation (4/3) * pi * r^3
    DecimalFormat df = new DecimalFormat("0.00"); // format the result to two decimal places
    System.out.println("The volume of the sphere is " + df.format(exactResult)); // print the result
  }
}
