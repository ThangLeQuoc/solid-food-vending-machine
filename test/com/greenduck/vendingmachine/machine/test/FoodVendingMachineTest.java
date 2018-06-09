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
        //given
        foodVendingMachine.setCurrency(Currency.VND);
        Banknote chfNote = new Banknote(Currency.CHF, 20);
        
        //when
        foodVendingMachine.addBalance(chfNote);
        
        //then
        double expectedBalance = chfNote.getAmount() * CurrencyExchangeRateConstants.CHF_TO_VND;
        assertEquals(expectedBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddUSDtoVNDBalance() {
        //given
        foodVendingMachine.setCurrency(Currency.VND);
        Banknote usdNote = new Banknote(Currency.USD, 2);
        
        //when
        foodVendingMachine.addBalance(usdNote);
        
        //then
        double expectedAmount = usdNote.getAmount() * CurrencyExchangeRateConstants.USD_TO_VND;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);

    }

    @Test
    public void testAddBalance_ShouldAddEURtoVNDBalance() {
        //given
        foodVendingMachine.setCurrency(Currency.VND);
        Banknote eurNote = new Banknote(Currency.EUR, 50);
        
        //when
        foodVendingMachine.addBalance(eurNote);
        
        //then
        double expectedAmount = eurNote.getAmount() * CurrencyExchangeRateConstants.EUR_TO_VND;
        assertEquals(expectedAmount, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    @Test
    public void testAddBalance_ShouldAddVNDtoUSDBalance() {

    }

}
