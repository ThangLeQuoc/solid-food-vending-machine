package com.greenduck.vendingmachine.machine.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.greenduck.vendingmachine.common.test.FoodVendingTestConstant;
import com.greenduck.vendingmachine.foods.Biscuit;
import com.greenduck.vendingmachine.foods.ChocolateBar;
import com.greenduck.vendingmachine.foods.Food;
import com.greenduck.vendingmachine.foods.InstantNoodle;
import com.greenduck.vendingmachine.foods.Sausage;
import com.greenduck.vendingmachine.machine.FoodVendingMachine;
import com.greenduck.vendingmachine.machine.MonkeyFoodVendingMachine;
import com.greenduck.vendingmachine.money.Banknote;
import com.greenduck.vendingmachine.money.Currency;
import com.greenduck.vendingmachine.money.CurrencyExchangeRateConstants;
import com.greenduck.vendingmachine.money.PriceTag;

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

    @Test
    public void testBuyFood_ShouldNotReturnFoodAndKeepCurrentBalance_WhenNotEnoughBalance() {
        // given
        foodVendingMachine.setCurrency(Currency.VND);
        Banknote vndNote = new Banknote(Currency.VND, 5000);
        foodVendingMachine.addBalance(vndNote);

        Food dubaiSausage = new Sausage();
        PriceTag dubaiSausagePrice = new PriceTag(Currency.EUR, 100);
        dubaiSausage.setPriceTag(dubaiSausagePrice);
        foodVendingMachine.addFood(dubaiSausage);

        // when
        Food food = foodVendingMachine.getFood(0);

        // then
        assertTrue(foodVendingMachine.getBalance() < dubaiSausage.getPriceTag().getPrice()
                * CurrencyExchangeRateConstants.EUR_TO_VND);
        assertNull(food);
        assertEquals(vndNote.getAmount(), foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyFood_ShouldThrowException_WhenFoodSelectionIsOutOfRange() {
        // given
        Food omachiNoodle = new InstantNoodle();
        PriceTag dubaiSausagePrice = new PriceTag(Currency.VND, 15000);
        omachiNoodle.setPriceTag(dubaiSausagePrice);
        foodVendingMachine.addFood(omachiNoodle);

        // when
        try {
            foodVendingMachine.getFood(4);
        } catch (IllegalArgumentException e) {
            assertEquals(FoodVendingMachine.ERR_MESSAGE_INVALID_FOOD_SELECTION, e.getMessage());
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyFood_ShouldRemoveFoodFromMachine_WhenPurchaseSuccessfully() {
        // given
        Food chocolateBar = new ChocolateBar();
        PriceTag chocolatePrice = new PriceTag(Currency.USD, 0.55);
        chocolateBar.setPriceTag(chocolatePrice);
        foodVendingMachine.addFood(chocolateBar);

        Banknote usdNote = new Banknote(Currency.USD, 5);
        foodVendingMachine.addBalance(usdNote);

        // when
        try {
            Food expectedChocolateBar = foodVendingMachine.getFood(0);
            assertEquals(chocolateBar, expectedChocolateBar);

            foodVendingMachine.getFood(0);
        } catch (IllegalArgumentException e) {
            assertEquals(FoodVendingMachine.ERR_MESSAGE_INVALID_FOOD_SELECTION, e.getMessage());
            throw e;
        }
    }

    @Test
    public void testBuyFood_ShouldReturnFoodAndReduceBalance_WithMachineVNDCurrency() {
        // given
        foodVendingMachine.setCurrency(Currency.VND);

        Food biscuit = new Biscuit();
        PriceTag biscuitPrice = new PriceTag(Currency.EUR, 1.43);
        biscuit.setPriceTag(biscuitPrice);
        foodVendingMachine.addFood(biscuit);

        // when
        Banknote vndNote = new Banknote(Currency.VND, 50000);
        foodVendingMachine.addBalance(vndNote);
        double initialBalance = foodVendingMachine.getBalance();
        Food actualFood = foodVendingMachine.getFood(0);

        // then
        assertTrue(initialBalance > biscuit.getPriceTag().getPrice() * CurrencyExchangeRateConstants.EUR_TO_VND);
        double expectedRemainingBalance = initialBalance
                - biscuitPrice.getPrice() * CurrencyExchangeRateConstants.EUR_TO_VND;
        assertEquals(expectedRemainingBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
        assertEquals(biscuit, actualFood);

    }

    @Test
    public void testBuyFood_ShouldReturnFoodAndReduceBalance_WithMachineUSDCurrency() {
        // given
        foodVendingMachine.setCurrency(Currency.USD);

        Food sausage = new Sausage();
        PriceTag sausagePrice = new PriceTag(Currency.VND, 4000);
        sausage.setPriceTag(sausagePrice);
        Food biscuit = new Biscuit();
        PriceTag biscuitPrice = new PriceTag(Currency.CHF, 1);
        biscuit.setPriceTag(biscuitPrice);

        foodVendingMachine.addFood(sausage);
        foodVendingMachine.addFood(biscuit);

        Banknote usdNote = new Banknote(Currency.USD, 5);
        foodVendingMachine.addBalance(usdNote);
        double initialBalance = foodVendingMachine.getBalance();

        // when
        Food actualFood1 = foodVendingMachine.getFood(0);

        // then
        assertEquals(sausage, actualFood1);
        double expectedRemainingBalance = initialBalance
                - sausage.getPriceTag().getPrice() * CurrencyExchangeRateConstants.VND_TO_USD;
        assertEquals(expectedRemainingBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);

        Food actualFood2 = foodVendingMachine.getFood(0);
        assertEquals(biscuit, actualFood2);
        expectedRemainingBalance = expectedRemainingBalance
                - biscuit.getPriceTag().getPrice() * CurrencyExchangeRateConstants.CHF_TO_USD;
        assertEquals(expectedRemainingBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

    public void testBuyFood_ShouldBuyCHFTagFood_WithCHFMachineCurrency() {

        // given
        foodVendingMachine.setCurrency(Currency.CHF);
        Food biscuit = new Biscuit();
        PriceTag biscuitPrice = new PriceTag(Currency.CHF, 10);
        biscuit.setPriceTag(biscuitPrice);
        foodVendingMachine.addFood(biscuit);

        // when
        Banknote chfNote1 = new Banknote(Currency.CHF, 5);
        foodVendingMachine.addBalance(chfNote1);
        double initialBalance = foodVendingMachine.getBalance();
        Food actualFood = foodVendingMachine.getFood(0);

        // then
        assertNull(actualFood);
        assertEquals(initialBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
        Banknote chfNote2 = new Banknote(Currency.CHF, 10);
        foodVendingMachine.addBalance(chfNote2);
        initialBalance += chfNote2.getAmount();
        actualFood = foodVendingMachine.getFood(0);
        assertEquals(biscuit, actualFood);
        double expectedRemainingBalance = initialBalance - biscuit.getPriceTag().getPrice();
        assertEquals(expectedRemainingBalance, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);

    }

    @Test
    public void testBuyFood_ShouldBuyUSDTagFood_WithCHFMachineCurrency() {
        // given
        foodVendingMachine.setCurrency(Currency.CHF);
        Food americanSausage = new Sausage();
        PriceTag americanSausagePrice = new PriceTag(Currency.USD, 12);
        americanSausage.setPriceTag(americanSausagePrice);
        foodVendingMachine.addFood(americanSausage);

        Banknote usdNote = new Banknote(Currency.USD, 20);
        foodVendingMachine.addBalance(usdNote);
        double initialBalance = foodVendingMachine.getBalance();

        // when
        Food actualSausage = foodVendingMachine.getFood(0);
        assertEquals(americanSausage, actualSausage);
        double expectedRemainingBalanceInCHF = initialBalance
                - americanSausage.getPriceTag().getPrice() * CurrencyExchangeRateConstants.USD_TO_CHF;

        assertEquals(expectedRemainingBalanceInCHF, foodVendingMachine.getBalance(), FoodVendingTestConstant.EPSILON);
    }

}
