package facebookTestsUsingPom.facebookBase;

import com.aventstack.extentreports.ExtentReports;
import com.base.BaseClass;
import com.utilities.ExtentReportSetup;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.utilities.ReadPropFile;

import java.io.IOException;

public class FaceBookBaseClass extends BaseClass{
    ExtentReports extent;
    @BeforeTest
    public void setUp(){
        try {
            extent = ExtentReportSetup.setupExtentReport("FaceBook", "FaceBook TestCases");
            BaseClass.initialize(ReadPropFile.getObject("browser"), ReadPropFile.getObject("facebook"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void tearDown(){
        extent.flush();
        BaseClass.quit();
    }

}
