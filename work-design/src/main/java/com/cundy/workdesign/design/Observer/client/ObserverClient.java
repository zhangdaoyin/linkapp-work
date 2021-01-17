package com.cundy.workdesign.design.Observer.client;

import com.cundy.workdesign.design.Observer.d1.Subject;
import com.cundy.workdesign.design.Observer.d3.OctalObserver;

public class ObserverClient {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new OctalObserver(subject);

        System.out.println("ss");
        subject.setState(15);
    }
}
