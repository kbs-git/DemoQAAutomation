package facebookTestsUsingPom.tests;

import com.base.BaseClass;
import facebookTestsUsingPom.facebookBase.FaceBookBaseClass;
import org.testng.annotations.Test;
import com.pages.faceBookpages.RegistrationFb;

import java.io.IOException;

public class RegistraionFbTest extends FaceBookBaseClass {

    @Test
    public void registrationFaceBookTest() throws IOException, InterruptedException {
        RegistrationFb registrationPage1=new RegistrationFb(BaseClass.driver);
        registrationPage1.registration1();
        registrationPage1.name("kavya","B S");
        registrationPage1.dob(10,5,2009);
        registrationPage1.genderSelection(1);
        registrationPage1.enterMobile("1234567890");
        registrationPage1.enterPwd("abs@123");
    }
}
