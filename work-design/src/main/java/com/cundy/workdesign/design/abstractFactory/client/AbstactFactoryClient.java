package com.cundy.workdesign.design.abstractFactory.client;

import com.cundy.workdesign.design.abstractFactory.d1.Shape;
import com.cundy.workdesign.design.abstractFactory.d3.Color;
import com.cundy.workdesign.design.abstractFactory.d5.AbstractFactory;
import com.cundy.workdesign.design.abstractFactory.d7.FactoryProducer;


public class AbstactFactoryClient {

    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        //获取形状为Circle的对象
        Shape shape = shapeFactory.getShape("CIR");
        shape.draw();

        Shape shape1 = shapeFactory.getShape("REC");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("SQU");
        shape2.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color color = colorFactory.getColor("RED");
        color.fill();

        Color color1 = colorFactory.getColor("BLUE");
        color1.fill();

        Color color2 = colorFactory.getColor("GREEN");
        color2.fill();


    }
}
