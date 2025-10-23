package ua.opnu.bill;

import java.util.List;

/**
 * DiscountBill2 uses composition: wraps a GroceryBill and adds discount logic.
 */
public class DiscountBill2 {
    private final GroceryBill bill;
    private final boolean regularCustomer;
    private int discountCount = 0;
    private double discountAmount = 0.0;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(Item i) {
        bill.add(i);
        if (regularCustomer && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    public double getTotal() {
        double full = bill.getTotal();
        return regularCustomer ? (full - discountAmount) : full;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        double full = bill.getTotal();
        if (!regularCustomer || full == 0.0) {
            return 0.0;
        }
        double withDiscount = full - discountAmount;
        return 100.0 - (withDiscount * 100.0) / full;
    }

    // Delegates (may be used by tests)
    public Employee getClerk() { return bill.getClerk(); }
    public List<Item> getItems() { return bill.getItems(); }
}
