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
     * Переопределяет debit(int) с возвращаемым типом boolean.
     * Возвращает результат операции родительского класса.
     */
    @Override
    public boolean debit(int amount) { // ИЗМЕНЕН ВОЗВРАЩАЕМЫЙ ТИП НА boolean
        boolean success = super.debit(amount); // Вызываем родительский метод
        
        // Обновляем min/max только если операция была успешной
        if (success) {
            updateMinMax();      
        }
        return success; // Возвращаем результат
    }

    /**
     * Переопределяет credit(int) с возвращаемым типом boolean (предположительно).
     * Если credit в родителе возвращает void, вам придется изменить этот метод.
     */
   @Override
    public void credit(int amount) { // ИЗМЕНЕН ВОЗВРАЩАЕМЫЙ ТИП НА void
        super.credit(amount); // Вызываем родительский метод
        updateMinMax();       // Обновляем min/max после успешной операции
        // Нет возврата, т.к. родительский метод - void.
    }

    // --- Новые методы ---

    public int getMin() {
        return this.minBalance;
    }

    public int getMax() {
        return this.maxBalance;
    }
}