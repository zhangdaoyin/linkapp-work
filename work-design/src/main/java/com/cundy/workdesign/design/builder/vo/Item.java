package com.cundy.workdesign.design.builder.vo;

import lombok.Data;

/**
 * 食物条目和食品包装的接口
 */
public interface Item {

    public String name();//名称

    public Packing packing();//包装

    public float price();//价格
}
