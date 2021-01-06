package com.cundy.workdesign.design.factory.vo;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println(String.format("enter %s ::draw() method", this.getClass().getName()));
    }
}
