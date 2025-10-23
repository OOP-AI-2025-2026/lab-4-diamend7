package ua.opnu.account;

public class BankingAccount {

  private int balance;

  public BankingAccount(Startup s) {
    setBalance(s);
  }

  private void setBalance(Startup s) {
    this.balance = s.getBalance();
  }

  public void debit(Debit d) {
    balance = balance + d.getBalance();
  }

  public void credit(Credit c) {
    balance = balance + c.getBalance();
  }

  public int getBalance() {
    return balance;
  }

  @Override
  public boolean equals(Object o) {

    BankingAccount other = (BankingAccount) o;
    return Double.compare(this.balance, other.balance) == 0;
  }

  @Override
  public String toString() {
    return " Balance: " + balance + "\n";
  }
}