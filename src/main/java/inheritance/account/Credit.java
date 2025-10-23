package ua.opnu.java.inheritance.bill;

public class Credit {
  private int balance;

  public Credit(int balance) {
    setBalance(balance);
  }

  public int getBalance() {
    return balance;
  }

  private void setBalance(int balance) {
    this.balance = balance;
  }
}