package ua.opnu.inheritance.account;

/**
 * Расширяет BankingAccount, добавляя отслеживание
 * минимального и максимального баланса.
 */
public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    /**
     * Конструктор
     */
    public MinMaxAccount(Startup s) {
        super(s); 
        
        int initialBalance = super.getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    /**
     * Вспомогательный приватный метод для обновления min/max.
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

    // --- ИСПРАВЛЕННЫЕ ПЕРЕОПРЕДЕЛЕННЫЕ МЕТОДЫ ---

    /**
     * Переопределяет РЕАЛЬНЫЙ метод родителя, который принимает int.
     */
    @Override
    public void debit(int amount) { 
        super.debit(amount); // Вызываем родительский метод с числом
        updateMinMax();      // Обновляем min/max
    }

    /**
     * Переопределяет РЕАЛЬНЫЙ метод родителя, который принимает int.
     */
    @Override
    public void credit(int amount) { 
        super.credit(amount); // Вызываем родительский метод с числом
        updateMinMax();       // Обновляем min/max
    }

    // --- Новые методы ---

    public int getMin() {
        return this.minBalance;
    }

    public int getMax() {
        return this.maxBalance;
    }
}