package com.greenduck.vendingmachine.money;

public class Banknote {
    private int amount;
    private Currency currency;
    
    public Banknote(Currency currency, int amount) {
        this.currency = currency;
        this.amount = amount;
    }
    
    public Currency getCurrency() {
        return currency;
    }
    
    public int getAmount() {
        return amount;
    }
}
