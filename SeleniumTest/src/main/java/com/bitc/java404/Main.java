package com.bitc.java404;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;

public class Main {
    public static void main(String[] args) throws Exception {
//        System.out.println("Hello world!");
//        System.out.println("셀레니움 사용하여 크롤링하기");
//        셀레니움이 웹 브라우저 원격 제어를 하기 위해서 사용하는 웹 드라이버 클래스
//        크롬, 파이어폭스, 엣지, 사파리 브라우저를 지원함
//        WebDriver driver = null;
//        웹 드라이버를 통해서 가져온 html 태그를 저장하고 제어하기 위한 클래스
//        WebElement element = null;

//        셀레니움 설정 정보 입력
////        ("webdriver.사용할 브라우저.driver", "웹드라이버 위치")
//        System.setProperty("wecdriver.chrome.driver", "c:\\chromedriver.exe");

//        크롬 웹 드라이버를 사용 시 추가 옵션을 설정
//        addArguments()를 사용하여 옵션을 설정함
//          --start-maximized : 웹 시작시 최대 크기로 설정
//       	--headless : 웹 브라우저를 띄우지 않고 시작(창은 안 띄우지만 동작은 되고 있는 상태)
//	        --disable-popup-blocking : 팝업창 무시하기
//	        --disable-default-apps : 기본앱 사용하지 않기
//      	--disable-gpu : gpu를 사용하지 않기, 리눅스에서 headless 사용시 필수
//      	--remote-allow-origins : 지정된 연결에서만 리소스 사용 허용, *사용시 모든 연결에서 허용
//      	--no-sandbox : sandbox 프로세스 사용하지 않기, 리눅스에서 headless 사용시 필수
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--remote-allow-origins=*");

//        크롬 드라이버 객체를 생성 시 option 값을 매개변수로 사용하여 추가 옵션 설정
//        웹 드라이버에 크롬 드라이버 객체를 저장
//        driver = new ChromeDriver(options);


//        WebDriver 기본 명령어
//        get(url) : 지정한 url로 접속
//        getCurrentUrl() : 현재 접속한 url 주소 가져오기
//        getTitle() : 현재 접속한 웹 페이지의 title 가져오기
//        findElements(By) : 현재 접속한 웹 페이지 및 지정한 객체에서 By 패턴으로 검색된 모든 html 태그를 List<WebElement> 타입으로 반환
//        findElement(By) : 현재 접속한 웹 페이지 및 지정한 객체에서 By 패턴으로 검색된 html 태그 하나를 WebElement 타입으로 반환
//        getPagSource() : 현재 접속한 페이지의 모든 html 태그를 문자열로 가져옴
//        close() : 웹 브라우저의 탭 닫기
//        quit() : 웹 브라우저 닫기

//        By 패턴 : By 클래스에서 제공하는 html 태그 검색 방식, By.id() 형태로 사용
//        id(id명) : html 태그의 id 속성 값으로 검색
//        name(name명) : html 태그의 name 속성 값으로 검색
//        tagName(tag명) : html 태그의 이름으로 검색
//        className(class명) : html 태그의 class 속성 값으로 검색
//        cssSelector(css선택자) : html 태그를 css 선택자를 사용하여 검색
//        xpath(xpath명) : html 태그를 xpath를 사용하여 검색


//        WebElement 기본 명령어
//        click() : 해당 태그에 클릭 이벤트 발생
//        submit() : form 태그에 있는 submit 이벤트 발생
//        sendKeys(문자열) : 해당 태그에 문자열 입력, 주로 input 태그에 사용하여 사용자 데이터를 추가함
//        clear() : 해당 태그의 내용 삭제
//        getTagName() : 해당 태그의 태그명 가져오기
//        getAttribute(html 속성명) : 해당 태그의 Html 속성 중 지정한 html 속성값을 가져옴
//        getText() : 해당 태그의 시작 태그와 종료 태그 사이의 문자열을 가져옴
//        getCssValue(css 속성명) : 해당 태그에 적용된 css 내용 중 지정한 css 속성값을 가져옴
//        isSelected() : 해당 태그가 선택되어 있는지 확인
//        isEnabled() : 해당 태그가 활성화 상태인지 확인




////        지정한 웹 페이지에 접속하기
//        driver.get("https://www.google.co.kr");
//        try {
////            웹 페이지의 모든 리소스가 로딩되도록 잠시 기다림. >> 3초
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
////        접속 종료
//        driver.quit();


        System.out.println("셀레니움으로 자동 접속");

//        NaverLogin naver = new NaverLogin();
//        naver.login();

//
//        NateLogin nateLogin = new NateLogin();
//        nateLogin.login();


//        CoffeeBeen coffeeBeen = new CoffeeBeen();
//        coffeeBeen.getStoreInfo();

        Starbecks starbecks = new Starbecks();
        starbecks.getStoreInfo();

    }
}