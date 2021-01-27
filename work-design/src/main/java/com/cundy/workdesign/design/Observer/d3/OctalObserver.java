package com.cundy.workdesign.design.Observer.d3;

import com.cundy.workdesign.design.Observer.d1.Subject;
import com.cundy.workdesign.design.Observer.d2.Observer;

public class OctalObserver extends Observer {
    public OctalObserver(Subject subject)
    {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String:" + Integer.toOctalString(subject.getState()));
    }
}
