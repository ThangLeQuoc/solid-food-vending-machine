package com.greenduck.vendingmachine.foods;

import com.greenduck.vendingmachine.money.Currency;

//TODO: add java doc
public class PriceTag {
    private double price;
    private Currency currency;
    
    public PriceTag(Currency currency, double price) {
        this.currency = currency;
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public Currency getCurrency() {
        return currency;
    }
}
