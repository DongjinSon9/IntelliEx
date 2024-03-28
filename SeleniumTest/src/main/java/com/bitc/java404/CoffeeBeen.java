package com.bitc.java404;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CoffeeBeen extends WebBase {

    public CoffeeBeen() {
        System.setProperty(WebBase.Web_Driver_Id,WebBase.Chrome_Driver_Path);
        options = OptionSetup();
        driver = new ChromeDriver(options);

    }

    public ChromeOptions OptionSetup() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--start-maximized");
        opt.addArguments("--disable-popup-blocking");
        opt.addArguments("--remote-allow-origins=*");

        return opt;
    }

    public void getStoreInfo() throws Exception {
        requestUrl = "https://www.coffeebeankorea.com/store/store.asp";

        driver.get(requestUrl);
        Thread.sleep(5000);

//        셀레니움에서 제공하는 클래스로 webdriver에서 자바스크립트를 직접 실행함
//        executeScript(자바스크립트) : 지정한 자바스크립트 실행
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("storePop2('31');");

//        현재 자바스크립트가 실행된 후 전체 페이지에 대한 html 태그를 가져옴
        String html = driver.getPageSource();
        System.out.println(html);

        driver.quit();

    }
}
