package com.cundy.workdesign.design.abstractFactory.d4;

import com.cundy.workdesign.design.abstractFactory.d3.Color;

/**
 * 颜色实现类
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println(String.format("enter the method %s :: fill()", this.getClass().getName()));
    }
}
