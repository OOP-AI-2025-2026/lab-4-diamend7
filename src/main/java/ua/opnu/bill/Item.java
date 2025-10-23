package ua.opnu.bill;

public class Item {

  private double price, discount;
  private String name;

  public Item(String name, double price, double discount) {
    setPrice(price);
    setDiscount(discount);
    setName(name);
  }

  private void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  private void setPrice(double price) {
    this.price = price;
  }

  public double getDiscount() {
    return discount;
  }

  private void setDiscount(double discount) {
    this.discount = discount;
  }
}