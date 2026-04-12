package Bank;

import java.util.*;

public class Driver {
    private static Scanner input = new Scanner(System.in);

    public static void displayAccountsByNumber(ArrayList<BankAccount> accountList) {
        Collections.sort(accountList);
        for (BankAccount a : accountList) {
            System.out.println(a);
        }
    }

    public static void displayAccountsByBalance(ArrayList<BankAccount> accountList) {
        Collections.sort(accountList, new AccountComparator());
        for (BankAccount a: accountList) {
            System.out.println(a);
        }
    }

    public static BankAccount newCustomer() {
        System.out.print("Name: ");
        String firstName = input.next();
        String lastName = input.next();

        System.out.print("Account Number: ");
        String accountNumber = input.next();

        System.out.print("Balance: ");
        double balance = input.nextDouble();

        double interestRate = 0.0012;
        BankAccount c = new CheckingAccount (firstName, lastName, accountNumber, 
                                         balance, interestRate, 30.00);
        return c;
    }

    public static int getMenuOption() {
        System.out.println("1. New Customer");
        System.out.println("2. Get Balance");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Apply Interest");
        System.out.println("6. List Accounts by Account Number");
        System.out.println("7. List Accounts by Balance");
        System.out.println("8. Quit");
        System.out.print("What do you want to do? ");
        return input.nextInt();
    }

    public static void main(String[] args) {
        ArrayList<BankAccount> accountList = new ArrayList<>();
        
        while (true) {
            int choice = getMenuOption();

            switch (choice) {
                case 1: accountList.add(newCustomer());
                        break;
                // case 2: getBalance();
                //         break;
                // case 3: deposit();
                //         break;
                // case 4: withdraw();
                //         break;
                // case 5: applyInterest();
                //         break;
                case 6: displayAccountsByNumber(accountList);
                        break;
                case 7: displayAccountsByBalance(accountList);
                        break;
                case 8: return; // Quit
            }
        }
    }
}
