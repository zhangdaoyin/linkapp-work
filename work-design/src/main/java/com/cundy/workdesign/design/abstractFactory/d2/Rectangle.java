package com.cundy.workdesign.design.abstractFactory.d2;

import com.cundy.workdesign.design.abstractFactory.d1.Shape;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println(String.format("enter the method %s :: draw()", this.getClass().getName()));
    }
}
