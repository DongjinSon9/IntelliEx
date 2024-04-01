package com.bitc.java404;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public class JavaInputStream {
    public void read1() throws IOException {
//        Input stream 클래스가 추상클래스이므로 객체를 생성하는 것이 불가능
//        자식 클래스 타입의 객체(FileInputStream)를 부모클래스인 InputStream 타입의 변수에 저장하여 사용함
        InputStream is = new FileInputStream("c:\\Java404\\test.txt");

        int readbyte; // 데이터를 저장할 변수

        while(true) {
//            read() 사용 시 단 하나의 byte만 읽어옴, 읽어온 데이터가 없을 경우 -1 반환
            readbyte = is.read();
            if (readbyte == -1) {
                break;
            }
//            read()로 받아온 데이터를 문자로 출력하기 위해서 char 타입으로 강제 형변환
            System.out.println((char)readbyte);
        }
//        메모리 반환. 스트림의 사용이 종료 시 반드시 close()로 해당 스트림을 닫아줘야 함
//        스트림은 자바 외부에 존재하는 리소스이므로 사용 후 스트림을 닫지 않으면 메모리를 계속 사용하게 되어
//        메모리 누수 현상이 발생하게 됨
        is.close();
    }

//    read(byte[] b) 사용하기
    public void read2() throws IOException {
//        파일 열기
        InputStream is = new FileInputStream("c:\\Java404\\test.txt");
//        가져온 데이터의 크기를 저장할 변수
        int readByteNo;
//        파일 내용을 저장할 byte타입 배열
        byte[] readBytes = new byte[3];
//        가져온 데이터를 문자열 타입으로 저장할 변수
        String data = "";

//        가져올 데이터가 없을 때까지 파일의 모든 데이터를 가져옴
        while(true) {
//            read(byte[] buff) 메소드를 사용하여 데이터를 지정한 배열의 크기만큼 가져옴
//            가져올 데이터가 없을 경우 -1을 반환
            readByteNo = is.read(readBytes);

            if(readByteNo == -1){
                break;
            }

//            String 클래스의 생성자를 사용하여 byte 배열의 데이터를 String 타입으로 변환
//            첫번째 매개변수 : 변환할 byte[] 배열
//            두번째 매개변수 : 변환을 시작할 index 번호
//            세번째 매개변수 : 변환할 크기
            data += new String(readBytes, 0,readByteNo);
        }
        System.out.println(data);
//        파일 닫기
        is.close();
    }

    public void read3() throws IOException {
//        파일 열기
        InputStream is = new FileInputStream("c:\\Java404\\test.txt");
//        가져온 데이터 크기
        int readByteNo;
//        가져온 데이터를 저장할 배열
        byte[] readBytes = new byte[8];

//        데이터를 지정한 위치에서 지정한 크기만큼 가져오기
//        readByteNo = is.read(readBytes,0,readBytes.length); 주로 사용하는 형태. read2랑 같음
        readByteNo = is.read(readBytes,2,3);
        System.out.println("가져온 데이터 크기 : " + readByteNo);

//        화면 출력
        for(int i = 0; i < readBytes.length; i++) {
            System.out.println(readBytes[i]);
        }
        is.close();

    }

}
