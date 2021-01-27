package com.cundy.workdesign.design.abstractFactory.d6;

import com.cundy.workdesign.design.abstractFactory.d1.Shape;
import com.cundy.workdesign.design.abstractFactory.d2.Circle;
import com.cundy.workdesign.design.abstractFactory.d2.Rectangle;
import com.cundy.workdesign.design.abstractFactory.d2.Square;
import com.cundy.workdesign.design.abstractFactory.d3.Color;
import com.cundy.workdesign.design.abstractFactory.d5.AbstractFactory;

/**
 * 扩展抽象工厂类，基于给定的信息生成实体类的对象
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if (shape == null)
        {
            return null;
        }
        switch (shape)
        {
            case "CIR":
                return new Circle();
            case "REC":
                return new Rectangle();
            case "SQU":
                return new Square();
        }
        return null;
    }
}
