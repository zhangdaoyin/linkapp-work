package com.cundy.workdesign.design.singleton.vo;

public class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject(){}

    public static SingleObject getInstance()
    {
        return instance;
    }

    public void showMessage()
    {
        System.out.println("a new SingleObject ");
    }


    //懒汉式
    public static SingleObject getInstance1()
    {
        if (instance == null)
        {
            instance = new SingleObject();
        }
        return instance;
    }

    //懒汉式 +同步锁
    public static synchronized SingleObject getInstance2()
    {
        if (instance == null)
        {
            instance = new SingleObject();
        }
        return instance;
    }

    //饿汉式
    public static SingleObject getInstance3()
    {
        return instance;
    }

    //双重校验锁DCL double-checked locking
    public static SingleObject getInstance4()
    {
        if (null == instance)
        {
            synchronized (SingleObject.class)
            {
                if (null == instance)
                {
                    instance = new SingleObject();
                }
            }
        }
        return instance;
    }

    //静态内部类
    private static class SingleHodler{
        private static final SingleObject INSTANCE = new SingleObject();
    }

    public static final SingleObject getInstance5()
    {
        return SingleHodler.INSTANCE;
    }

    //枚举
    public enum Singleton
    {
        INSTANCE;
        public void ss()
        {}
    }

    
}
