package ua.opnu.java.inheritance.bill;

/**
 * MinMaxAccount extends BankingAccount and tracks minimum and maximum balance.
 */
public class MinMaxAccount extends BankingAccount {

    private int min;
    private int max;

    public MinMaxAccount(Startup s) {
        super(s);
        int b = getBalance();
        this.min = b;
        this.max = b;
    }

    @Override
    public void credit(int cents) {
        super.credit(cents);
        updateMinMax();
    }

    @Override
    public boolean debit(int cents) {
        boolean ok = super.debit(cents);
        updateMinMax();
        return ok;
    }

    private void updateMinMax() {
        int b = getBalance();
        if (b < min) {
            min = b;
        }
        if (b > max) {
            max = b;
        }
    }

    public int getMin() { return min; }

    public int getMax() { return max; }
}
