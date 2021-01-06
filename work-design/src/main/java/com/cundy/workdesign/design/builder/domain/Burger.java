package com.cundy.workdesign.design.builder.domain;

import com.cundy.workdesign.design.builder.dto.Wrapper;
import com.cundy.workdesign.design.builder.vo.Item;
import com.cundy.workdesign.design.builder.vo.Packing;

public abstract class Burger implements Item {


    @Override
    public Packing packing() {
        return new Wrapper();
    }
    @Override
    public abstract float price();
}
