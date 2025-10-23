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
        
        // Получаем стартовый баланс, установленный родителем.
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
     * Переопределяет метод debit(Debit d)
     */
    @Override // <--- Убедитесь, что эта аннотация работает! Если нет,
              // значит, имя метода не debit, а, например, processDebit
    public void debit(Debit d) { 
        super.debit(d); // Вызов родительского метода
        updateMinMax(); // Обновляем min/max
    }

    /**
     * Переопределяет метод credit(Credit c)
     */
    @Override // <--- Убедитесь, что эта аннотация работает! 
    public void credit(Credit c) { 
        super.credit(c); // Вызов родительского метода
        updateMinMax();  // Обновляем min/max
    }

    // --- Новые методы ---

    public int getMin() {
        return this.minBalance;
    }

    public int getMax() {
        return this.maxBalance;
    }
}