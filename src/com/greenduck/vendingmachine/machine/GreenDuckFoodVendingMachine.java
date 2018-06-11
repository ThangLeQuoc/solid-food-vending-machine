package com.greenduck.vendingmachine.machine;

import com.greenduck.vendingmachine.foods.Food;
import com.greenduck.vendingmachine.money.Banknote;
import com.greenduck.vendingmachine.money.Currency;

public class GreenDuckFoodVendingMachine extends FoodVendingMachine {

    public GreenDuckFoodVendingMachine(Currency currency) {
        super(currency);
    }

    @Override
    public void addBalance(Banknote note) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Food getFood(int selectedIndex) {
        // TODO Auto-generated method stub
        return null;
    }

}
