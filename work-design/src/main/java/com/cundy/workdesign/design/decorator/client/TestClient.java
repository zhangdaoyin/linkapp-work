package com.cundy.workdesign.design.decorator.client;

import com.cundy.workdesign.design.decorator.decorator.AutoCarDecorator;
import com.cundy.workdesign.design.decorator.decorator.CarDecorator;
import com.cundy.workdesign.design.decorator.decorator.FlyCarDecorator;
import com.cundy.workdesign.design.decorator.entity.BenCar;
import com.cundy.workdesign.design.decorator.entity.BmwCar;
import com.cundy.workdesign.design.decorator.vo.Car;

public class TestClient {
    public static void main(String[] args) {
        Car baoCar = new BmwCar();
        Car benCar = new BenCar();

        //创建自动驾驶的奔驰汽车
        CarDecorator autoBenCar = new AutoCarDecorator(benCar);

        //创建飞行的宝马汽车
        CarDecorator flyBmwCar = new FlyCarDecorator(baoCar);

        //创建飞行的自动驾驶宝马汽车
        CarDecorator flyAutoBmwCar = new FlyCarDecorator(new AutoCarDecorator(baoCar));
        baoCar.run();

        benCar.run();

        autoBenCar.run();

        flyBmwCar.run();

        flyAutoBmwCar.run();

    }
}
