package com.bitc.java404;

import com.google.gson.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

    public void Tago() {
        String jsonData = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL SERVICE.\"},\"body\":{\"items\":{\"item\":[{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406061200,\"depplacename\":\"서울\",\"depplandtime\":20240406051200,\"traingradename\":\"KTX\",\"trainno\":1},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406063200,\"depplacename\":\"서울\",\"depplandtime\":20240406052700,\"traingradename\":\"KTX\",\"trainno\":3},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406070200,\"depplacename\":\"서울\",\"depplandtime\":20240406055700,\"traingradename\":\"KTX\",\"trainno\":5},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406073800,\"depplacename\":\"서울\",\"depplandtime\":20240406063200,\"traingradename\":\"KTX\",\"trainno\":7},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406074800,\"depplacename\":\"서울\",\"depplandtime\":20240406064200,\"traingradename\":\"KTX\",\"trainno\":233},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406080700,\"depplacename\":\"서울\",\"depplandtime\":20240406065600,\"traingradename\":\"KTX\",\"trainno\":9},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406083200,\"depplacename\":\"서울\",\"depplandtime\":20240406072700,\"traingradename\":\"KTX\",\"trainno\":11},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406084700,\"depplacename\":\"서울\",\"depplandtime\":20240406074900,\"traingradename\":\"KTX\",\"trainno\":13},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406090200,\"depplacename\":\"서울\",\"depplandtime\":20240406075700,\"traingradename\":\"KTX\",\"trainno\":15},{\"adultcharge\":17200,\"arrplacename\":\"대전\",\"arrplandtime\":20240406095500,\"depplacename\":\"서울\",\"depplandtime\":20240406081100,\"traingradename\":\"KTX\",\"trainno\":121}]},\"numOfRows\":10,\"pageNo\":1,\"totalCount\":66}}}";

        Gson gson = new Gson();

        TagoDTO tago = gson.fromJson(jsonData, TagoDTO.class);
        TagoResponseDTO response = tago.getResponse();
        TagoHeaderDTO header = response.getHeader();
        TagoBodyDTO body = response.getBody();
        TagoItemsDTO items = body.getItems();
        List<TagoItemDTO> itemList = items.getItem();

        for(TagoItemDTO item : itemList){
            System.out.println("열차번호 : " + item.getTrainno());
            System.out.println("열차종류 : " + item.getTraingradename());
            System.out.println("출발지 : " + item.getDepplacename());
            System.out.println("출발시간 : " + item.getDepplandtime());
            System.out.println("도착지 : " + item.getArrplacename());
            System.out.println("도착시간 : " + item.getArrplandtime());
            System.out.println("열차운임 : " + item.getAdultcharge());
        }

    }



    public void tagoParserUrl(String serviceUrl) throws IOException {
//        열차정보를 저장할 List
        List<TagoItemDTO> itemList = null;

//        열차 정보를 제공하는 서비스의 url 정보를 입력하기 위한 자바에서 제공하는 URL 클래스 객체
        URL url = null;
//        지정한 URL을 기반으로 HTTP 프로토콜로 접속하여 데이터를 가져오는 클래스
        HttpURLConnection urlConn = null;
//        HttpURLConnection을 통해서 서비스에 접근하여 가져온 데이터를 빠르게 사용하기 위해서 BufferedReader를 사용함
        BufferedReader reader = null;

        try {
//            매개변수로 받아온 서비스 주소를 URL 클래스 타입의 객체로 생성
            url = new URL(serviceUrl);
//            openConnection() 을 사용하여 지정한 url로 접속
//            접속 정보를 HttpURLConnection 타입의 객체에 넘김
            urlConn = (HttpURLConnection) url.openConnection();
//            접속방식을 GET타입으로 설정
            urlConn.setRequestMethod("GET");

//            getInputStream()을 사용하여 접속한 서비스에서 데이터를 가져옴
//            BufferedReader를 사용하여 서비스를 제공하는 곳에서 데이터를 가져와서 버퍼에 저장후 한 번에 가져옴
            reader = new BufferedReader(new InputStreamReader((urlConn.getInputStream())));
            
//            StringBuilder 혹은 StringBuffer 타입을 사용하는 이유
//            String 타입은 2개 이상의 문자열을 합하여 하나의 문자열을 생성 시 기존 문자열에 새로운 문자열을 합하여 하나의 길다란 문자열을 만드는 것이 아니라, 기존의 문자열이 저장되어 있는 메모리 공간을 그대로 두고, 새로운 메모리 공간을 생성하여 하나의 길다란 문자열을 입력하여 사용자에게 제공하는 형태임
//            String 타입을 통한 빈번한 문자열의 연결은 비효율적인 메모리 사용을 하게 되기 때문에 StringBuilder, StringBuffer 타입을 사용하는 것이 좋음
//            StringBuilder, StringBuffer 타입은 객체 생성 시 만들어진 하나의 메모리 공간에서 데이터를 추가, 수정, 삭제하는 것이 가능하기 때문에 메모리를 효율적으로 사용할 수 있음
//            StringBuffer는 스레드에 안전함 (속도가 조금 느리지만 멀티스레드 환경에서 데이터 무결성을 보장해준다)
//            StringBuilder는 스레드에 안전하지 않다 (속도가 빠르다 싱글스레드 환경에서 사용한다)
//            StringBuilder 타입의 객체를 생성
            StringBuilder sb = new StringBuilder();
            String line = null;

//            HttpURLConnection을 통해서 가져온 네트워크 데이터를 BufferedReader를 통해서 데이터를 한줄씩 가져옴
            while((line = reader.readLine()) != null) {
//                가져온 데이터를 StringBuilder 타입의 문자열 변수 sb에 추가함
                sb.append(line);
            }

            Gson gson = new Gson();
//            sb.toString()을 사용하여 가져온 Json 문자열 데이터를 TagoDTO 클래스 타입으로 파싱
            TagoDTO tago = gson.fromJson(sb.toString(), TagoDTO.class);
//           TagoDTO 클래스 타입의 객체에서 필요한 데이터를 모두 출력
            itemList = tago.getResponse().getBody().getItems().getItem();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
//            사용 후 반드시 외부 리소스 해제
            if (reader != null) {
                reader.close();
            }
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }

        for(TagoItemDTO item : itemList){
            System.out.println("------------------열차 정보------------------");
            System.out.println("열차번호 : " + item.getTrainno());
            System.out.println("열차종류 : " + item.getTraingradename());
            System.out.println("출발지 : " + item.getDepplacename());
            System.out.println("출발시간 : " + item.getDepplandtime());
            System.out.println("도착지 : " + item.getArrplacename());
            System.out.println("도착시간 : " + item.getArrplandtime());
            System.out.println("열차운임 : " + item.getAdultcharge());
            System.out.println("--------------------------------------------\n");
        }
    }



