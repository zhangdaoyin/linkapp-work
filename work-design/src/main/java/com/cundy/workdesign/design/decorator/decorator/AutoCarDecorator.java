package com.cundy.workdesign.design.decorator.decorator;

import com.cundy.workdesign.design.decorator.vo.Car;

public class AutoCarDecorator extends CarDecorator {


    public AutoCarDecorator(Car decoratorCar) {
        super(decoratorCar);
    }

    @Override
    public void run()
    {
        decoratorCar.run();
        autoRun();
    }

    private void autoRun()
    {
        System.out.println("开启自动驾驶模式。。。");
    }
}
