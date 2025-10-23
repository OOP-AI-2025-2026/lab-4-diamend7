package ua.opnu.bill;

public class DiscountBill extends GroceryBill {

    private final boolean regularCustomer;
    private int discountCount = 0;
    private double discountAmount = 0.0;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if (regularCustomer && i.getDiscount() > 0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double full = super.getTotal();
        return regularCustomer ? (full - discountAmount) : full;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        double full = super.getTotal();
        if (!regularCustomer || full == 0) return 0.0;
        double withDiscount = full - discountAmount;
        return 100.0 - (withDiscount * 100.0) / full;
    }
}
