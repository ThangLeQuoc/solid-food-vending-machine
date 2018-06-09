package com.greenduck.vendingmachine.machine.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.greenduck.vendingmachine.common.test.FoodVendingTestConstant;
import com.greenduck.vendingmachine.machine.FoodVendingMachine;
import com.greenduck.vendingmachine.machine.MonkeyFoodVendingMachine;
import com.greenduck.vendingmachine.money.Banknote;
import com.greenduck.vendingmachine.money.Currency;
import com.greenduck.vendingmachine.money.CurrencyExchangeRateConstants;

public class FoodVendingMachineTest {

    private FoodVendingMachine foodVendingMachine;

    @Before
    public void setUp() {
        foodVendingMachine = new MonkeyFoodVendingMachine(Currency.VND);
    }

    @Test
    public void testFoodVendingMachineInitialization() {
        assertEquals(Currency.VND, foodVendingMachine.getCurrency());
        assertEquals(0, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testSetCurrency_ShouldResetCurrentBalanceIfSetDifferentCurrency() {

        Banknote vndNote = new Banknote(Currency.VND, 5000);
        foodVendingMachine.addBalance(vndNote);

        assertEquals(vndNote.getAmount(), foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
        foodVendingMachine.setCurrency(Currency.CHF);
        assertEquals(0, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testSetCurrency_ShouldKeepCurrentBalanceWithSameCurrency() {
        Banknote vndNote = new Banknote(Currency.VND, 10000);
        foodVendingMachine.addBalance(vndNote);
        assertEquals(vndNote.getAmount(), foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
        foodVendingMachine.setCurrency(Currency.VND);
        assertEquals(vndNote.getAmount(), foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAbleToAddDifferentCurrencyTypeToVNDBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.VND);

        Banknote vndNote = new Banknote(Currency.VND, 50000);
        Banknote vndNote1 = new Banknote(Currency.VND, 10000);
        Banknote usdNote = new Banknote(Currency.USD, 50);
        Banknote eurNote = new Banknote(Currency.EUR, 100);
        Banknote eurNote1 = new Banknote(Currency.EUR, 10);
        Banknote chfNote = new Banknote(Currency.CHF, 20);

        // when
        foodVendingMachine.addBalance(vndNote);
        foodVendingMachine.addBalance(vndNote1);
        foodVendingMachine.addBalance(usdNote);
        foodVendingMachine.addBalance(eurNote);
        foodVendingMachine.addBalance(eurNote1);
        foodVendingMachine.addBalance(chfNote);

        // then
        double expectedBalance = (vndNote.getAmount() + vndNote1.getAmount()) * CurrencyExchangeRateConstants.VND_TO_VND
                + usdNote.getAmount() * CurrencyExchangeRateConstants.USD_TO_VND
                + (eurNote.getAmount() + eurNote1.getAmount()) * CurrencyExchangeRateConstants.EUR_TO_VND
                + chfNote.getAmount() * CurrencyExchangeRateConstants.CHF_TO_VND;

        assertEquals(expectedBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAbleToAddDifferentCurrencyTypeToUSDBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.USD);

        Banknote vndNote = new Banknote(Currency.VND, 20000);
        Banknote vndNote1 = new Banknote(Currency.VND, 200000);
        Banknote usdNote = new Banknote(Currency.USD, 20);
        Banknote eurNote = new Banknote(Currency.EUR, 50);
        Banknote eurNote1 = new Banknote(Currency.EUR, 2);
        Banknote chfNote = new Banknote(Currency.CHF, 100);

        // when
        foodVendingMachine.addBalance(vndNote);
        foodVendingMachine.addBalance(vndNote1);
        foodVendingMachine.addBalance(usdNote);
        foodVendingMachine.addBalance(eurNote);
        foodVendingMachine.addBalance(eurNote1);
        foodVendingMachine.addBalance(chfNote);

        // then
        double expectedBalance = (vndNote.getAmount() + vndNote1.getAmount()) * CurrencyExchangeRateConstants.VND_TO_USD
                + usdNote.getAmount() * CurrencyExchangeRateConstants.USD_TO_USD
                + (eurNote.getAmount() + eurNote1.getAmount()) * CurrencyExchangeRateConstants.EUR_TO_USD
                + chfNote.getAmount() * CurrencyExchangeRateConstants.CHF_TO_USD;
        assertEquals(expectedBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);

    }

    @Test
    public void testAddBalance_ShouldAbleToAddDifferentCurrencyTypeToCHFBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.CHF);

        Banknote vndNote = new Banknote(Currency.VND, 5000);
        Banknote vndNote1 = new Banknote(Currency.VND, 20000);
        Banknote usdNote = new Banknote(Currency.USD, 2);
        Banknote eurNote = new Banknote(Currency.EUR, 100);
        Banknote eurNote1 = new Banknote(Currency.EUR, 10);
        Banknote chfNote = new Banknote(Currency.CHF, 2);

        // when
        foodVendingMachine.addBalance(vndNote);
        foodVendingMachine.addBalance(vndNote1);
        foodVendingMachine.addBalance(usdNote);
        foodVendingMachine.addBalance(eurNote);
        foodVendingMachine.addBalance(eurNote1);
        foodVendingMachine.addBalance(chfNote);

        // then
        double expectedBalance = (vndNote.getAmount() + vndNote1.getAmount()) * CurrencyExchangeRateConstants.VND_TO_CHF
                + usdNote.getAmount() * CurrencyExchangeRateConstants.USD_TO_CHF
                + (eurNote.getAmount() + eurNote1.getAmount()) * CurrencyExchangeRateConstants.EUR_TO_CHF
                + chfNote.getAmount() * CurrencyExchangeRateConstants.CHF_TO_CHF;
        assertEquals(expectedBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);

    }

    @Test
    public void testAddBalance_ShouldAbleToAddDifferentCurrencyTypeToEURBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.EUR);

        Banknote vndNote = new Banknote(Currency.VND, 50000);
        Banknote vndNote1 = new Banknote(Currency.VND, 500000);
        Banknote usdNote = new Banknote(Currency.USD, 20);
        Banknote eurNote = new Banknote(Currency.EUR, 10);
        Banknote eurNote1 = new Banknote(Currency.EUR, 5);
        Banknote chfNote = new Banknote(Currency.CHF, 100);

        // when
        foodVendingMachine.addBalance(vndNote);
        foodVendingMachine.addBalance(vndNote1);
        foodVendingMachine.addBalance(usdNote);
        foodVendingMachine.addBalance(eurNote);
        foodVendingMachine.addBalance(eurNote1);
        foodVendingMachine.addBalance(chfNote);

        // then
        double expectedBalance = (vndNote.getAmount() + vndNote1.getAmount()) * CurrencyExchangeRateConstants.VND_TO_EUR
                + usdNote.getAmount() * CurrencyExchangeRateConstants.USD_TO_EUR
                + (eurNote.getAmount() + eurNote1.getAmount()) * CurrencyExchangeRateConstants.EUR_TO_EUR
                + chfNote.getAmount() * CurrencyExchangeRateConstants.CHF_TO_EUR;
        assertEquals(expectedBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);

    }

}
