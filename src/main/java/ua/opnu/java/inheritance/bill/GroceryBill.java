package ua.opnu.java.inheritance.bill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Base bill: stores items and sums full prices (no discounts). */
public class GroceryBill {
    private final Employee clerk;
    private final List<Item> items = new ArrayList<>();

    public GroceryBill(Employee clerk) {
        this.clerk = clerk;
    }

    public void add(Item i) {
        items.add(i);
    }

    /** Total as sum of full item prices (no discounts here). */
    public double getTotal() {
        double sum = 0.0;
        for (Item i : items) {
            sum += i.getPrice();
        }
        return sum;
    }

    public Employee getClerk() {
        return clerk;
    }

    /** Expose list for tests/derived classes. */
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
