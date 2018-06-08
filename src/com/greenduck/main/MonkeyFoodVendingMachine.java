package com.greenduck.main;

import com.greenduck.vendingmachine.foods.Food;
import com.greenduck.vendingmachine.money.Banknote;
import com.greenduck.vendingmachine.money.Currency;

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
                this.balance += note.getAmount();
            }
            /* Googling CHF to VND give me this */
            if (Currency.CHF.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 23165.19;
            }
            if (Currency.USD.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 22806;
            }
            if (Currency.EUR.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 26810.73;
            }
        }

        if (Currency.USD.equals(getCurrency())) {
            if (Currency.USD.equals(note.getCurrency())) {
                this.balance += note.getAmount();
            }
            /* Googling CHF to USD give me this */
            if (Currency.CHF.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 1.02;
            }
            if (Currency.VND.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 0.000044;
            }
            if (Currency.EUR.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 0.86;
            }
        }

        if (Currency.CHF.equals(getCurrency())) {
            if (Currency.CHF.equals(note.getCurrency())) {
                this.balance += note.getAmount();
            }
            if (Currency.VND.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 0.000043;
            }
            if (Currency.USD.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 0.98;
            }
            if (Currency.EUR.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 1.16;
            }
        }

        if (Currency.EUR.equals(getCurrency())) {
            if (Currency.EUR.equals(note.getCurrency())) {
                this.balance += note.getAmount();
            }
            if (Currency.CHF.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 0.86;
            }
            if (Currency.USD.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 0.85;
            }
            if (Currency.VND.equals(note.getCurrency())) {
                this.balance += note.getAmount() * 0.000037;
            }
        }
    }

    @Override
    public Food getFood(int selectedIndex) {
        if (selectedIndex >= this.foods.size()) {
            throw new IllegalArgumentException("Invalid Food Index");
        }

        double currentBalance = getBalance();
        Food selectedFood = foods.get(selectedIndex);

        /* check the machine's current currency to resolve appropriate balance */

        if (Currency.VND.equals(getCurrency())) {
            if (Currency.VND.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice();
            }
            if (Currency.CHF.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 23165.19;
            }
            if (Currency.USD.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 22806;
            }
            if (Currency.EUR.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 26810.73;
            }
        }

        if (Currency.USD.equals(getCurrency())) {
            if (Currency.USD.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice();
            }
            if (Currency.CHF.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 1.02;
            }
            if (Currency.VND.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 0.000044;
            }
            if (Currency.EUR.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 0.86;
            }
        }

        if (Currency.EUR.equals(getCurrency())) {
            if (Currency.EUR.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice();
            }
            if (Currency.CHF.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 0.86;
            }
            if (Currency.USD.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 0.85;
            }
            if (Currency.VND.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 0.000037;
            }
        }

        if (Currency.CHF.equals(getCurrency())) {
            if (Currency.CHF.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice();
            }
            if (Currency.VND.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 0.000043;
            }
            if (Currency.USD.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 0.98;
            }
            if (Currency.EUR.equals(selectedFood.getPriceTag().getCurrency())) {
                this.balance -= selectedFood.getPriceTag().getPrice() * 1.16;
            }
        }

        if (balance < 0) {
            System.out.println("In Your Dream");
            this.balance = currentBalance;
            selectedFood = null;
        }
        printBalance();
        return selectedFood;

    }

}
