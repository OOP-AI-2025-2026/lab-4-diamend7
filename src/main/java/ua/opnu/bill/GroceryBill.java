package ua.opnu.bill;

import java.util.ArrayList;

public class GroceryBill {

  private Employee clerk;
  private ArrayList<Item> items;

  GroceryBill(Employee clerk) {
    setClerk(clerk);
    this.items = new ArrayList<>();

  }

  public Employee getClerk() {
    return clerk;
  }

  private void setClerk(Employee clerk) {
    this.clerk = clerk;
  }

  public void add(Item i) {
    items.add(i);
  }

  public double getTotal() {
    double total = 0;
    for (Item item : items) {
      total += item.getPrice();
    }
    return total;
  }

  public ArrayList<Item> getItems() {
    return items;
  }
}