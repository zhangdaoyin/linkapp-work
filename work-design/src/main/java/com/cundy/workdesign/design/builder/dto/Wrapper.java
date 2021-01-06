package com.cundy.workdesign.design.builder.dto;

import com.cundy.workdesign.design.builder.vo.Packing;

public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "袋装";
    }
}
