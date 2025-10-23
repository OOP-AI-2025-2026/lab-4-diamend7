package ua.opnu.inheritance.bill; // Тот же пакет

/**
 * Моделирует чек со скидкой для постоянных клиентов.
 * Реализовано с помощью КОМПОЗИЦИИ (содержит внутри GroceryBill).
 */
public class DiscountBill2 {

    // 1. Композиция: класс "имеет" GroceryBill, а не "является" им
    private GroceryBill bill; 

    // Те же поля для отслеживания скидок, что и в Задании 1
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    /**
     * Конструктор
     * @param clerk Кассир
     * @param regularCustomer Является ли клиент постоянным
     */
    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        // 2. Создаем внутренний объект GroceryBill
        this.bill = new GroceryBill(clerk); 
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    /**
     * Добавляет товар.
     * Мы делегируем добавление внутреннему чеку, а затем
     * обновляем нашу собственную логику скидок.
     */
    public void add(Item i) {
        // 3. Делегируем вызов внутреннему объекту bill
        this.bill.add(i); 
        
        if (this.regularCustomer && i.getDiscount() > 0) {
            this.discountCount++;
            this.discountAmount += i.getDiscount();
        }
    }

    /**
     * Получает общую сумму.
     * Мы делегируем расчет полной цены внутреннему чеку,
     * а затем применяем нашу логику скидки.
     */
    public double getTotal() {
        // 3. Делегируем вызов
        double fullPrice = this.bill.getTotal(); 
        
        if (this.regularCustomer) {
            return fullPrice - this.discountAmount;
        } else {
            return fullPrice;
        }
    }
    
    // --- "Пробрасываем" (делегируем) остальные методы ---
    // Чтобы наш класс был похож на GroceryBill, мы должны 
    // предоставить те же методы, что и у него.

    /**
     * Возвращает кассира, делегируя вызов внутреннему чеку.
     */
    public Employee getClerk() {
        // 3. Делегируем вызов
        return this.bill.getClerk();
    }


    // --- Новые методы (полностью идентичны Заданию 1) ---

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
        // 3. Делегируем получение полной цены
        double fullPrice = this.bill.getTotal(); 
        if (!this.regularCustomer || fullPrice == 0) {
            return 0.0;
        }
        
        // getTotal() вызовет наш собственный метод getTotal()
        double discountedPrice = this.getTotal(); 
        return 100.0 - (discountedPrice * 100.0) / fullPrice;
    }
}