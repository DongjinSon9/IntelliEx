package com.bitc.java404;

public class Student {
    private int no;
    private String name;

    public Student(int no, String name) {
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Student [no=" + no + ", name=" + name + "]";
    }
}
