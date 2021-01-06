package com.cundy.workdesign.design.builder.extend;

import com.cundy.workdesign.design.builder.domain.ColdDrink;

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "汽水";
    }

    @Override
    public float price() {
        return 12.8f;
    }
}
