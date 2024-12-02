package demoqatestCases;

import com.base.BaseClass;
import com.pages.demoQA.DemoQAHomePage;
import com.pages.demoQA.ElementsPOM;
import com.utilities.ExcelRead;
import com.utilities.ReadPropFile;
import com.utilities.WebDriverUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class ElementsTests extends BaseClass{
    static WebDriverUtility webDriverUtility;
    static ExcelRead excelRead;
    static DemoQAHomePage hp;
    static ElementsPOM elementsPOM;


    @BeforeTest
    public static void begin() throws IOException {
        BaseClass.initialize(ReadPropFile.getObject("browser"), ReadPropFile.getObject("url"));
        webDriverUtility=new WebDriverUtility();
        excelRead = new ExcelRead();
        hp = new DemoQAHomePage(driver);
        elementsPOM = new ElementsPOM(driver);
    }

    @AfterTest
    public void tearDown(){
        BaseClass.quit();
    }

    @Test(priority=1)
    public static void testBoxTest() throws Throwable {
        webDriverUtility.clickonelement(driver,hp.getElements());
        webDriverUtility.clickonelement(driver,elementsPOM.getTextbox());
        elementsPOM.getUsername().sendKeys(excelRead.getData("ElementsTextBoxs", 0, 1));
        elementsPOM.getUseremail().sendKeys(excelRead.getData("ElementsTextBoxs", 1, 1));
        elementsPOM.getCurrentaddress().sendKeys(excelRead.getData("ElementsTextBoxs", 2, 1));
        elementsPOM.getPermanentaddress().sendKeys(excelRead.getData("ElementsTextBoxs", 3, 1));
        webDriverUtility.clickonelement(driver,elementsPOM.getSubmit());
    }
    @Test(priority = 2)
    public void checkBoxTest() throws InterruptedException {
        elementsPOM.getCheckbox().click();
        Thread.sleep(1000);
        webDriverUtility.clickonelement(BaseClass.driver,elementsPOM.getExpandbox());
        webDriverUtility.clickonelement(driver,elementsPOM.getCollapseAll());
        webDriverUtility.clickonelement(driver,elementsPOM.getToggle());
    }
    @Test(priority = 3)
    public void radioButtonTest(){
        elementsPOM.getRadoibutton().click();
        String str="yes";
        if(str.equalsIgnoreCase("Yes")){
            webDriverUtility.scrolltillelementisvisible(driver,elementsPOM.getYesradoibtn());
            elementsPOM.getYesradoibtn().click();
        }else {
            webDriverUtility.scrolltillelementisvisible(driver,elementsPOM.getImpressivebtn());
            elementsPOM.getImpressivebtn().click();
        }
    }
    @Test(priority = 4)
    public void webTableAddTest() throws InterruptedException {
        elementsPOM.getWebtable().click();
        Thread.sleep(15000);
        webDriverUtility.clickonelement(driver,elementsPOM.getAddnewrecord());
        elementsPOM.getFirstname().sendKeys("kavya");
        elementsPOM.getLastname().sendKeys("B S");
        elementsPOM.getUseremail().sendKeys("abc@gmail.com");
        elementsPOM.getAge().sendKeys("40");
        elementsPOM.getSalary().sendKeys("20000");
        elementsPOM.getDepartment().sendKeys("eng");
        webDriverUtility.clickonelement(driver,elementsPOM.getSubmit());
/*        Thread.sleep(2000);
        elementsPOM.getSubmit().click();
        //elementsPOM.getRegClose().click();*/
    }

    @Test(priority = 5)
    public void buttonsTest() throws InterruptedException {
        webDriverUtility.clickonelement(driver, elementsPOM.getButton());
        Actions action=webDriverUtility.performActions(driver);
        webDriverUtility.scrolltillelementisvisible(driver,elementsPOM.getDoubleclickbtn());
        action.doubleClick(elementsPOM.getDoubleclickbtn()).perform();
        Thread.sleep(1000);
        action.contextClick(elementsPOM.getRightclick()).perform();
        Thread.sleep(2000);
        action.click(elementsPOM.getClickme()).perform();
    }

    @Test(priority = 6)
    public void uploadFilesTest() throws IOException, InterruptedException {
        webDriverUtility.scrolltillelementisvisible(driver, elementsPOM.getUploadanddownload());
        elementsPOM.getUploadanddownload().click();
        Thread.sleep(4000);
        //webDriverUtility.clickonelement(driver,elementsPOM.getUploadfile());
        webDriverUtility.scrollUpTillElementToBeVisisble(driver, elementsPOM.getUploadfile());
        elementsPOM.getUploadfile().sendKeys("C:\\Users\\Qapitol QA\\Downloads\\sample-jpg-files-sample_640x426.jpg");
        webDriverUtility.scrolltillelementisvisible(driver,driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/h1")));
        String sourceLocation = elementsPOM.getDownload().getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
    }
    @Test(priority = 7)
    public void brokenLinksTest() throws IOException, InterruptedException {
        webDriverUtility.clickonelement(driver,elementsPOM.getBrokenlinks());

        List<WebElement> links = driver.findElements(By.tagName("a"));
        // Iterating each link and checking the response status
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            verifyLink(url);
        }
    }
    public static void verifyLink(String url) {
        try {
            URL link = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();


            if (httpURLConnection.getResponseCode() == 200) {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage());
            } else {
                System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
            }
        } catch (Exception e) {
            System.out.println(url + " - " + "is a broken link");
        }
    }
    @Test(priority = 8)
    public void clickOnLinksTest() throws InterruptedException {

        webDriverUtility.scrolltillelementisvisible(driver,elementsPOM.getLinks());
        Thread.sleep(2000);
        elementsPOM.getLinks().click();
        webDriverUtility.scrollUpTillElementToBeVisisble(driver, elementsPOM.getLinks());
        String currentWindowHandle = driver.getWindowHandle();
        List<WebElement> allLinks=driver.findElements(By.xpath("//a"));
        int siz=allLinks.size();
        System.out.println(siz);
        for(int i=0;i<siz;i++)
        {
            WebElement ds=allLinks.get(i);
            String name=ds.getText();
            System.out.println(name);
        }
        elementsPOM.getSimplelink().click();
        String st=driver.getWindowHandle();
        System.out.println(st);
       // driver.switchTo().window(currentWindowHandle);
    }

}
