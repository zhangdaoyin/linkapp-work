package com.cundy.workdesign.design.abstractFactory.d2;

import com.cundy.workdesign.design.abstractFactory.d1.Shape;

/**
 * 接口实现
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println(String.format("enter the method %s :: draw()", this.getClass().getName()));
    }
}
