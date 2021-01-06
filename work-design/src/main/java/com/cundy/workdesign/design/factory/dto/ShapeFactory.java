package com.cundy.workdesign.design.factory.dto;

import com.cundy.workdesign.design.factory.vo.Circle;
import com.cundy.workdesign.design.factory.vo.Rectangle;
import com.cundy.workdesign.design.factory.vo.Shape;
import com.cundy.workdesign.design.factory.vo.Square;

public class ShapeFactory {

    public Shape getShape(String shapeType)
    {
        if (null == shapeType)
            return null;

        switch (shapeType)
        {
            case "CIR":
                return new Circle();
            case "SQU":
                return new Square();
            case "REC":
                return new Rectangle();
        }
        return null;
    }
}
