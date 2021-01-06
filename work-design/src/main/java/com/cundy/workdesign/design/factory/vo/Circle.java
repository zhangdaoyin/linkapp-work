package com.cundy.workdesign.design.factory.vo;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println(
                String.format("enter the %s ::draw()", this.getClass().getName())
        );
    }
}
