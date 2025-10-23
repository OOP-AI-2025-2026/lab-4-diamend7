package ua.opnu.account;

public class MinMaxAccount extends BankingAccount {

    private int min;
    private int max;

    public MinMaxAccount(Startup s) {
        super(s);
        int balance = getBalance();  // баланс після super()
        this.min = balance;
        this.max = balance;
    }

    @Override
    public void credit(int cents) {
        super.credit(cents);
        updateMinMax();
    }

    @Override
    public boolean debit(int cents) {
        boolean result = super.debit(cents);
        updateMinMax();
        return result;
    }

    private void updateMinMax() {
        int balance = getBalance();
        if (balance < min) min = balance;
        if (balance > max) max = balance;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
