package com.cundy.workdesign.design.builder.extend;


import com.cundy.workdesign.design.builder.domain.Burger;

public class VegBurger extends Burger {

    @Override
    public String name() {
        return "VegBurger 薯条";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
