package com.cundy.workdesign.design.builder.extend;

import com.cundy.workdesign.design.builder.domain.Burger;
import com.cundy.workdesign.design.builder.domain.ColdDrink;

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger 鸡腿";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}
