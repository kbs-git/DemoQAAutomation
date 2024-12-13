package com.qapitol.base;

import com.qapitol.utility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    static WebDriverUtility webDriverUtility;
    public static WebDriver driver;
    public static void browserLaunch(String browser) throws IOException {
        if(browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();
        }else{
            driver=new FirefoxDriver();
        }
        webDriverUtility=new WebDriverUtility();
        webDriverUtility.maximizeWindow(driver);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void browserQauit() {
        driver.close();
    }
}
