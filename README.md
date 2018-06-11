# Food Vending Machine
It's time for food :hamburger:
## Foreword
This is a small OOP puzzle quiz about Solid Programming Principle. Developer will have to apply OOP principles to solve the problem.
## Business Specification
Adnovum company is about to set up a food vending machine, since many employees are hungry.
The **Food Vending Machine** requirement is fairly simple:
- It contains `Food` (of course)
- People can add **balance** , in this scenario, are different type of `Banknote` to the machine
- Since Adnovum is an international company, the machine then will be used by
people from different countries. The machine must be able to consume different type
of `Currency`
- The machine will serve international food, which mean each food may have different
currency price tag
- Once the machine balance currency is set, it must be smart enough to *convert currency to the machine based currency* for processing balance.

#### Use case Diagram
![Use case diagram](https://i.imgur.com/BFZPmOB.png)
## Technical Specification
Breaking down the business specs, we have the following classes to implements:
- `Food` :
A food will has name and `PriceTag`
![Food Class Diagram](https://i.imgur.com/jGl3XbS.png)

- `Banknote` and `PriceTag` have `Currency` and base values.
Our machine starts with some bases currencies VND, CHF, USD and EUR, come with a set
of constants as conversion rate.
![Money Class Diagram](https://i.imgur.com/Q1SG4AI.png)

- `FoodVendingMachine` has `addBalance` method which consume `Banknote`, `addFood` to fill up the machine

![Food Vending Machine Class Diagram](https://i.imgur.com/SOxOmVG.png)
### The All-knowing Food Vending Machine :slot_machine: :ice_cream:  :beer:
Adnovum company hired a monkey coder to implement the machine sets, the hardest part is the currency conversion handle, and our monkey coder had no problem to handle it "nicely"
```
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
```

> The Vending Machine is so powerful that beside giving out food, it even know how to convert different type of currencies. May be someday in the future, it may even offer you to change some CHF banknote into VND for free, even you if don't buy the food. How generous is that!

## What's going wrong ?
The monkey coder might not be aware that stuffing too many unrelated functionality to the machine might lead to a bigger problem in the future. What if the company offer service to exchange CHF into VND banknotes for Swiss employee who comes to Vietnam, is it suitable if we tell him to reach the vending machine to get what he wanted ? And what if another type of currency, namely _Hungarian Forint_ is added, we might have to dive into the machine implementation and add modification as well.

Seeing the horrible over-generous vending machine, Adnovum company design to hire some **Solid Programmers** teams to have the problem fixed up.

### What should the Solid Programmers do :construction_worker:
- Can you untie the knot inside the vending machine ?
- Make sure yours test cases cover all most all the code. Luckily the monkey coder
already write some test cases, so you can quickly refer and make a good use from them

###### From The Green Rubber Ducks :hatching_chick: Team with :heart:

