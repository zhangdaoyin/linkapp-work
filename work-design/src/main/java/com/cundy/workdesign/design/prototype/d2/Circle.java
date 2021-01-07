package com.cundy.workdesign.design.prototype.d2;

import com.cundy.workdesign.design.prototype.d1.Shape;

public class Circle extends Shape {

    public Circle()
    {
        type = "CIR";
    }
    @Override
    protected void draw() {
        System.out.println("enter the CIR :: draw()");
    }
}
