package ua.opnu.inheritance.bill;

/** Item with price and absolute discount in currency units. */
public class Item {
    private final String name;
    private final double price;
    private final double discount; // absolute discount in same currency as price

    public Item(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    /** Full price without discount. */
    public double getPrice() {
        return price;
    }

    /** Absolute discount amount (>= 0). */
    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return name + " (" + price + ", -" + discount + ")";
    }
}
