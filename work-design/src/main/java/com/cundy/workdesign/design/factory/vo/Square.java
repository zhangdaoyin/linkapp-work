package com.cundy.workdesign.design.factory.vo;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println(
                String.format("enter the method %s ::draw()", this.getClass().getName())
        );
    }
}
