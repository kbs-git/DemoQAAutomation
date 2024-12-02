package com.pages.faceBookpages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utilities.ScreenShotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginFaceBook extends BaseClass {
    WebDriver driver;
    public LoginFaceBook(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id="email")
    WebElement email;
    @FindBy(id="pass") WebElement password;
    @FindBy(xpath = "//*[@name='login']") WebElement login;

    public void loginFaceBook(String mail, String pwd1, ExtentTest test) throws IOException {
        email.sendKeys(mail);
        String screenshotPath = ScreenShotUtil.captureScreenshot("FaceBookLogin");
        test.addScreenCaptureFromPath(screenshotPath);
        test.addScreenCaptureFromBase64String(screenshotPath);
        password.sendKeys(pwd1);
        login.click();
    }

}
