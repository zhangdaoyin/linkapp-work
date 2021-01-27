package com.cundy.work.interview.subject;

/**
 * 3.StringBuffer和StringBuilder的区别
 *
 * 1.线程安全
 * StringBuffer:线程安全，因为StringBuffer的所有公开方法都是synchronized修饰的，
 * StringBuilder：线程不安全， 集成了AbstractStringBuilder
 *
 * 2.缓冲区
 * StringBuffer每次获取toString都会直接使用缓存区的toStringCache值来构造一个字符串。
 * StringBuilder每次都需要复制一次字符数组，再构造一个字符串。
 *
 * 3.性能
 * StringBuffer 保证了线程安全，但是牺牲了性能
 * StringBuilder保证了性能可用性，但是牺牲了安全性
 *
 *
 * 使用场景：
 * StringBuffer：在频繁的字符串运算（拼接，替换，删除等），并且运行在多线程环境中，则可以考虑使用StringBuffer,如XML解析，Http参数解析和封装
 *
 * StringBuilder:在频繁进行字符串运算（拼接，替换，删除），并且在单线程的环境中，则可以考虑使用StringBuilder,如SQL语句的拼装，JSON封装
 */
public class day03 {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();

    }
}
