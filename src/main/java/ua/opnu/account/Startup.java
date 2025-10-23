package ua.opnu.account;

/** Startup: provides initial balance for BankingAccount (in cents). */
public class Startup {
    private final int initialBalanceCents;

    public Startup(int initialBalanceCents) {
        this.initialBalanceCents = initialBalanceCents;
    }

    public int getInitialBalanceCents() {
        return initialBalanceCents;
    }
}
