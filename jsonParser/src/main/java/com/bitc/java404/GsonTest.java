package com.bitc.java404;

import com.google.gson.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GsonTest {
//    Gson 객체 생성하기
    public void createGson() {
        Gson gson1 = new Gson();  // 일반 Gson 객체 생성
        Gson gson2 = new GsonBuilder().create();  // 빌더 타입으로 Gson 객체 생성하기
    }

//    Json 생성하기
    public void createJson() {
        Gson gson = new Gson();

//        Json객체 생성
        JsonObject jobj = new JsonObject();
//        addProperty() : Json 객체에 key와 value로 이루어진 데이터를 추가
        jobj.addProperty("name", "아이유");
        jobj.addProperty("gender", "여성");
        jobj.addProperty("job", "가수");

        String jsonStr = gson.toJson(jobj);

        System.out.println(jsonStr);
    }
    
//    Java Object를 Json으로 변환
    public void objectToJson() {
//        Student 클래스 타입의 객체 생성 및 데이터 추가
        Student std = new Student(1, "아이유");
//        Student 클래스 타입의 객체에 저장된 내용 확인
        System.out.println("java 객체 std의 값 : " + std.toString());

//        Gson 객체 생성
        Gson gson = new Gson();
//        Student 클래스 타입의 객체를 Gson을 사용하여 Json 문자열로 변환
        String jsonString = gson.toJson(std);

        System.out.println(jsonString);

    }
    
//    Json을 Java Object로 변환
    public void jsonToObject() {
//        json 문자열
        String str = "{\"no\":\"2\", \"name\":\"유인나\"}";

//        gson 객체 생성
        Gson gson = new Gson();
//        Student 클래스 타입의 변수 생성
//        Gson을 사용하여 Json 문자열을 지정한 Student 클래스 타입으로 파싱
        Student std = gson.fromJson(str, Student.class);

        System.out.println(std.toString());
    }
    
//    Map 타입을 Json으로 변환
    public void mapToJson() {
//        HashMap 타입의 변수 생성 후 데이터 추가
        Map<String, String> mapDate = new HashMap<>();
        mapDate.put("no", "3");
        mapDate.put("name","유재석");

//        Gsonh 객체 생성
        Gson gson = new Gson();
//        Gson을 사용하여 map 타입의 데이터를 Json 문자열로 변환
        String jsonStr = gson.toJson(mapDate);

        System.out.println(jsonStr);
    }
    
//    Json을 Map 타입으로 변환
    public void jsonToMap() {
        String strData = "{'no':'4', 'name':'카리나'}";
        Gson gson = new Gson();

//        변환될 데이터를 저장할 Map 타입의 변수 생성
//        key는 문자열로 사용하는 것이 확실하기 때문에 String으로 설정
//        value는 어떤 데이터가 입력될지 모르기 때문에 Object 타입으로 설정
        Map<String, Object> mapData = gson.fromJson(strData, Map.class);

//        Map 타입으로 변환된 데이터를 모두 출력
        for(Map.Entry<String, Object> entry : mapData.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }


    public void jsonStringParser() {
//        원본 Json 문자열 데이터
        String json = "{'no':1, 'students':['아이유', '유인나'], 'subject':{'name':'java', 'professor':'ihd'}}";

//        Gson에서 제공하는 JsonParser를 사용하여 Json 데이터를 파싱, JsonElement 객체로 반환
        JsonElement jele = JsonParser.parseString(json);

//        파싱된 결과인 JsonElement 객체에서 JsonObject 타입으로 변환
        JsonObject jobj = jele.getAsJsonObject();

//        변환된 데이터인 JsonObject 객체에서 최상위 요소 중 key에 대한 value가 리터럴 데이터를 출력
        long no = jobj.get("no").getAsLong();
        System.out.println("no : " + no);

//        변환된 데이터인 JsonObject 객체에서 최상위 요소 중 key에 대한 value가 JsonArray인 데이터를 출력
        JsonArray stdArr = jobj.get("student").getAsJsonArray();

//        JsonArray 다입에 저장된 모든 데이터를 반복문으로 출력
        for(int i = 0; i < stdArr.size(); i++) {
            String name = stdArr.get(i).getAsString();
            System.out.println("학생[" + i + "] : " + name);
        }


//        변환된 데이터인 JsonObject 객체에서 최상위 요소 중 key에 대한 value가 JsonObject인 데이터를 출력
        JsonObject sjObj = jobj.get("subject").getAsJsonObject();
//        부모인 JsonObject 타입의 객체에서 원하는 데이터를 출격
        String sjObjName = sjObj.get("name").getAsString();
        String sjObjProfessor = sjObj.get("professor").getAsString();
        System.out.println("과목명 : " + sjObjName);
        System.out.println("담당 교수 : " + sjObjProfessor);
    }

    public  void  Box() {
        String jsonData = "{\"boxOfficeResult\":{\"boxofficeType\":\"일별 박스오피스\",\"showRange\":\"20240403~20240403\",\"dailyBoxOfficeList\":[{\"rnum\":\"1\",\"rank\":\"1\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20234675\",\"movieNm\":\"파묘\",\"openDt\":\"2024-02-22\",\"salesAmt\":\"405620507\",\"salesShare\":\"25.9\",\"salesInten\":\"44032084\",\"salesChange\":\"12.2\",\"salesAcc\":\"106996510599\",\"audiCnt\":\"42959\",\"audiInten\":\"4562\",\"audiChange\":\"11.9\",\"audiAcc\":\"11084693\",\"scrnCnt\":\"1110\",\"showCnt\":\"3636\"},{\"rnum\":\"2\",\"rank\":\"2\",\"rankInten\":\"0\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20231041\",\"movieNm\":\"댓글부대\",\"openDt\":\"2024-03-27\",\"salesAmt\":\"270664942\",\"salesShare\":\"17.3\",\"salesInten\":\"-18364239\",\"salesChange\":\"-6.4\",\"salesAcc\":\"5980963163\",\"audiCnt\":\"29061\",\"audiInten\":\"-2007\",\"audiChange\":\"-6.5\",\"audiAcc\":\"640509\",\"scrnCnt\":\"824\",\"showCnt\":\"2737\"},{\"rnum\":\"3\",\"rank\":\"3\",\"rankInten\":\"7\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20247780\",\"movieNm\":\"비키퍼\",\"openDt\":\"2024-04-03\",\"salesAmt\":\"159399610\",\"salesShare\":\"10.2\",\"salesInten\":\"152100610\",\"salesChange\":\"2083.9\",\"salesAcc\":\"189255610\",\"audiCnt\":\"17837\",\"audiInten\":\"17026\",\"audiChange\":\"2099.4\",\"audiAcc\":\"20909\",\"scrnCnt\":\"689\",\"showCnt\":\"1543\"},{\"rnum\":\"4\",\"rank\":\"4\",\"rankInten\":\"0\",\"rankOldAndNew\":\"NEW\",\"movieCd\":\"20247673\",\"movieNm\":\"오멘: 저주의 시작\",\"openDt\":\"2024-04-03\",\"salesAmt\":\"137902840\",\"salesShare\":\"8.8\",\"salesInten\":\"137902840\",\"salesChange\":\"100\",\"salesAcc\":\"141925840\",\"audiCnt\":\"14202\",\"audiInten\":\"14202\",\"audiChange\":\"100\",\"audiAcc\":\"14649\",\"scrnCnt\":\"632\",\"showCnt\":\"1380\"},{\"rnum\":\"5\",\"rank\":\"5\",\"rankInten\":\"7\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20201502\",\"movieNm\":\"유미의 세포들 더 무비\",\"openDt\":\"2024-04-03\",\"salesAmt\":\"74981960\",\"salesShare\":\"4.8\",\"salesInten\":\"70564960\",\"salesChange\":\"1597.6\",\"salesAcc\":\"104249960\",\"audiCnt\":\"11557\",\"audiInten\":\"10926\",\"audiChange\":\"1731.5\",\"audiAcc\":\"15594\",\"scrnCnt\":\"402\",\"showCnt\":\"1236\"},{\"rnum\":\"6\",\"rank\":\"6\",\"rankInten\":\"-3\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20248496\",\"movieNm\":\"고질라 X 콩: 뉴 엠파이어\",\"openDt\":\"2024-03-27\",\"salesAmt\":\"89543897\",\"salesShare\":\"5.7\",\"salesInten\":\"-40898224\",\"salesChange\":\"-31.4\",\"salesAcc\":\"3596851779\",\"audiCnt\":\"9046\",\"audiInten\":\"-4137\",\"audiChange\":\"-31.4\",\"audiAcc\":\"358837\",\"scrnCnt\":\"656\",\"showCnt\":\"1405\"},{\"rnum\":\"7\",\"rank\":\"7\",\"rankInten\":\"0\",\"rankOldAndNew\":\"NEW\",\"movieCd\":\"20248222\",\"movieNm\":\"기동전사 건담 시드 프리덤\",\"openDt\":\"2024-04-03\",\"salesAmt\":\"82055617\",\"salesShare\":\"5.2\",\"salesInten\":\"82055617\",\"salesChange\":\"100\",\"salesAcc\":\"209466077\",\"audiCnt\":\"8306\",\"audiInten\":\"8306\",\"audiChange\":\"100\",\"audiAcc\":\"18352\",\"scrnCnt\":\"418\",\"showCnt\":\"670\"},{\"rnum\":\"8\",\"rank\":\"8\",\"rankInten\":\"0\",\"rankOldAndNew\":\"NEW\",\"movieCd\":\"20231677\",\"movieNm\":\"남은 인생 10년\",\"openDt\":\"2023-05-24\",\"salesAmt\":\"71882273\",\"salesShare\":\"4.6\",\"salesInten\":\"71882273\",\"salesChange\":\"100\",\"salesAcc\":\"1540800873\",\"audiCnt\":\"7918\",\"audiInten\":\"7918\",\"audiChange\":\"100\",\"audiAcc\":\"145550\",\"scrnCnt\":\"286\",\"showCnt\":\"385\"},{\"rnum\":\"9\",\"rank\":\"9\",\"rankInten\":\"-5\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20236295\",\"movieNm\":\"듄: 파트2\",\"openDt\":\"2024-02-28\",\"salesAmt\":\"71630851\",\"salesShare\":\"4.6\",\"salesInten\":\"-16513367\",\"salesChange\":\"-18.7\",\"salesAcc\":\"22195698141\",\"audiCnt\":\"5056\",\"audiInten\":\"-1891\",\"audiChange\":\"-27.2\",\"audiAcc\":\"1905379\",\"scrnCnt\":\"239\",\"showCnt\":\"351\"},{\"rnum\":\"10\",\"rank\":\"10\",\"rankInten\":\"-2\",\"rankOldAndNew\":\"OLD\",\"movieCd\":\"20236230\",\"movieNm\":\"씬\",\"openDt\":\"2024-04-03\",\"salesAmt\":\"40129559\",\"salesShare\":\"2.6\",\"salesInten\":\"30472559\",\"salesChange\":\"315.5\",\"salesAcc\":\"52074559\",\"audiCnt\":\"4586\",\"audiInten\":\"3513\",\"audiChange\":\"327.4\",\"audiAcc\":\"5867\",\"scrnCnt\":\"386\",\"showCnt\":\"588\"}]}}";


        Gson gson = new Gson();
//        미리 생성해 놓은 DTO 클래스(혹은 VO 클래스) 타입에 맞춰서 Gson 라이브러리가 데이터를 파싱함
//        최상위 클래스가 BoxOfficeDTO 클래스이므로 Json 문자열이 데이터가 BoxOfficeDTO 클래스 타입의 객체에 모두 저장됨
        BoxOfficeDTO boxOffice = gson.fromJson(jsonData, BoxOfficeDTO.class);
        BoxOfficeResultDTO boxOfficeResult = boxOffice.getBoxOfficeResult();
//        일간 영화 순위 정보가 있는 DailyBoxOfficeItemDTO 클래스 타입의 객체를 List에 담아 모두 가져옴
        List<DailyBoxOfficeItemDTO> itemList = boxOfficeResult.getDailyBoxOfficeList();
        

        for(DailyBoxOfficeItemDTO item : itemList){
            System.out.println("순위 : " + item.getRank() + ", 제목 : " + item.getMovieNm());
        }
        System.out.println();

    }
}
