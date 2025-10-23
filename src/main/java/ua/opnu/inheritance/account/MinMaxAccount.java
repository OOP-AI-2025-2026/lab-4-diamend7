package ua.opnu.inheritance.account;
import ua.opnu.inheritance.account.Credit;
import ua.opnu.inheritance.account.Debit;

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
    // --- ПЕРЕГРУЗКА: Принимает Debit (Снятие/Вычет) ---
    // ------------------------------------------------------------------
    public boolean debit(Debit debit) {
        int amount = debit.getBalance();
        // Используем Math.abs() на случай, если Debit был инициализирован отрицательным (хотя это нелогично)
        return this.debit(Math.abs(amount)); 
    }
    
    // -------------------------------------------------------------------
    // --- ПЕРЕГРУЗКА: Принимает Credit (Пополнение/Вычет) ---
    // -------------------------------------------------------------------
    public void credit(Credit credit) {
        int amount = credit.getBalance();
        
        if (amount >= 0) {
            // Если положительно (стандартное пополнение): вызываем Credit
            this.credit(amount); 
        } else {
            // Если отрицательно (подразумевается СНЯТИЕ в тестах): 
            // вызываем Debit с положительным значением
            this.debit(Math.abs(amount)); 
        }
    }

    // -------------------------------------------------
    // --- ПЕРЕОПРЕДЕЛЕННЫЕ МЕТОДЫ ---
    // -------------------------------------------------

    @Override
    public boolean debit(int amount) {
        boolean success = super.debit(amount); 
        if (success) {
            updateMinMax();      
        }
        return success; 
    }

    @Override
    public void credit(int amount) {
        super.credit(amount); 
        updateMinMax();       
    }

    public int getMin() {
        return this.minBalance;
    }

    public int getMax() {
        return this.maxBalance;
    }
}