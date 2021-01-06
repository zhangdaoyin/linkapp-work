package com.cundy.workdesign.design.builder.dto;

import com.cundy.workdesign.design.builder.vo.Packing;

public class Bottle implements Packing {
    @Override
    public String pack() {
        return "瓶装";
    }
}
