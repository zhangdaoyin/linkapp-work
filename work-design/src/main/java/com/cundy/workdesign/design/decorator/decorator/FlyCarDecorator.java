package com.cundy.workdesign.design.decorator.decorator;

import com.cundy.workdesign.design.decorator.vo.Car;

public class FlyCarDecorator extends CarDecorator {
    public FlyCarDecorator(Car decoratorCar) {
        super(decoratorCar);
    }

    @Override
    public void run()
    {
        decoratorCar.run();
        fly();
    }

    private void fly()
    {
        System.out.println("开启飞行模式。。。");
    }
}
