package Bank;

abstract class BankAccount implements Comparable<BankAccount> {
    private String firstName;
    private String lastName;
    private final String accountNumber;
    private double balance;
    private double interestRate;

    BankAccount(String firstName, String lastName, String accountNumber, 
                double balance, double interestRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        double temp = balance - amount;
        if (temp < 0) {
            return false;
        } else {
            balance = temp;
            return true;
        }
    }

    public void applyInterest() {
        balance += (1 + interestRate);
        balance = Math.floor(balance * 100) / 100;
    }

    public abstract String getAccountType();

    public String toString() {
        return accountNumber + ": ($" + balance + ")";
    }

    public int compareTo(BankAccount o) {
        if (this.balance > o.balance) {
            return -1;
        } else if (this.balance < o.balance) {
            return 1;
        } else {
            return this.accountNumber.compareTo(o.accountNumber);
        }
    }

    // Setters and getters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate >= 0 && interestRate <= 1) {
            this.interestRate = interestRate;
        }
    }

    public double getInterestRate() {
        return interestRate;
    }
}
