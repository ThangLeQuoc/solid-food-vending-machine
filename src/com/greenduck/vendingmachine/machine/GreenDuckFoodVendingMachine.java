package com.greenduck.vendingmachine.machine;

import com.greenduck.vendingmachine.foods.Food;
import com.greenduck.vendingmachine.money.Banknote;
import com.greenduck.vendingmachine.money.Currency;
import com.greenduck.vendingmachine.money.CurrencyConverter;

public class GreenDuckFoodVendingMachine extends FoodVendingMachine {

    public GreenDuckFoodVendingMachine(Currency currency) {
        super(currency);
    }

    @Override
    public void addBalance(Banknote note) {
        this.balance += CurrencyConverter.exchangeCurrency(note.getCurrency(), getCurrency(), note.getAmount());
    }

    @Override
    public Food getFood(int selectedIndex) {
        verifyValidFoodSelection(selectedIndex);
        
        double currentBalance = getBalance();
        Food selectedFood = foods.get(selectedIndex);
        
        this.balance -= CurrencyConverter.exchangeCurrency(selectedFood.getPriceTag().getCurrency(), 
                getCurrency(), selectedFood.getPriceTag().getPrice());
        
        if (balance < 0) {
            System.out.println("In Your Dream");
            this.balance = currentBalance;
            selectedFood = null;
        } else {
            this.foods.remove(selectedIndex);
        }
        printBalance();
        return selectedFood;
    }

}
