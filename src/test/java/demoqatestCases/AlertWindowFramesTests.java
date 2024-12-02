package demoqatestCases;

import com.base.BaseClass;
import com.pages.demoQA.AlertsFramesWindowPOM;
import com.pages.demoQA.DemoQAHomePage;
import com.utilities.ExcelRead;
import com.utilities.WebDriverUtility;
import net.bytebuddy.build.Plugin;
import org.apache.logging.log4j.core.net.Priority;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.utilities.ReadPropFile;

import java.io.IOException;
import java.util.Set;

public class AlertWindowFramesTests extends BaseClass {
    static WebDriverUtility webDriverUtility;
    static ExcelRead excelRead;
    static DemoQAHomePage hp;
    static AlertsFramesWindowPOM alertsFramesWindowsWindow;
    @BeforeTest
    public void setUp() throws IOException {
        BaseClass.initialize(ReadPropFile.getObject("browser"), ReadPropFile.getObject("url"));
        webDriverUtility=new WebDriverUtility();
        excelRead = new ExcelRead();
        hp = new DemoQAHomePage(driver);
        alertsFramesWindowsWindow = new AlertsFramesWindowPOM(driver);
    }
    @Test(priority=1)
    public void setNewTabTests() throws InterruptedException {
        webDriverUtility.clickonelement(BaseClass.driver,hp.getAlertframewindow());
        webDriverUtility.scrolltillelementisvisible(driver,alertsFramesWindowsWindow.getBrowserWindow1());
        alertsFramesWindowsWindow.getBrowserWindow1().click();
        webDriverUtility.scrolltillelementisvisible(driver,alertsFramesWindowsWindow.getNewTab());
        alertsFramesWindowsWindow.getNewTab().click();
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for(String windowHandle:allWindows) {
            String title = driver.switchTo().window(windowHandle).getTitle();
            if(title.contains("sample")) {
                break;
            }
        }
        driver.switchTo().window(currentWindowHandle);
        webDriverUtility.scrolltillelementisvisible(driver,alertsFramesWindowsWindow.getNewWindow());
        alertsFramesWindowsWindow.getNewWindow().click();
        Set<String> allWindows1 = driver.getWindowHandles();
        for(String windowHandle:allWindows1) {
            if (!windowHandle.equals(currentWindowHandle)) {
                break;
            }
        }
        driver.switchTo().window(currentWindowHandle);
        webDriverUtility.scrolltillelementisvisible(driver,alertsFramesWindowsWindow.getNewWindowMessage());
        alertsFramesWindowsWindow.getNewWindowMessage().click();
        Set<String> allWindows2 = driver.getWindowHandles();
        for(String windowHandle:allWindows2) {
            if (!windowHandle.equals(currentWindowHandle)) {
                break;
            }
        }
        driver.switchTo().window(currentWindowHandle);
    }
    @Test(priority=2)
    public void alertsTest(){
        //webutil.clickonelement(BaseClass.driver,hp.getAlertframewindow());
        webDriverUtility.scrolltillelementisvisible(driver,alertsFramesWindowsWindow.getAlert());
        alertsFramesWindowsWindow.getAlert().click();
        alertsFramesWindowsWindow.getOnClickAlert().click();
        webDriverUtility.acceptAlert(driver);
        alertsFramesWindowsWindow.getTimeAlert().click();
        webDriverUtility.waitUntilAlertToBePresent(driver,5);
        webDriverUtility.acceptAlert(driver);
        webDriverUtility.clickonelement(driver,alertsFramesWindowsWindow.getConfirmAlert());
        webDriverUtility.acceptAlert(driver);
        webDriverUtility.clickonelement(driver,alertsFramesWindowsWindow.getPromtAlert());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("testing");
        alert.accept();
    }

    @Test(priority = 3)
    public void setframesTest(){
       // webutil.clickonelement(BaseClass.driver,hp.getAlertframewindow());
        webDriverUtility.scrolltillelementisvisible(driver,alertsFramesWindowsWindow.getFrames());
        alertsFramesWindowsWindow.getFrames().click();
        webDriverUtility.switchToFrame(driver,alertsFramesWindowsWindow.getFrame1());
        String text=alertsFramesWindowsWindow.getHeadderInsideFrame().getText();
        System.out.println(text);
        webDriverUtility.switchToDefaultContentFrame(driver);
        webDriverUtility.switchToFrame(driver,alertsFramesWindowsWindow.getFrame2());
        webDriverUtility.switchToDefaultContentFrame(driver);
    }
    @Test(priority = 4)
    public void nestedframesTest(){
       // webutil.clickonelement(BaseClass.driver,hp.getAlertframewindow());
        webDriverUtility.scrolltillelementisvisible(driver,alertsFramesWindowsWindow.getNestaedFrames());
        alertsFramesWindowsWindow.getNestaedFrames().click();
        webDriverUtility.switchToFrame(driver,alertsFramesWindowsWindow.getParentframe());
        String firstFrameText=alertsFramesWindowsWindow.getParentFrameText().getText();
        System.out.println(firstFrameText);
        webDriverUtility.switchToFrame(driver,alertsFramesWindowsWindow.getChildFrame());
        String childFramesText=alertsFramesWindowsWindow.getChildFrameText().getText();
        System.out.println(childFramesText);
    }

    @AfterTest
    public void tearDown(){
        BaseClass.quit();
    }

}
