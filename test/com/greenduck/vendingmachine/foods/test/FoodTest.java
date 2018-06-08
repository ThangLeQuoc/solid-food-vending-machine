package com.greenduck.vendingmachine.foods.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.greenduck.vendingmachine.common.test.FoodVendingTestConstant;
import com.greenduck.vendingmachine.foods.Biscuit;
import com.greenduck.vendingmachine.foods.Food;
import com.greenduck.vendingmachine.money.Currency;
import com.greenduck.vendingmachine.money.PriceTag;

public class FoodTest {
    
    private Food food;
        
    @Test
    public void testBiscuitCreation_ShouldReturnCorrectProperties() {
        
        food = new Biscuit();
        PriceTag priceTag = new PriceTag(Currency.USD, 5.60);
        food.setPriceTag(priceTag);
        
        assertEquals(Biscuit.NAME, food.getName());
        assertEquals(Currency.USD, food.getPriceTag().getCurrency());
        assertEquals(5.60, food.getPriceTag().getPrice(), FoodVendingTestConstant.EPSILON);
        
    }
}
