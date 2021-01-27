package com.cundy.workdesign.design.abstractFactory.d7;

import com.cundy.workdesign.design.abstractFactory.d5.AbstractFactory;
import com.cundy.workdesign.design.abstractFactory.d6.ColorFactory;
import com.cundy.workdesign.design.abstractFactory.d6.ShapeFactory;

/**
 * 工厂创造器/生成器，通过传递形状或者颜色信息来获取工厂
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice)
    {
        switch (choice)
        {
            case "SHAPE":
                return new ShapeFactory();

            case "COLOR":
                return new ColorFactory();
        }
        return null;
    }
}

