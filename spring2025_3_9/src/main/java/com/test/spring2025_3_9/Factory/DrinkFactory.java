package com.test.spring2025_3_9.Factory;

public class DrinkFactory {
    public static IDrink createDrink(String drink){
        if(drink.equals("tea")){
            return new Tea();
        }else if(drink.equals("coffee")){
            return new Coffee();
        }else{
            System.out.println("无法进行创建...");
        }
        return null;
    }
}
