package com.cundy.workdesign.design.abstractFactory.d6;

import com.cundy.workdesign.design.abstractFactory.d1.Shape;
import com.cundy.workdesign.design.abstractFactory.d3.Color;
import com.cundy.workdesign.design.abstractFactory.d4.Blue;
import com.cundy.workdesign.design.abstractFactory.d4.Green;
import com.cundy.workdesign.design.abstractFactory.d4.Red;
import com.cundy.workdesign.design.abstractFactory.d5.AbstractFactory;

/**
 *
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null)
        {
            return null;
        }
        switch (color)
        {
            case "RED":
                return new Red();
            case "GREEN":
                return new Green();
            case "BLUE":
                return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
