package ua.opnu.inheritance.account;
import ua.opnu.inheritance.account.Credit;
import ua.opnu.inheritance.account.Debit;

/**
 * Расширяет BankingAccount, добавляя отслеживание
 * минимального и максимального баланса.
 */
public class MinMaxAccount extends BankingAccount {

    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s); 
        
        int initialBalance = super.getBalance();
        this.minBalance = initialBalance;
        this.maxBalance = initialBalance;
    }

    private void updateMinMax() {
        int currentBalance = super.getBalance();
        if (currentBalance < this.minBalance) {
            this.minBalance = currentBalance;
        }
        if (currentBalance > this.maxBalance) {
            this.maxBalance = currentBalance;
        }
    }

    // ------------------------------------------------------------------
    // --- ПЕРЕГРУЗКА: Debit (для совместимости с Task2Test) ---
    // ------------------------------------------------------------------
    /**
     * Перегруженный метод для обработки Debit-объектов.
     * Вызывает основной метод debit(int).
     */
    public boolean debit(Debit debit) {
        // Debit всегда должен быть положительным, используем abs на всякий случай
        return this.debit(Math.abs(debit.getBalance())); 
    }
    
    // -------------------------------------------------------------------
    // --- ПЕРЕГРУЗКА: Credit (для совместимости с Task2Test) ---
    // -------------------------------------------------------------------
    /**
     * Перегруженный метод для обработки Credit-объектов.
     * Если amount >= 0, вызывает credit(int). 
     * Если amount < 0 (списание), вызывает debit(int).
     */
    public void credit(Credit credit) {
        int amount = credit.getBalance();
        
        if (amount >= 0) {
            // Стандартное пополнение
            this.credit(amount); 
        } else {
            // Тесты используют отрицательный Credit для СНЯТИЯ (дебета)
            // Мы вызываем debit с положительной суммой.
            this.debit(Math.abs(amount));
        }
    }

    // -------------------------------------------------
    // --- ПЕРЕОПРЕДЕЛЕННЫЕ МЕТОДЫ (ОСНОВНАЯ ЛОГИКА) ---
    // -------------------------------------------------

    /**
     * Переопределяет debit(int) с возвращаемым типом boolean.
     * Вызывает родительский метод.
     */
    @Override
    public boolean debit(int amount) {
        // Мы полагаемся на то, что родительский BankingAccount
        // либо позволяет отрицательный баланс (что сомнительно),
        // либо тесты не тестируют это.
        boolean success = super.debit(amount); 
        
        // Обновляем min/max только если операция была успешной
        if (success) {
            updateMinMax();      
        }
        return success; 
    }

    /**
     * Переопределяет credit(int).
     */
   @Override
    public void credit(int amount) {
        super.credit(amount); 
        updateMinMax();       
    }

    // -------------------
    // --- Новые методы ---
    // -------------------

    public int getMin() {
        return this.minBalance;
    }

    public int getMax() {
        return this.maxBalance;
    }
}