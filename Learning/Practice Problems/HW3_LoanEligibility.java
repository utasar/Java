import java.util.Scanner;

public class HW3_LoanEligibility {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt for loan amount and check for valid input else reprompt
    System.out.println("What is the loan amount?");
    while (!input.hasNextDouble()) {
      System.out.println("Invalid input. Please enter a number.");
      input.next();
    }
    double loanAmount = input.nextDouble();

    // Prompt for down payment and check for valid input else reprompt
    System.out.println("What is the down payment?");
    while (!input.hasNextDouble()) {
      System.out.println("Invalid input. Please enter a number.");
      input.next();
    }
    double downPayment = input.nextDouble();

    // Prompt for job length and check for valid input else reprompt
    System.out.println("Have you held your current job for at least a year?");
    String yesNo = input.next();
    while (!yesNo.toLowerCase().equals("yes") && !yesNo.toLowerCase().equals("no")) {
      System.out.println("Invalid input. Enter yes or no.");
      yesNo = input.next();
    }

    // Prompt for annual salary and check for valid input else reprompt
    System.out.println("What is your annual salary?");
    while (!input.hasNextDouble()) {
      System.out.println("Invalid input. Please enter a number.");
      input.next();
    }
    double annualSalary = input.nextDouble();
    input.close();

    // Calculate loan eligibility
    if (downPayment >= 0.2 * loanAmount || (yesNo.equals("yes") && annualSalary >= 0.5 * loanAmount))
      System.out.println("You are eligible for this loan.");
    else {
      System.out.println("You are not eligible for this loan.");
    }
  }
}
