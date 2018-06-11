# Food Vending Machine

## Foreword

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

- `FoodVendingMachine`

![Food Vending Machine Class Diagram](https://i.imgur.com/SOxOmVG.png)
### The All-knowing Food Vending Machine

