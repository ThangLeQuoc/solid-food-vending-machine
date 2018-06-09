package com.greenduck.vendingmachine.money;

/**
 * Global Money Exchange Rate, frequently updated
 * Source: <a>https://www.xe.com/currencyconverter/</a>
 * */
public class CurrencyExchangeRateConstants {
    
    /* To USD Exchange Rate */
    public static final double CHF_TO_USD = 1.01555;
    public static final double EUR_TO_USD = 1.17696;
    public static final double VND_TO_USD = 0.0000438964;
    public static final double USD_TO_USD = 1;
    
    /* To VND Exchange Rate */
    public static final double CHF_TO_VND = 23072.81;
    public static final double EUR_TO_VND = 26738.82;
    public static final double VND_TO_VND = 1;
    public static final double USD_TO_VND = 1 / VND_TO_USD;
    
    /* To EUR Exchange Rate */
    public static final double CHF_TO_EUR = 0.862537;
    public static final double EUR_TO_EUR = 1;
    public static final double VND_TO_EUR = 1 / EUR_TO_VND;
    public static final double USD_TO_EUR = 1 / EUR_TO_USD;
    
    /* To CHF Exchange Rate */
    public static final double CHF_TO_CHF = 1;
    public static final double EUR_TO_CHF = 1 / CHF_TO_EUR;
    public static final double VND_TO_CHF = 1 / CHF_TO_VND;
    public static final double USD_TO_CHF = 1 / CHF_TO_USD;
    
    private CurrencyExchangeRateConstants() {} 
}
