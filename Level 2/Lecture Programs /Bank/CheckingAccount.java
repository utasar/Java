package Bank;

class CheckingAccount extends BankAccount {
    private double overdraftFee;

    CheckingAccount(String firstName, String lastName, String 
                    accountNumber, double balance, double 
                    interestRate, double overdraftFee) {
        super(firstName, lastName, accountNumber, balance,
              interestRate);
        this.overdraftFee = overdraftFee;
    }

    public boolean withdraw(double amount) {
        boolean success = super.withdraw(amount);
        if (!success) {
            super.setBalance(super.getBalance() - amount - overdraftFee); 
        }
        return true;
    }

    public String toString() {
            return "Checking: " + super.toString();
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }
}
