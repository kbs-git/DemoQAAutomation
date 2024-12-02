package facebookTestsUsingPom.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import facebookTestsUsingPom.facebookBase.FaceBookBaseClass;
import com.utilities.ReadPropFile;
import org.testng.annotations.Test;
import com.pages.faceBookpages.LoginFaceBook;

import java.io.IOException;

import static com.utilities.ExtentReportSetup.extent;

public class LoginFaceBookTest extends FaceBookBaseClass {
    @Test
    public void loginFaceBookTest() throws IOException {
        ExtentTest test = extent.createTest("Facebook Login");
        try{
            LoginFaceBook loginFaceBookPage=new LoginFaceBook(BaseClass.driver);
            loginFaceBookPage.loginFaceBook(ReadPropFile.getObject("email"), ReadPropFile.getObject("pwd") ,test);
            test.log(Status.PASS, "Test Case Passed");
        }catch(Exception e){
            test.log(Status.FAIL, "Test Case falied" +e.getMessage());
        }

    }

}
