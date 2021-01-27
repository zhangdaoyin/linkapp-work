package com.cundy.workdesign.Object;

import com.cundy.workdesign.design.Observer.d2.Observer;
import org.openjdk.jol.info.ClassLayout;

public class Obj001 {

    private static class Ojj
    {
        int m;
        Object o;
        String s;
    }

    public static void main(String[] args) {
//        Ojj j = new Ojj();

        String s = new String();
        System.out.println(ClassLayout.parseInstance(s).toPrintable());


    }
}
