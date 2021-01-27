package com.cundy.workdesign.design.builder.entity;

import com.cundy.workdesign.design.builder.extend.ChickenBurger;
import com.cundy.workdesign.design.builder.extend.Coke;
import com.cundy.workdesign.design.builder.extend.Pepsi;
import com.cundy.workdesign.design.builder.extend.VegBurger;

/**
 * 创建Meal 对象Builder
 */
public class MealBuilder {

    public Meal prepareVegMeal()
    {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());

        return meal;
    }

    public Meal prepareNonVegMeal()
    {
        Meal meal = new Meal();

        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
