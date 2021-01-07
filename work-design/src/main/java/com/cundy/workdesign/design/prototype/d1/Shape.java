package com.cundy.workdesign.design.prototype.d1;

/**
 * 实现了Cloneable接口的抽象类
 */
public abstract class Shape implements Cloneable {

    private String id;
    protected String type;
    protected abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }


    public Object clone()
    {
        Object clone = null;
        try{
            clone = super.clone();
        }catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        return clone;
    }
}
