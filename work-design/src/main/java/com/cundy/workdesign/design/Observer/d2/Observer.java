package com.cundy.workdesign.design.Observer.d2;

import com.cundy.workdesign.design.Observer.d1.Subject;

public abstract class Observer {

    protected Subject subject;
    public abstract void update();
}
