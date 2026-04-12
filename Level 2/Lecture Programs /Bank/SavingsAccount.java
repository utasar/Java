package Bank;

class SavingsAccount extends BankAccount {
    private double maxWithdrawals;
    private double numWithdraws;

    SavingsAccount(String firstName, String lastName, 
                   String accountNumber, double balance, double interestRate,
                   double maxWithdrawals, double numWithdraws) {
        super(firstName, lastName, accountNumber, balance,
              interestRate);
        this.maxWithdrawals = maxWithdrawals;
        this.numWithdraws = numWithdraws;
    }

    public boolean withdraw(double amount) {
        if (numWithdraws < maxWithdrawals) {
            boolean success = super.withdraw(amount);
            if (success) {
                numWithdraws++;
            }
            return success; 
        } else {
            return false;
        }
    }

    public String toString() {
        return "Savings: " + super.toString();
    }

    public double getNumWithdraws() {
        return numWithdraws;
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
