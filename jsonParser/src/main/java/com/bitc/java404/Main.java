package com.bitc.java404;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        System.out.println("JSON 파싱하기");
        
//        JSON이란 : Javascript object notation의 약자로 자바스크립트 객체 표기법이라는 의미로 데이터를 쉽게 전달하고 저장하기 위한 텍스트 기반의 데이터 교환 표준을 의미함
//        자바스크립트의 object 타입을 흉내내서 문자열로 만들어 놓은 것
//        key:value 형태로 데이터를 저장하고 각각의 데이터는 ' , ' 로 구분
//        value로 값 자체를 입력할 수 있고 value로 배열[]이나 object{} 타입을 입력 할 수 있음
//        자바에서 직접 JSON을 사용할 수 없기 때문에 JSON 데이터를 파싱하기 위한 라이브러리가 필요함
        
//        GSON : 구글에서 개발한 자바용 JSON 파싱 라이브러리

        GsonTest gt = new GsonTest();
        gt.createJson();
        System.out.println("-------------\n");

        gt.objectToJson();
        System.out.println("-------------\n");

        gt.jsonToObject();
        System.out.println("-------------\n");

        gt.mapToJson();
        System.out.println("-------------\n");

        gt.jsonToMap();
        System.out.println("-------------\n");

//        gt.jsonStringParser();
        System.out.println("-------------\n");

        gt.Box();

    }
}