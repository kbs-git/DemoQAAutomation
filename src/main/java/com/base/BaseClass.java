package com.base;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static void initialize(String browser, String url) throws IOException {
        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();
        }else{
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void quit() {
        driver.close();
    }
}
