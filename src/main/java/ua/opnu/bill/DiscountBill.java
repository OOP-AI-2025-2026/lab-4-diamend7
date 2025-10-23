package ua.opnu.bill;

import java.math.BigDecimal;
import java.util.ArrayList;


public class DiscountBill extends GroceryBill {

    private boolean regularCustomer;
    private ArrayList<Item> itemList = getItems(); // изменил имя

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    public double getTotal() {
        double total;
        if (!regularCustomer)
            total = super.getTotal();
        else
            total = super.getTotal() - getDiscountAmount();

        total = Math.round(total * 100.0) / 100.0;
        return total;
    }

    public int getDiscountCount() {
        int cnt = 0;
        for (Item it : itemList)
            if (it.getDiscount() > 0 && regularCustomer)
                cnt++;
        return cnt;
    }

    public double getDiscountAmount() {
        double amt = 0;
        for (Item it : itemList)
            if (it.getDiscount() > 0 && regularCustomer)
                amt += it.getDiscount();
        return amt;
    }

    public double getDiscountPercent() {
        double discount = 100 - ((getTotal() * 100) / super.getTotal());
        BigDecimal bd = new BigDecimal(Double.toString(discount));
        bd = bd.setScale(13, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
}