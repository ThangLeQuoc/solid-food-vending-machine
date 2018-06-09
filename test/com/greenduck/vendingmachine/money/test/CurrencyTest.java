package com.greenduck.vendingmachine.money.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.greenduck.vendingmachine.money.Currency;

public class CurrencyTest {
    
    @Test
    public void testCurrency() {
        Currency usd = Currency.USD;
        assertEquals(Currency.USD, usd);
        
        
        Currency vnd = Currency.valueOf("VND");
        assertNotNull(vnd);
        assertEquals(Currency.VND, vnd);
        
        assertEquals(4, Currency.values().length);
    }
}
