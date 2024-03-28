package com.bitc.java404;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Starbecks extends WebBase{
    // 스타벅스 사이트의 매장정보를 가져오는 프로그램 작성

    public Starbecks() {
        System.setProperty(WebBase.Web_Driver_Id,WebBase.Chrome_Driver_Path);
        options = OptionSetup();
        driver = new ChromeDriver(options);
    }

    public ChromeOptions OptionSetup() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--start-maximized");
        opt.addArguments("--disable-popup-blocking");
        opt.addArguments("--remote-allow-origins=*");
//        opt.addArguments("--headless");

        return opt;
    }


    public void getStoreInfo() throws InterruptedException {
        requestUrl = "https://www.starbucks.co.kr/store/store_map.do";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for(int i = 0; i < 10; i++) {
            driver.get(requestUrl);
            Thread.sleep(1000);

            try {
                String script = String.format("getStoreDetail(%d)", i);
//                String s = "getStoreDetail(" + i + ")"; 위랑 같은 거
                js.executeScript(script);
                Thread.sleep(500);

                String html = driver.getPageSource();

//                가져온 문자열을 jsoup으로 파싱
                Document doc = Jsoup.parse(html);
//                css 선택자로 태그명과 클래스값을 함께 사용
                Element shopArea_pop = doc.select("div.shopArea_pop01_inner").first();
//                제목을 저장하고 있는 태그를 한 번에 검색
                Element shopTitle = shopArea_pop.select("header.titl").first().select("h6").first();
//                주소 및 전화번호가 있는 dd 태그를 한 번에 검색
                Elements shopArea_infoWrap = shopArea_pop.select("div.shopArea_infoWrap").first().select("dd");

                Element shopAddrdd = shopArea_infoWrap.get(0);
                Element shopTeldd = shopArea_infoWrap.get(1);

                String shopName = shopTitle.text();
                String shopAddr = shopAddrdd.text();
                String shopTel = shopTeldd.text();

                System.out.println("점포 (" + (i+1) + ") : " + shopName);
                System.out.println("주소 : " + shopAddr);
                System.out.println("연락처 : " + shopTel);
                System.out.println("-----------------------------------------------------------\n");

            } catch (Exception e) {

            }
        }
        driver.quit();

    }

}
