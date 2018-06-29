package com.greenduck.vendingmachine.money.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import com.greenduck.vendingmachine.common.test.FoodVendingTestConstant;
import com.greenduck.vendingmachine.money.CurrencyExchangeRateConstants;

public class CurrencyExchangeRateConstantTest {
    
    @Test
    public void testCHFtoVNDtoUSD() {
        double vndEqualsToOneChf = CurrencyExchangeRateConstants.CHF_TO_VND;
        
        // we convert it to EUR
        double vndEqualsToOneChfToEur = vndEqualsToOneChf * CurrencyExchangeRateConstants.VND_TO_EUR;
        
        double expectedEur = 1 * CurrencyExchangeRateConstants.CHF_TO_EUR;
        assertEquals(expectedEur, vndEqualsToOneChfToEur, FoodVendingTestConstant.EPSILON);
    }
    
    @Test
    @Ignore
    public void testEurToVNDToCHF() {
        double initEuro = 100000;
        double euroToVND = initEuro * CurrencyExchangeRateConstants.EUR_TO_VND;
        double euroToCHF = initEuro * CurrencyExchangeRateConstants.EUR_TO_CHF;
        double chfToVND = euroToCHF * CurrencyExchangeRateConstants.CHF_TO_VND;
        assertEquals(euroToVND, chfToVND, FoodVendingTestConstant.EPSILON);
        
        double initVND = 25000000;
        double vndToEur = initVND * CurrencyExchangeRateConstants.VND_TO_EUR;
        double vndToChf = initVND * CurrencyExchangeRateConstants.VND_TO_CHF;
        double vndToEurToChf = vndToEur * CurrencyExchangeRateConstants.EUR_TO_CHF;
        assertEquals(vndToChf, vndToEurToChf, FoodVendingTestConstant.EPSILON);
    }
    
    @Test
    @Ignore
    public void testVNDtoUSDtoEUR() {
        double initVND = 25000000d;
        double vndToUSD = initVND * CurrencyExchangeRateConstants.VND_TO_USD;
        double vndToChf = initVND * CurrencyExchangeRateConstants.VND_TO_CHF;
        double vndToUsdToChf = vndToUSD * CurrencyExchangeRateConstants.USD_TO_CHF;
        assertEquals(vndToChf, vndToUsdToChf, FoodVendingTestConstant.EPSILON);
    }
}
