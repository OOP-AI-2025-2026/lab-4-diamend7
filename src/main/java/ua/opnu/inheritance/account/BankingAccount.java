package ua.opnu.inheritance.account;
/** Simple banking account that tracks balance in cents. */
public class BankingAccount {
    private int balance; // cents

    public BankingAccount(Startup s) {
        this.balance = s.getInitialBalanceCents();
    }

    /** Deposit (always increases balance). */
    public void credit(int cents) {
        if (cents < 0) {
            throw new IllegalArgumentException("cents must be >= 0");
        }
        balance += cents;
    }

    /**
     * Withdraw if enough funds.
     * @return true if success, false otherwise
     */
    public boolean debit(int cents) {
        if (cents < 0) {
            throw new IllegalArgumentException("cents must be >= 0");
        }
        if (balance >= cents) {
            balance -= cents;
            return true;
        }
        return false;
    }

    /** Current balance in cents. */
    public int getBalance() {
        return balance;
    }
}
