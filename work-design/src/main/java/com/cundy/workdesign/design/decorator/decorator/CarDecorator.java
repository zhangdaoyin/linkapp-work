package com.cundy.workdesign.design.decorator.decorator;

import com.cundy.workdesign.design.decorator.vo.Car;

/**
 * 创建Car的抽象装饰类
 */
public abstract class CarDecorator implements Car {

    protected Car decoratorCar;

    public CarDecorator(Car decoratorCar)
    {
        this.decoratorCar = decoratorCar;
    }

    public void run()
    {
        decoratorCar.run();
    }

}
