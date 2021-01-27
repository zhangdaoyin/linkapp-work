package com.cundy.work.interview.subject;

/**
 * volatile和synchronized的区别
 *
 * 1.关键字volatile是线程轻量级实现，只能修饰变量，synchronized则是锁的重量级实现，可以修饰方法，代码块。
 * 2.多线程并发访问情况下volatile不会阻塞，而synchronized则会出现阻塞。
 * 3.volatile可以保证数据的可见性，但是不能保证数据的原子性。synchronized可以保证可见性和原子性。因为他会将私有内存和公共内存中的数据做同步。
 * 4.volatile解决了变量在多线程下的可见性。而synchronized解决多线程下资源同步问题。
 */
public class day07 {

    public volatile String name;

    public static void main(String[] args) {
        synchronized (day07.class)
        {
            System.out.println("dddd");
        }
    }
}
