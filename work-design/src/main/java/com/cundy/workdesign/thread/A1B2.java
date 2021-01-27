package com.cundy.workdesign.thread;

import java.util.concurrent.locks.LockSupport;

public class A1B2 {
    static final  Object object = new Object();

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) throws Exception {

        char[] a1 = "1234567".toCharArray();
        char[] b2 = "ABCDFFG".toCharArray();

        t1 = new Thread(() ->{
            for (char c : a1)
            {
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
            LockSupport.unpark(t1);
        },"t1");

        t2 = new Thread(() -> {
            for (char d : b2)
            {
                LockSupport.park();
                System.out.println(d);
                LockSupport.unpark(t1);

            }
            LockSupport.unpark(t2);
        },"t2");
        t1.start();
        t2.start();
    }
}
