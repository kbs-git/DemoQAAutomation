package demoqatestCases;

import com.base.BaseClass;
import com.pages.demoQA.AlertsFramesWindowPOM;
import com.pages.demoQA.DemoQAHomePage;
import com.pages.demoQA.WidgetsPOM;
import com.utilities.ExcelRead;
import com.utilities.ReadPropFile;
import com.utilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class WidgetsTests extends BaseClass{
    static WebDriverUtility webDriverUtility;
    static ExcelRead excelRead;
    static DemoQAHomePage hp;
    static WidgetsPOM widgetsPOM;
    @BeforeTest
    public void setUp() throws IOException {
        BaseClass.initialize(ReadPropFile.getObject("browser"), ReadPropFile.getObject("url"));
        webDriverUtility=new WebDriverUtility();
        excelRead = new ExcelRead();
        hp = new DemoQAHomePage(BaseClass.driver);
        widgetsPOM = new WidgetsPOM(BaseClass.driver);
    }
    @AfterTest
    public void tearDown(){
        BaseClass.quit();
    }
    @Test(priority = 1)
    public void getAccordian(){
        webDriverUtility.clickonelement(BaseClass.driver,hp.getWidget());
        webDriverUtility.clickonelement(driver,widgetsPOM.getAccordian());
    }
    @Test(priority = 2)
    public void getDatepicker(){
       // webutil.clickonelement(BaseClass.driver,hp.getWidget());
        webDriverUtility.clickonelement(driver,widgetsPOM.getDatepicker());
        widgetsPOM.getSelectDate().click();
        String Year1="1900"; String month1="5";
        webDriverUtility.dropDownHandlingByValue(widgetsPOM.getYear(), Year1);
        webDriverUtility.dropDownHandlingByValue(widgetsPOM.getMonth(), month1);
        webDriverUtility.clickonelement(driver,widgetsPOM.getDay());
        webDriverUtility.clickonelement(driver,widgetsPOM.getDateAndTime());
        webDriverUtility.scrollBarAction(driver);
        String yr="2024";
        String mn="december";
        String date="10";
        String time="10:00";
        while(true) {
            String monthYear1=widgetsPOM.getMonthYear().getText();
            String[] arr = monthYear1.split(" ");
            String mon = arr[0];
            String yer=arr[1];
            if(mon.equalsIgnoreCase(mn) && yer.equalsIgnoreCase(yr)){
                break;
            } else{
                widgetsPOM.getNextMonth().click();
            }
        }
        List<WebElement> alldate1 = driver.findElements(By.xpath("//div[@class='react-datepicker__month']/div/div"));
        for(WebElement ele:alldate1) {
            String dt = ele.getText();
            if(dt.equals(date)) {
                webDriverUtility.scrolltillelementisvisible(driver, ele);
                ele.click();
                break;
            }
        }
        List<WebElement> alltime1 = driver.findElements(By.xpath("//ul[@class='react-datepicker__time-list']/li"));
        for(WebElement ele:alltime1) {
            String tm = ele.getText();
            if(tm.equals(time)) {
                ele.click();
                break;
            }
        }
    }
    @Test(priority = 3)
    public void getSlider(){
        // webutil.clickonelement(BaseClass.driver,hp.getWidget());
        webDriverUtility.clickonelement(driver,widgetsPOM.getSlider());
        Actions action = new Actions(driver);
        action.dragAndDropBy(widgetsPOM.getRange(), 50, 0).perform();
    }
    @Test(priority = 4)
    public void getProgressBar() throws InterruptedException {
        // webutil.clickonelement(BaseClass.driver,hp.getWidget());
        webDriverUtility.scrolltillelementisvisible(driver,widgetsPOM.getProgressBar());
        widgetsPOM.getProgressBar().click();
        widgetsPOM.getStartStopButton().click();
        Thread.sleep(30);
        /*WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        Boolean status = wait.until(ExpectedConditions.attributeToBe(progressLoader, "aria-valuenow", "100"));*/
        /*if(status==true) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='resetButton']"))).click();
        }*/
        widgetsPOM.getReset().click();

    }
    @Test(priority = 5)
    public void getTabsTest() throws InterruptedException {
        // webutil.clickonelement(BaseClass.driver,hp.getWidget());
        webDriverUtility.scrolltillelementisvisible(driver,widgetsPOM.getTabs());
        widgetsPOM.getTabs().click();
        widgetsPOM.getWhatTab().click();
        Thread.sleep(3000);
        webDriverUtility.clickonelement(driver,widgetsPOM.getOriginTab());
        String originTabText1=widgetsPOM.getOriginTabText().getText();
        System.out.println(originTabText1);
        Thread.sleep(2000);
        widgetsPOM.getUseTab().click();
    }
    @Test(priority = 6)
    public void getToolTips() throws InterruptedException {
        // webutil.clickonelement(BaseClass.driver,hp.getWidget());
        webDriverUtility.clickonelement(driver,widgetsPOM.getToolTips());
    }
}
