package com.bitc.java404;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("자바 input/output stream 사용하기");

        JavaInputStream jis = new JavaInputStream();
        try {
            System.out.println("\n--------------------read1-----------------------\n");
            jis.read1();
            System.out.println("\n--------------------read2-----------------------\n");
            jis.read2();
        } catch (IOException e) {
            System.out.println("파일을 읽는 도중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}