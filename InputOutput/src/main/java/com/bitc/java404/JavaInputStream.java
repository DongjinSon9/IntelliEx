package com.bitc.java404;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JavaInputStream {
    public void read1() throws IOException {
        InputStream is = new FileInputStream("c:\\Java404\\test.txt");

        int readbyte;

        while(true) {
            readbyte = is.read();
            if (readbyte == -1) {
                break;
            }
            System.out.println((char)readbyte);
        }
        is.close();
    }

}
