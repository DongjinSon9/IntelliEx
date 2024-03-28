package com.bitc.java404;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NaverLogin {
    private final static String Web_Driver_Id = "webdriver.chrome.driver";
    private final static String Chrome_Driver_Path = "c:\\chromedriver.exe";
    private  WebDriver driver;
    private String url = "https://www.naver.com";
    public void login() throws InterruptedException {
        System.setProperty(Web_Driver_Id,Chrome_Driver_Path);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.get(url);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement mainPageLoginButton = driver.findElement(By.className("MyView-module__link_login___HpHMW"));

        mainPageLoginButton.click();

        Thread.sleep(1000);

        WebElement loginId = driver.findElement(By.id("id"));
        WebElement loginPw = driver.findElement(By.name("pw"));
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"log.login\"]"));

        loginId.sendKeys("test1234");
        Thread.sleep(2000);
        loginPw.sendKeys("test1234");
        Thread.sleep(2000);

        loginBtn.submit();

        Thread.sleep(5000);

        driver.quit();

    }
}
