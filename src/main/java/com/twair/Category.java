package com.twair;

/**
 * Created by user on 01-04-2016.
 */
public class Category {
    private String name;

    public Category(String className, String code, int seats) {
        this.name = className;
        this.code = code;
        this.capacity = seats;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String code;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private int capacity;

}
