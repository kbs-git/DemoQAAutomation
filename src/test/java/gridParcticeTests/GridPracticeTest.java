package gridParcticeTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class GridPracticeTest{
    @Test
    public void gridTest(){
        try{
            System.out.println("Grid testing has been started");
            DesiredCapabilities capability=new DesiredCapabilities();
            capability.setBrowserName("chrome");
            capability.setBrowserName("MicrosoftEdge");
            WebDriver driver=new RemoteWebDriver(new URL("http://192.168.2.65:4444"),capability);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get("https://www.selenium.dev/");
            Thread.sleep(10000);
            String title=driver.getTitle();
            System.out.println(title);
            System.out.println("Grid testing has been ended");
            driver.quit();

        } catch (Exception e) {
            System.out.println("the exception is=" +e);
        }
    }

}
