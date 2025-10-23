package ua.opnu.java.inheritance.account; // Тот же пакет, что и у родителя

/**
 * Расширяет BankingAccount, добавляя отслеживание
 * минимального и максимального баланса.
 */
public class MinMaxAccount extends BankingAccount {

    // 1. Новые поля для отслеживания min/max
    private int minBalance;
    private int maxBalance;

    /**
     * Конструктор
     * @param s Объект с информацией о стартовом балансе
     */
    public MinMaxAccount(Startup s) {
        // 2. Вызываем конструктор родителя
        super(s); 
        
        // 3. Получаем стартовый баланс, установленный родителем,
        //    и инициализируем им min/max
        int initialBalance = super.getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    /**
     * Вспомогательный приватный метод для обновления min/max
     * после каждой операции.
     */
    private void updateMinMax() {
        int currentBalance = super.getBalance();
        if (currentBalance < this.minBalance) {
            this.minBalance = currentBalance;
        }
        if (currentBalance > this.maxBalance) {
            this.maxBalance = currentBalance;
        }
    }

    // --- Переопределение методов, меняющих баланс ---

    /**
     * Переопределяет метод debit.
     * Сначала выполняет операцию, затем обновляет min/max.
     */
    @Override
    public void debit(Debit d) {
        super.debit(d); // 4. Сначала пусть родитель выполнит операцию
        updateMinMax();   // 5. Затем проверяем новый баланс
    }

    /**
     * Переопределяет метод credit.
     * Сначала выполняет операцию, затем обновляет min/max.
     */
    @Override
    public void credit(Credit c) {
        super.credit(c); // 4. Сначала пусть родитель выполнит операцию
        updateMinMax();    // 5. Затем проверяем новый баланс
    }

    // --- Новые методы ---

    /**
     * Возвращает минимальное значение баланса
     */
    public int getMin() {
        return this.minBalance;
    }

    /**
     * Возвращает максимальное значение баланса
     */
    public int getMax() {
        return this.maxBalance;
    }
}