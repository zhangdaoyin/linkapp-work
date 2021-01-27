package com.cundy.workdesign.design.factory.client;

import com.cundy.workdesign.design.factory.dto.ShapeFactory;
import com.cundy.workdesign.design.factory.vo.Shape;

public class FactoryTest {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("CIR");

        shape1.draw();

        Shape shape2 = factory.getShape("REC");

        shape2.draw();

        Shape shape3 = factory.getShape("SQU");

        shape3.draw();

    }
}
