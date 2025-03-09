package com.test.spring2025_3_9.Factory;

public class CoffeeFactory implements IFactory{
    @Override
    public IDrink createFactory() {
        return new Coffee();
    }
}
