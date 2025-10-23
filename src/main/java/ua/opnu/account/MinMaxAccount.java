package ua.opnu.account;

public class MinMaxAccount extends BankingAccount {

  private int min;
  private int max;

  public MinMaxAccount(Startup s) {
    super(s);
    this.min = getBalance();
    this.max = getBalance();
  }

  public int getMin() {
    return min;
  }

  public int getMax() {
    return max;
  }

  @Override
  public void debit(Debit d) {
    super.debit(d);
    if (getBalance() > max) {
      this.max = getBalance();
    }
  }

  @Override
  public void credit(Credit c) {
    super.credit(c);
    if (getBalance() < min) {
      this.min = getBalance();
    }
  }
}