package keyWordDrivenTests.testCase;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import keyWordDrivenTests.keyEngines.KeyEngine;
import com.utilities.ReadPropFile;

import java.io.IOException;


public class LoginTest {
    KeyEngine keyEngine;
    @BeforeTest
    public void signUp(){
        keyEngine=new KeyEngine();
       // ReadPropFile.ExtentSetup.setupExtentReport();
    }

    @Test(priority = 2)
    public void loginTesting() throws IOException, InterruptedException {
        // String fileLocation=System.getProperty("user.dir")+"//src//main//resources//Files//Book.xlsx";
        String fileLocation="C:\\Users\\Qapitol QA\\Desktop\\KDD\\Book.xlsx";
       // ReadPropFile.ExtentSetup.startTest("KDD TESTING", "Simple Test");
     //   ReadPropFile.ExtentSetup.logInfo("Test is running...");

       // ExtentTest loginStep1 = ReadPropFile.ExtentSetup.createNode("facebook login", "login page");
        //loginStep1.info("performing the login");
        try {
            keyEngine.service(fileLocation);
        //    ReadPropFile.ExtentSetup.logPass("Test Passed successfully.");

        }catch (Exception e){
      //      ReadPropFile.ExtentSetup.logFail("Test Failed: " + e.getMessage());
        }finally {
     //       ReadPropFile.ExtentSetup.endTest();
        }


    }
    @AfterTest
    public void afterTest(){
        //ReadPropFile.ExtentSetup.flushReport();
       // ReadPropFile.ExtentSetup.closeReport();
        keyEngine.tearDown();
    }
}
