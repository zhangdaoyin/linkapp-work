package com.cundy.workdesign.design.builder.domain;

import com.cundy.workdesign.design.builder.dto.Bottle;
import com.cundy.workdesign.design.builder.vo.Item;
import com.cundy.workdesign.design.builder.vo.Packing;

public abstract class ColdDrink implements Item {


    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
