package com.bitc.java404;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebBase {
    public final static String Web_Driver_Id = "webdriver.chrome.driver";
    public final static String Chrome_Driver_Path = "c:\\chromedriver.exe";
    public String requestUrl = "https://www.google.co.kr";
    public WebDriver driver;
    public ChromeOptions options;
}
