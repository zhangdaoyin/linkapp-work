package com.cundy.workdesign.design.prototype.d2;

import com.cundy.workdesign.design.prototype.d1.Shape;

public class Rectangle extends Shape{

    public Rectangle()
    {
        type = "REC";
    }

    @Override
    public void draw()
    {
        System.out.println("enter the REC :: draw()");
    }
}
