package com.greenduck.vendingmachine.money;

public class CurrencyConverter {
    
    public static double exchangeCurrency(Currency from, Currency to, double amount) {
        if (Currency.USD.equals(to)) {
            if (Currency.VND.equals(from)) {
                return amount * CurrencyExchangeRateConstants.VND_TO_USD;
            }
            if (Currency.CHF.equals(from)) {
                return amount * CurrencyExchangeRateConstants.CHF_TO_USD;
            }
        }
        
        if (Currency.USD.equals(from)) {
            if (Currency.VND.equals(to)) {
                return amount * CurrencyExchangeRateConstants.USD_TO_VND;
            }
            
            if (Currency.CHF.equals(to)) {
                return amount * CurrencyExchangeRateConstants.USD_TO_CHF;
            }
        }
        return 0;
        
    }
    
}
