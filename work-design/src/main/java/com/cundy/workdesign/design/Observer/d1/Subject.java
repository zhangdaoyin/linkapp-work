package com.cundy.workdesign.design.Observer.d1;

import com.cundy.workdesign.design.Observer.d2.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private int state;
    private List<Observer> observers = new ArrayList<>();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void attach(Observer observer)
    {
        observers.add(observer);
    }

    public void notifyAllObservers()
    {
        for (Observer observer: observers) {
            observer.update();
        }
    }
}
