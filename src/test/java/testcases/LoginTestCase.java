package testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.LoginPage;
import com.qapitol.utility.ReadWritePropertyFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestCase extends BaseClass {
    LoginPage loginPage;

    @BeforeTest
    public void begin() throws IOException {
        browserLaunch(ReadWritePropertyFile.getObject("browser"));
        driver.get(ReadWritePropertyFile.getObject("url"));
        loginPage=new LoginPage(driver);
    }

    @Test
    public void loginTest(){
        loginPage.getUsername().sendKeys("Admin");
        loginPage.getPassword().sendKeys("admin123");
        loginPage.getLogin().click();

    }
    @AfterTest
    public void end(){
        browserQauit();
    }
}
