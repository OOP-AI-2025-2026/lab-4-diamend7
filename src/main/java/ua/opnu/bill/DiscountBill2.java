package ua.opnu.bill;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DiscountBill2 {

  GroceryBill bill;
  private boolean regularCustomer;

  public DiscountBill2(Employee clerk, boolean regularCustomer) {
    this.bill = new GroceryBill(clerk);
    this.regularCustomer = regularCustomer;
  }

  public int getDiscountCount() {
    int count = 0;
    ArrayList<Item> items = bill.getItems();

    for (Item item : items) {
      if (item.getDiscount() > 0 && regularCustomer) {
        count++;
      }
    }
    return count;
  }

  public double getDiscountAmount() {
    double amount = 0;
    ArrayList<Item> items = bill.getItems();
    for (Item item : items) {
        if (item.getDiscount() > 0 && regularCustomer)
      amount += item.getDiscount();
    }
    return amount;
  }

  public double getTotal() {
      double total;
      if (!regularCustomer)
          total = bill.getTotal();
      else
          total = bill.getTotal() - getDiscountAmount();

      total = Math.round(total * 100.0) / 100.0;
      return total;
  }

  public double getDiscountPercent() {
      double discount = 100 - ((getTotal() * 100) / bill.getTotal());
      BigDecimal bd = new BigDecimal(Double.toString(discount));
      bd = bd.setScale(13, BigDecimal.ROUND_HALF_UP);
      return bd.doubleValue();
  }

  public Employee getClerk() {
    return bill.getClerk();
  }

  public void add(Item i) {
    bill.add(i);
  }

  public ArrayList<Item> getItems() {
    return bill.getItems();
  }
}