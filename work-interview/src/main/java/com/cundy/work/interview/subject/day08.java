package com.cundy.work.interview.subject;

/**
 *
 */
public class day08 {

    public static void main(String[] args) {
//        1.
//        System.out.println(Son.num);

//        2.
        System.out.println(Son.suu);
    }
}
    class Father
    {
        public static int num = 10;

        static {
            System.out.println("父类静态代码块");
        }
    }

    class Son extends Father
    {
        public static int suu = 20;
        static
        {
            System.out.println("子类静态代码块");
        }
    }
//1.
//父类静态代码块
//10


//2
//父类静态代码块
//子类静态代码块
//20