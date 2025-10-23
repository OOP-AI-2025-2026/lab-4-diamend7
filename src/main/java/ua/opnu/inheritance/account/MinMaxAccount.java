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

    // ------------------------------------------------------------------
    // --- ПЕРЕГРУЗКА: Принимает Debit (для совместимости с Task2Test) ---
    // ------------------------------------------------------------------
    /**
     * Перегруженный метод для обработки Debit-объектов.
     * Вызывает основной метод debit(int).
     */
    public boolean debit(Debit debit) {
        // ИСПРАВЛЕНО: используем Math.abs() для предотвращения IllegalArgumentException
        return this.debit(Math.abs(debit.getBalance())); 
    }
    
    // -------------------------------------------------------------------
    // --- ПЕРЕГРУЗКА: Принимает Credit (для совместимости с Task2Test) ---
    // -------------------------------------------------------------------
    /**
     * Перегруженный метод для обработки Credit-объектов.
     * Вызывает основной метод credit(int).
     */
    public void credit(Credit credit) {
        // ИСПРАВЛЕНО: используем Math.abs() для предотвращения IllegalArgumentException
        this.credit(Math.abs(credit.getBalance()));
    }

    // -------------------------------------------------
    // --- ПЕРЕОПРЕДЕЛЕННЫЕ МЕТОДЫ (ОСНОВНАЯ ЛОГИКА) ---
    // -------------------------------------------------

    /**
     * Переопределяет debit(int) с возвращаемым типом boolean.
     * Возвращает результат операции родительского класса.
     */
    @Override
    public boolean debit(int amount) {
        boolean success = super.debit(amount); // Вызываем родительский метод
        
        // Обновляем min/max только если операция была успешной
        if (success) {
            updateMinMax();      
        }
        return success; // Возвращаем результат
    }

    /**
     * Переопределяет credit(int).
     */
   @Override
    public void credit(int amount) {
        super.credit(amount); // Вызываем родительский метод
        updateMinMax();       // Обновляем min/max после успешной операции
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