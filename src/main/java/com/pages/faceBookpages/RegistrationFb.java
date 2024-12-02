package com.pages.faceBookpages;

import com.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFb extends BaseClass {
    WebDriver driver;
    public RegistrationFb(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[text()=\"Create new account\"]") WebElement createAccount;
    @FindBy(name="firstname") WebElement firstname;
    @FindBy(name="lastname") WebElement lastname;
    @FindBy(id="day") WebElement day;
    @FindBy(id="month") WebElement month;
    @FindBy(id="year")  WebElement year;
    @FindBy(xpath="(//*[@id='sex'])[1]") WebElement female;
    @FindBy(xpath="(//*[@id='sex'])[2]") WebElement male;
    @FindBy(xpath="(//*[@id='sex'])[2]") WebElement custom;

    @FindBy(name="preferred_pronoun") WebElement pronoun;
    @FindBy(name="custom_gender") WebElement customgender;
    @FindBy(name="reg_email__") WebElement MobileorEmail;
    @FindBy(name="reg_passwd__") WebElement registationPassword;
    @FindBy(name="websubmit") WebElement submit;

    public void registration1(){
        createAccount.click();
    }

    public void name(String fist, String last){
        firstname.sendKeys(fist);
        lastname.sendKeys(last);
    }

    public void dob(int d, int m, int y) throws InterruptedException {
        Thread.sleep(5000);
        Select d1=new Select(day);
        d1.selectByValue(String.valueOf(d));
        Select m1=new Select(month);
        m1.selectByValue(String.valueOf(m));
        Select y1=new Select(year);
        y1.selectByValue(String.valueOf(y));
    }

    public void genderSelection(int n){
        if(n==1){
            female.click();
        }else if(n==2){
            male.click();
        }else{
            custom.click();
        }
    }

    public void enterMobile(String porEmail){
        MobileorEmail.sendKeys(porEmail);
    }
    public void enterPwd(String porEmail){
        registationPassword.sendKeys(porEmail);
    }
    public void singUp(){
        submit.click();
    }

}
