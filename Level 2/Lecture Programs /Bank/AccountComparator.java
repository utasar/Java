package Bank;

import java.util.Comparator;

class AccountComparator implements Comparator<BankAccount> {
    public int compare(BankAccount o1, BankAccount o2) {
        if (o1.getBalance() > o2.getBalance()) {
            return -1;
        } else if (o1.getBalance() < o2.getBalance()) {
            return 1;
        } else {
            return 0;
        }
    }
}
