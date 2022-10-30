package com.entities;

public class PageAble {
    private int size = 2;
    private int current;

    public PageAble(int current) {
        this.current = current;
    }

    public PageAble() {
    }

    //method choose index first select
    public int getFirstSelect(){
        return (this.current -1)*size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
