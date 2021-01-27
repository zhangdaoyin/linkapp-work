package com.cundy.workdesign.design.builder.client;

import com.cundy.workdesign.design.builder.entity.Meal;
import com.cundy.workdesign.design.builder.entity.MealBuilder;

public class BuilerTest {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal...");
        vegMeal.showItems();
        System.out.println(String.format("Total Cost : %s", vegMeal.getCost()));

        Meal noMeal = mealBuilder.prepareNonVegMeal();
        System.out.println(" NON Meal ...");
        noMeal.showItems();
        System.out.println(String.format("Total Cost : %s", noMeal.getCost()));

        StringBuilder stringBuilder = new StringBuilder();
    }
}
