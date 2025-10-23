package ua.opnu.java.inheritance.bill; // Тот же пакет, что и у родителя

/**
 * Расширяет GroceryBill, добавляя логику скидок для постоянных клиентов.
 * Реализовано с помощью НАСЛЕДОВАНИЯ.
 */
public class DiscountBill extends GroceryBill {

    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount; // Общая сумма скидки в гривнах

    /**
     * Конструктор
     * @param clerk Кассир
     * @param regularCustomer Является ли клиент постоянным
     */
    public DiscountBill(Employee clerk, boolean regularCustomer) {
        // 1. Вызываем конструктор родительского класса
        super(clerk); 
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    /**
     * Переопределенный метод добавления товара.
     * Добавляет товар (через родительский метод) и обновляет 
     * счетчики скидок, если клиент постоянный.
     */
    @Override
    public void add(Item i) {
        // 2. Пусть родительский класс сначала добавит товар
        super.add(i); 
        
        // 3. Добавляем свою логику
        if (this.regularCustomer && i.getDiscount() > 0) {
            this.discountCount++;
            this.discountAmount += i.getDiscount();
        }
    }

    /**
     * Переопределенный метод получения общей суммы.
     * Возвращает полную сумму (от родителя) минус накопленная скидка.
     */
    @Override
    public double getTotal() {
        // 4. Получаем полную цену от родителя
        double fullPrice = super.getTotal(); 
        
        if (this.regularCustomer) {
            return fullPrice - this.discountAmount;
        } else {
            return fullPrice;
        }
    }

    // --- Новые методы ---

    /**
     * Возвращает количество товаров со скидкой.
     */
    public int getDiscountCount() {
        return this.regularCustomer ? this.discountCount : 0;
    }

    /**
     * Возвращает общую сумму скидки в гривнах.
     */
    public double getDiscountAmount() {
        return this.regularCustomer ? this.discountAmount : 0.0;
    }

    /**
     * Возвращает процент скидки (на сколько % покупатель заплатил меньше).
     */
    public double getDiscountPercent() {
        double fullPrice = super.getTotal();
        if (!this.regularCustomer || fullPrice == 0) {
            return 0.0;
        }
        
        double discountedPrice = getTotal(); // Наша цена со скидкой
        // Формула из задания: 100 - (цена со скидкой * 100) / полная цена
        return 100.0 - (discountedPrice * 100.0) / fullPrice;
    }
}