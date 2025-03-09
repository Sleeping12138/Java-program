package com.test.spring2025_3_9.Factory;

public class TeaFactory implements IFactory{
    @Override
    public IDrink createFactory() {
        return new Tea();
    }
}
