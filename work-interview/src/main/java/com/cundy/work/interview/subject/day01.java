package com.cundy.work.interview.subject;

/**
 * 面试试题汇总
 */
public class day01 {

    /**
     * 1.数据比较
     * == 是一个比较运算符，基本数据类型比较的是值，引用数据类型比较的是地址值。
     * （比较地址值即是指是否为同一个对象的引用）
     *
     * equals() 是一个方法，只能比较引用数据类型。重写前比较的是地址值，重写后一般是比较对象的属性。
     * 扩展：
     * java中的数据类型，可以分为两类
     * 1.基本数据类型，也称为原始数据类型
     * byte,short,char,int,long,float,double,boolean,他们之间的比较，应用双等号（==），
     * 比较的是他们的值。
     * 2.复合数据类型
     * 当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址，所以，除非是同一个new出来的对象
     * ，他们的比较结果为true，否则比较结果都为false
     *
     * java当中所有的类都是继承与Object这个基础类的，在Object中的基础类中定义了一个equals的方法，
     * 这个方法的初始行为是比较对象的内存地址。
     *
     * 但在一些类库当中这个方法被覆盖掉了，如String Integer Date在这些类中equals有其自身的实现，而不在是比较类在堆内存中的存放地址了。
     *
     * 对于复合数据类型之间进行equals 比较，在没有复写equals方法的情况下，他们之间的比较还是基于
     * 他们在内存中的存放位置的地址值，因为Object的equals方法也是用双等号（==）进行比较的，所以比较后的结果跟双等号（==）
     * 的结果相同
     *
     * @param args
     */
    public static void main(String[] args) {

        String a = new String("foo");
        String b = new String("foo");
        String c = "foo";
        String d = "f" + "o" + "o";
        String e = "fo";
        String f = "o";
        String g = e + f;
        System.out.println("result a == b :         " + a == b);
        System.out.println("result a == c :         " + a == c);
        System.out.println("result c == d :         " + c == d);
        System.out.println("result d == g :         " + d == g);

        System.out.println("result a equals b :     " + a.equals(b));
        System.out.println("result a equals c :     " + a.equals(c));
        System.out.println("result c equals d :     " + c.equals(d));
        System.out.println("result d equals g :     " + d.equals(g));


        Object o1 = "12";
        Object o2 = "12";

        System.out.println("result o1 equals o2 :   " + o1.equals(o2));

        System.out.println("==");
    }

}
