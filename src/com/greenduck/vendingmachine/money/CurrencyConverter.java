package com.greenduck.vendingmachine.money;

public class CurrencyConverter {
    
    private CurrencyConverter() {}
    
    public static double exchangeCurrency(Currency from, Currency to, double amount) {
        if (Currency.USD.equals(to)) {
            return convertToUSDCurrency(from, amount);
        }
        if (Currency.USD.equals(from)) {
            return 1 / convertToUSDCurrency(to, 1/amount);
        }
        return exchangeCurrency(Currency.USD, to, exchangeCurrency(from, Currency.USD, amount));

    }

    private static double convertToUSDCurrency(Currency currency, double amount) {
        if (Currency.VND.equals(currency)) {
            return amount * CurrencyExchangeRateConstants.VND_TO_USD;
        }
        if (Currency.EUR.equals(currency)) {
            return amount * CurrencyExchangeRateConstants.EUR_TO_USD;
        }
        if (Currency.CHF.equals(currency)) {
            return amount * CurrencyExchangeRateConstants.CHF_TO_USD;
        }
        return amount;
    }
}
