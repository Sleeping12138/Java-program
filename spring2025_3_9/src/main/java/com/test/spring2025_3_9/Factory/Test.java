package com.test.spring2025_3_9.Factory;

public class Test {
    public static void main(String[] args) {
//        String drink = "coffee";
//        IDrink ret = DrinkFactory.createDrink(drink);
//        if (ret != null) {
//            ret.drink();
//        }

        IFactory coffeeFactory = new CoffeeFactory();
        IDrink coffee = coffeeFactory.createFactory();
        coffee.drink();
    }
}
