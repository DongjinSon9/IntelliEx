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
                js.executeScript(script);
                Thread.sleep(2000);

                String html = driver.getPageSource();
                Document doc = Jsoup.parse(html);

                Element shopArea_pop = doc.select("div.shopArea_pop").first();
                Element shopTitle = shopArea_pop.select("h6").first();
                Element box_info = shopArea_pop.select("div.box_info").first();
                Element shopArea_infoWrap = box_info.select("div.shopArea_infoWrap").first();

                Element shopAddrdd = shopArea_infoWrap.select("dd").first();
                Element shopTeldd = shopArea_infoWrap.select("dd").get(2);
                Element cafetimeWrap = shopArea_pop.select("div.cafetimeWrap").first();

                String shopName = shopTitle.text();
                String shopAddr = shopAddrdd.text();
                String shopTime = cafetimeWrap.text();
                String shopTel = shopTeldd.text();

                System.out.println("점포 (" + (i+1) + ") : " + shopName);
                System.out.println("영업시간 : " + shopTime);
                System.out.println("주소 : " + shopAddr);
                System.out.println("연락처 : " + shopTel);
                System.out.println("-----------------------------------------------------------\n");

            } catch (Exception e) {

            }
        }
        driver.quit();

    }

}
