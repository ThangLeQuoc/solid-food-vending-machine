package com.greenduck.vendingmachine.machine;

import com.greenduck.vendingmachine.foods.Food;
import com.greenduck.vendingmachine.money.Banknote;
import com.greenduck.vendingmachine.money.Currency;
import com.greenduck.vendingmachine.money.CurrencyExchangeRateConstants;

/**
 * We hire a monkey coder to implement a sample vending machine for us. He gave
 * us this...
 */
public class MonkeyFoodVendingMachine extends FoodVendingMachine {

    public MonkeyFoodVendingMachine(Currency currency) {
        super(currency);
    }

    @Override
    public void addBalance(Banknote note) {

        /* Our machine currently use VND, so let's check what you put in */
        if (Currency.VND.equals(getCurrency())) {
            if (Currency.VND.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.VND_TO_VND;
            }
            if (Currency.CHF.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.CHF_TO_VND;
            }
            if (Currency.USD.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.USD_TO_VND;
            }
            if (Currency.EUR.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.EUR_TO_VND;
            }
        }

        if (Currency.USD.equals(getCurrency())) {
            if (Currency.USD.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.USD_TO_USD;
            }
            if (Currency.CHF.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.CHF_TO_USD;
            }
            if (Currency.VND.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.VND_TO_USD;
            }
            if (Currency.EUR.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.EUR_TO_USD;
            }
        }

        if (Currency.CHF.equals(getCurrency())) {
            if (Currency.CHF.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.CHF_TO_CHF;
            }
            if (Currency.VND.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.VND_TO_CHF;
            }
            if (Currency.USD.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.USD_TO_CHF;
            }
            if (Currency.EUR.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.EUR_TO_CHF;
            }
        }

        if (Currency.EUR.equals(getCurrency())) {
            if (Currency.EUR.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.EUR_TO_EUR;
            }
            if (Currency.CHF.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.CHF_TO_EUR;
            }
            if (Currency.USD.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.USD_TO_EUR;
            }
            if (Currency.VND.equals(note.getCurrency())) {
                this.balance += note.getAmount() * CurrencyExchangeRateConstants.VND_TO_EUR;
            }
        }
    }

    @Override
    public Food getFood(int selectedIndex) {
        verifyValidFoodSelection(selectedIndex);

        double currentBalance = getBalance();
        Food selectedFood = foods.get(selectedIndex);

        /* check the machine's current currency to resolve appropriate balance */

        if (Currency.VND.equals(getCurrency())) {
            if (Currency.VND.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.VND_TO_VND;
            }
            if (Currency.CHF.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.CHF_TO_VND;
            }
            if (Currency.USD.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.USD_TO_VND;
            }
            if (Currency.EUR.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.EUR_TO_VND;
            }
        }

        if (Currency.USD.equals(getCurrency())) {
            if (Currency.USD.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.USD_TO_USD;
            }
            if (Currency.CHF.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.CHF_TO_USD;
            }
            if (Currency.VND.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.VND_TO_USD;
            }
            if (Currency.EUR.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.EUR_TO_USD;
            }
        }

        if (Currency.EUR.equals(getCurrency())) {
            if (Currency.EUR.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.EUR_TO_EUR;
            }
            if (Currency.CHF.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.CHF_TO_EUR;
            }
            if (Currency.USD.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.USD_TO_EUR;
            }
            if (Currency.VND.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.VND_TO_EUR;
            }
        }

        if (Currency.CHF.equals(getCurrency())) {
            if (Currency.CHF.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.CHF_TO_CHF;
            }
            if (Currency.VND.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.VND_TO_CHF;
            }
            if (Currency.USD.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.USD_TO_CHF;
            }
            if (Currency.EUR.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * CurrencyExchangeRateConstants.EUR_TO_CHF;
            }
        }

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