//    문제 1) 영화 진흥원 api 중 일간 박스 오피스 api를 이용하여 지정한 날짜의 박스 오피스 내용을 가져와서 화면에 출력하는 프로그램을 작성

//    메소드명: dailyBoxOfficeUrl(String url);
//    main 메소드에서 dailyBoxOfficeUrl()로 url 전달 시 날짜를 입력할 수 있도록 작성
//    출력 정보 : 랭크, 영화 코드, 영화명, 개봉일, 일일 관람객 수, 누적 관람객 수

    public void dailyBoxOfficeUrl(String url) throws IOException {
        List<DailyBoxOfficeItemDTO> itemList = null;
        URL url2 = null;
        HttpURLConnection urlConn = null;
        BufferedReader reader = null;

        try {

            url2 = new URL(url);
            urlConn = (HttpURLConnection) url2.openConnection();
            urlConn.setRequestMethod("GET");
            reader = new BufferedReader(new InputStreamReader((urlConn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            Gson gson = new Gson();

            BoxOfficeDTO boxOffice = gson.fromJson(sb.toString(), BoxOfficeDTO.class);
            itemList = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();



        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                reader.close();
            }
            if (urlConn != null) {
                urlConn.disconnect();
            }
        }


        for(DailyBoxOfficeItemDTO item : itemList) {
            System.out.println("영화 순위 : " + item.getRank());
            System.out.println("영화 코드 : " + item.getMovieCd());
            System.out.println("영화 이름 : " + item.getMovieNm());
            System.out.println("개봉 일자 : " + item.getOpenDt());
            System.out.println("일일 관람객 수 : " + item.getAudiCnt());
            System.out.println("누적 관람객 수 : " + item.getAudiAcc());
            System.out.println("--------------------------------------------------\n");
        }

    }



    public void jsonToXml() throws Exception {
//        JAXB 라이브러리를 사용하여 XML 파싱
//        JAXB : 자바에서 xml 데이터 파싱을 도와주는 라이브러리
//        JAXB가 Java9부터 기본 라이브러리에서 제외됨
//        Json 문자열 파싱과 동일하게 미리 해당 데이터와 맞는 DOT(혹은 VO) 클래스를 선언하여 xml 데이터를 파싱
//        종속성 추가가 필요함
//        jakarta.xml.bind-api
//        jakarta.activation-api
//        jaxb-impl
        
//        Marshal : 자바 클래스를 xml 데이터로 변환
//        UnMarshal : xml 데이터를 자바 클래스 타입의 객체로 변환

        JAXBContext jc = JAXBContext.newInstance(PharmacyDTO.class);
        Unmarshaller um = jc.createUnmarshaller();
        
        PharmacyDTO pharmacy = (PharmacyDTO) um.unmarshal(new File("c:\\Java404\\pharmacy.xml"));
        List<PharmacyItemDTO> itemList = pharmacy.getBody().getItems().getItem();
        
        for(PharmacyItemDTO item : itemList) {
            System.out.println("약국 번호 : " + item.getHpid());
            System.out.println("약국 이름 : " + item.getDutyName());
            System.out.println("전화 번호 : " + item.getDutyTel1());
            System.out.println("약국 주소 : " + item.getDutyAddr());
            System.out.println("개장 시간 : " + item.getDutyTime1s());
            System.out.println("폐장 시간 : " + item.getDutyTime1c());
            System.out.println("--------------------------------------------------------");
        }
    }


    public void xmlToObjectUrl(String serviceUrl) throws Exception {
        List<PharmacyItemDTO> itemList = null;

        URL url = null;
        HttpURLConnection urlConn = null;
        BufferedReader reader = null;

        try {
            url = new URL(serviceUrl);
            urlConn = (HttpURLConnection) url.openConnection();
            urlConn.setRequestMethod("GET");

            JAXBContext jc = JAXBContext.newInstance(PharmacyDTO.class);
            Unmarshaller um = jc.createUnmarshaller();

            PharmacyDTO pharmacy = (PharmacyDTO) um.unmarshal(url);
            itemList = pharmacy.getBody().getItems().getItem();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(urlConn != null) {urlConn.disconnect();}
        }

        System.out.println("--------------------------------------------------------");
        for(PharmacyItemDTO item : itemList) {
            System.out.println("약국 번호 : " + item.getHpid());
            System.out.println("약국 이름 : " + item.getDutyName());
            System.out.println("전화 번호 : " + item.getDutyTel1());
            System.out.println("약국 주소 : " + item.getDutyAddr());
            System.out.println("개장 시간 : " + item.getDutyTime1s());
            System.out.println("폐장 시간 : " + item.getDutyTime1c());
            System.out.println("--------------------------------------------------------");
        }
    }


}
