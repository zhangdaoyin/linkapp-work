package com.cundy.workdesign.design.decorator.entity;

import com.cundy.workdesign.design.decorator.vo.Car;

public class BenCar implements Car {

    @Override
    public void run() {
        System.out.println("奔驰出发了。。。");
    }
}
