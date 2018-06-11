package com.greenduck.vendingmachine.money.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.greenduck.vendingmachine.common.test.FoodVendingTestConstant;
import com.greenduck.vendingmachine.money.Currency;
import com.greenduck.vendingmachine.money.CurrencyConverter;
import com.greenduck.vendingmachine.money.CurrencyExchangeRateConstants;

public class CurrencyConverterTest {
    
    @Test
    public void testConvertVNDtoUSD() {
        double vndAmount = 15000;
        
        double expectedAmount = vndAmount * CurrencyExchangeRateConstants.VND_TO_USD;
        double actualAmount = CurrencyConverter.exchangeCurrency(Currency.VND, Currency.USD, vndAmount);
        assertEquals(expectedAmount, actualAmount, FoodVendingTestConstant.EPSILON);
    }
    
    @Test
    public void testConvertUSDtoVND() {
        double usdAmount = 15;
        
        double expectedAmount = usdAmount * CurrencyExchangeRateConstants.USD_TO_VND;
        double actualAmount = CurrencyConverter.exchangeCurrency(Currency.USD, Currency.VND, usdAmount);
        
        assertEquals(expectedAmount, actualAmount, FoodVendingTestConstant.EPSILON);
    }
    
    @Test
    public void testConvertCHFtoUSD() {
        double chfAmount = 50;
        double expectedAmount = chfAmount * CurrencyExchangeRateConstants.CHF_TO_USD;
        
        double actualAmount = CurrencyConverter.exchangeCurrency(Currency.CHF, Currency.USD, chfAmount);
        assertEquals(expectedAmount, actualAmount, FoodVendingTestConstant.EPSILON);
    }
    
    @Test
    public void testConvertUSDtoCHF() {
        double usdAmount = 20;
        double expectedAmount = usdAmount * CurrencyExchangeRateConstants.USD_TO_CHF;
        
        double actualAmount = CurrencyConverter.exchangeCurrency(Currency.USD, Currency.CHF, usdAmount);
        assertEquals(expectedAmount, actualAmount, FoodVendingTestConstant.EPSILON);
    }
}
