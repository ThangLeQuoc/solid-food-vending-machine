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
    public void testAddBalance_ShouldAddAmountOfSameCurrency() {
        Banknote vndNote = new Banknote(Currency.VND, 5000);
        foodVendingMachine.addBalance(vndNote);
        Banknote vndNote1 = new Banknote(Currency.VND, 10000);
        foodVendingMachine.addBalance(vndNote1);
        double totalAddedAmount = vndNote.getAmount() + vndNote1.getAmount();
        assertEquals(totalAddedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddCHFtoVNDBalanceCorrectly() {
        // given
        foodVendingMachine.setCurrency(Currency.VND);
        Banknote chfNote = new Banknote(Currency.CHF, 20);

        // when
        foodVendingMachine.addBalance(chfNote);

        // then
        double expectedBalance = chfNote.getAmount() * CurrencyExchangeRateConstants.CHF_TO_VND;
        assertEquals(expectedBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddUSDtoVNDBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.VND);
        Banknote usdNote = new Banknote(Currency.USD, 2);

        // when
        foodVendingMachine.addBalance(usdNote);

        // then
        double expectedAmount = usdNote.getAmount() * CurrencyExchangeRateConstants.USD_TO_VND;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);

    }

    @Test
    public void testAddBalance_ShouldAddEURtoVNDBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.VND);
        Banknote eurNote = new Banknote(Currency.EUR, 50);

        // when
        foodVendingMachine.addBalance(eurNote);

        // then
        double expectedAmount = eurNote.getAmount() * CurrencyExchangeRateConstants.EUR_TO_VND;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddVNDtoUSDBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.USD);
        Banknote vndNote = new Banknote(Currency.VND, 50000);

        // when
        foodVendingMachine.addBalance(vndNote);

        // then
        double expectedAmount = vndNote.getAmount() * CurrencyExchangeRateConstants.VND_TO_USD;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddCHFtoUSDBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.USD);
        Banknote chfNote = new Banknote(Currency.CHF, 20);

        // when
        foodVendingMachine.addBalance(chfNote);

        // then
        double expectedAmount = chfNote.getAmount() * CurrencyExchangeRateConstants.CHF_TO_USD;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddEURToUSDBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.USD);
        Banknote eurNote = new Banknote(Currency.EUR, 100);

        // when
        foodVendingMachine.addBalance(eurNote);

        // then
        double expectedAmount = eurNote.getAmount() * CurrencyExchangeRateConstants.EUR_TO_USD;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddUSDtoUSDBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.USD);
        Banknote usdNote = new Banknote(Currency.USD, 100);

        // when
        foodVendingMachine.addBalance(usdNote);

        // then
        double expectedAmount = usdNote.getAmount() * CurrencyExchangeRateConstants.USD_TO_USD;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddUSDtoEURBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.EUR);
        Banknote usdNote = new Banknote(Currency.USD, 10);

        // when
        foodVendingMachine.addBalance(usdNote);

        // then
        double expectedAmount = usdNote.getAmount() * CurrencyExchangeRateConstants.USD_TO_EUR;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddVNDtoEURBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.EUR);
        Banknote vndNote = new Banknote(Currency.VND, 100000);

        // when
        foodVendingMachine.addBalance(vndNote);

        // then
        double expectedAmount = vndNote.getAmount() * CurrencyExchangeRateConstants.VND_TO_EUR;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddCHFtoEURBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.EUR);
        Banknote chfNote = new Banknote(Currency.CHF, 50);

        // when
        foodVendingMachine.addBalance(chfNote);

        // then
        double expectedAmount = chfNote.getAmount() * CurrencyExchangeRateConstants.CHF_TO_EUR;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddEURtoEURBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.EUR);
        Banknote eurNote = new Banknote(Currency.EUR, 50);

        // when
        foodVendingMachine.addBalance(eurNote);

        // then
        double expectedAmount = eurNote.getAmount() * CurrencyExchangeRateConstants.EUR_TO_EUR;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddCHFtoCHFBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.CHF);
        Banknote chfNote = new Banknote(Currency.CHF, 50);

        // when
        foodVendingMachine.addBalance(chfNote);

        // then
        double expectedAmount = chfNote.getAmount() * CurrencyExchangeRateConstants.CHF_TO_CHF;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddUSDtoCHFBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.CHF);
        Banknote usdNote = new Banknote(Currency.USD, 20);

        // when
        foodVendingMachine.addBalance(usdNote);

        // then
        double expectedAmount = usdNote.getAmount() * CurrencyExchangeRateConstants.USD_TO_CHF;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddVNDToCHFBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.CHF);
        Banknote vndNote = new Banknote(Currency.VND, 200000);

        // when
        foodVendingMachine.addBalance(vndNote);

        // then
        double expectedAmount = vndNote.getAmount() * CurrencyExchangeRateConstants.VND_TO_CHF;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddEURToCHFBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.CHF);
        Banknote eurNote = new Banknote(Currency.EUR, 10);

        // when
        foodVendingMachine.addBalance(eurNote);

        // then
        double expectedAmount = eurNote.getAmount() * CurrencyExchangeRateConstants.EUR_TO_CHF;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAbleToAddDifferentCurrencyTypeToVNDCurrency() {
        // given
        foodVendingMachine.setCurrency(Currency.VND);

        Banknote vndNote = new Banknote(Currency.VND, 50000);
        Banknote usdNote = new Banknote(Currency.USD, 50);
        Banknote eurNote = new Banknote(Currency.EUR, 100);
        Banknote chfNote = new Banknote(Currency.CHF, 20);

    }

}
