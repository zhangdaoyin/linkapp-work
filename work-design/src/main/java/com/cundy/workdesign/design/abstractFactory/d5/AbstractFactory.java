package com.cundy.workdesign.design.abstractFactory.d5;

import com.cundy.workdesign.design.abstractFactory.d1.Shape;
import com.cundy.workdesign.design.abstractFactory.d3.Color;

/**
 * 为Color和Shape对象创建抽象类来获取工厂
 */
public abstract class AbstractFactory {

    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
