package ua.opnu.java.inheritance.bill;

public class Debit {

  private int balance;

  public Debit(int balance) {
    setBalance(balance);
  }

  public int getBalance() {
    return balance;
  }

  private void setBalance(int balance) {
    this.balance = balance;
  }
}