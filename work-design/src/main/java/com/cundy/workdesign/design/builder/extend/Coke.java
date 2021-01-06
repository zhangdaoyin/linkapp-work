package com.cundy.workdesign.design.builder.extend;

import com.cundy.workdesign.design.builder.domain.ColdDrink;

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "可乐";
    }

    @Override
    public float price() {
        return 33.2f;
    }
}
