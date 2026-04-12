package Bank;

class Polymorphism {
    public static void main(String[] args) {
        CheckingAccount check = new CheckingAccount("Michelle", 
                "Cheatham", "12345", 1200.00, 0.012, 20.00);
        SavingsAccount savings = new SavingsAccount("Michelle", 
                "Cheatham", "22222", 12000.00, 0.024, 3, 0);

        BankAccount activeAccount = check;
        System.out.println(activeAccount.toString());
        activeAccount = savings;
        System.out.println(activeAccount.toString());
        if (activeAccount instanceof SavingsAccount) {
            System.out.println(
                ((SavingsAccount) activeAccount).getNumWithdraws());
        }
    }
}
