package testAssignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class TestNgAnnotationTesting {
    public static WebDriver driver;
    @BeforeSuite
    public void beforeSuiteTest(){
        System.out.println("The Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("The Before Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("The Before Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("The Before Method");

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--headless");
        driver=new ChromeDriver(options);
    }
    @Test(priority = 0)
    public void test1(){
        System.out.println("Test1");
        driver.get("https://google.com/");
    }

    @Test(priority = -1)
    public void test2(){
        System.out.println("Test2");
        driver.get("https://google.com/");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("The After Method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("The After class");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("The After Test");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("The After Suite");
    }

}
