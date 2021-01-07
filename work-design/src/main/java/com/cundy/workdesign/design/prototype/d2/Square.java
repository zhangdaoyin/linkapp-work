package com.cundy.workdesign.design.prototype.d2;

import com.cundy.workdesign.design.prototype.d1.Shape;

public class Square extends Shape {

    public Square()
    {
        type = "SQU";
    }
    @Override
    protected void draw() {
        System.out.println("enter eht SQU :: draw()");
    }
}
