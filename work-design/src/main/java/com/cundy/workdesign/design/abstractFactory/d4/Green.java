package com.cundy.workdesign.design.abstractFactory.d4;

import com.cundy.workdesign.design.abstractFactory.d3.Color;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println(String.format("enter the method %s ::fill()", this.getClass().getName()));
    }
}
