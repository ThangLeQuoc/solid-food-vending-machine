package com.greenduck.vendingmachine.money.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.greenduck.vendingmachine.money.Banknote;
import com.greenduck.vendingmachine.money.Currency;

public class BanknoteTest {
    
    @Test
    public void testBanknoteCreation() {
        int value = 50000;
        Banknote vndNote1 = new Banknote(Currency.VND, value);
        assertEquals(Currency.VND, vndNote1.getCurrency());
        assertEquals(value, vndNote1.getAmount());
    }
}
