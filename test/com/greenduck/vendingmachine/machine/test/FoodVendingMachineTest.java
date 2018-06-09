package com.greenduck.vendingmachine.machine.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.greenduck.vendingmachine.common.test.FoodVendingTestConstant;
import com.greenduck.vendingmachine.machine.FoodVendingMachine;
import com.greenduck.vendingmachine.machine.MonkeyFoodVendingMachine;
import com.greenduck.vendingmachine.money.Banknote;
import com.greenduck.vendingmachine.money.Currency;

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
        foodVendingMachine.setCurrency(Currency.VND);
        Banknote chfNote = new Banknote(Currency.CHF, 20);
        foodVendingMachine.addBalance(chfNote);
        assertEquals(461247.70, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

}
