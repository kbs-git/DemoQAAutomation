package demoqatestCases;

import com.base.BaseClass;
import com.pages.demoQA.DemoQAHomePage;
import com.pages.demoQA.ElementsPOM;
import com.pages.demoQA.FormsPOM;
import com.utilities.ExcelRead;
import com.utilities.ReadPropFile;
import com.utilities.WebDriverUtility;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class FormsTest extends BaseClass{
    static WebDriverUtility webDriverUtility;
    static ExcelRead excelRead;
    static DemoQAHomePage hp;
    static FormsPOM formsPOM;


    @BeforeTest
    public static void begin() throws IOException {
        BaseClass.initialize(ReadPropFile.getObject("browser"), ReadPropFile.getObject("url"));
        webDriverUtility=new WebDriverUtility();
        excelRead = new ExcelRead();
        hp = new DemoQAHomePage(BaseClass.driver);
        formsPOM = new FormsPOM(BaseClass.driver);
    }
    @Test
    public static void getFormsTest() throws Throwable {
        webDriverUtility.clickonelement(BaseClass.driver,hp.getForms());
        webDriverUtility.clickonelement(driver,formsPOM.getPracticeForm());
        String fname=excelRead.getData("Forms", 0, 1);
        String lname=excelRead.getData("Forms", 1, 1);
        String email=excelRead.getData("Forms", 2, 1);
        String gender=excelRead.getData("Forms", 3, 1);
        String mobile=excelRead.getData("Forms", 4, 1);
        String year=excelRead.getData("Forms", 5, 1);
        String month=excelRead.getData("Forms", 6, 1);
        String hobbies=excelRead.getData("Forms", 7, 1);
        String current_address=excelRead.getData("Forms", 8, 1);
        String filePath="C:\\Users\\Qapitol QA\\Downloads\\sampleFile.jpeg";
        String actual="Thanks for submitting the form";

        formsPOM.getFirstName().sendKeys(fname);
        formsPOM.getLastName().sendKeys(lname);
        formsPOM.getEmail().sendKeys(email);
        if(gender.equalsIgnoreCase("Female")){
            webDriverUtility.scrolltillelementisvisible(driver,formsPOM.getGender_female());
            formsPOM.getGender_female().click();
        } else if (gender.equalsIgnoreCase("male")) {
            webDriverUtility.scrolltillelementisvisible(driver,formsPOM.getGender_male());
            formsPOM.getGender_male().click();
        }else{
            webDriverUtility.scrolltillelementisvisible(driver,formsPOM.getGender_other());
            formsPOM.getGender_other().click();
        }
        formsPOM.getMobile().sendKeys(mobile);
        webDriverUtility.clickonelement(driver,formsPOM.getDob());
        webDriverUtility.dropDownHandlingByValue(formsPOM.getYear(),year);
        webDriverUtility.dropDownHandlingByValue(formsPOM.getMonth(),month);
        webDriverUtility.clickonelement(driver,formsPOM.getDay());
        formsPOM.getSubject().sendKeys(fname);
        if(hobbies.equalsIgnoreCase("Sport")){
            webDriverUtility.scrolltillelementisvisible(driver,formsPOM.getHobbies_Sport());
            formsPOM.getHobbies_Sport().click();
        } else if (hobbies.equalsIgnoreCase("reading")) {
            webDriverUtility.scrolltillelementisvisible(driver,formsPOM.getHobbies_Reading());
            formsPOM.getHobbies_Reading().click();
        }else{
            webDriverUtility.scrolltillelementisvisible(driver,formsPOM.getHobbies_Music());
            formsPOM.getHobbies_Music().click();
        }
        formsPOM.getUpload().sendKeys(filePath);
        formsPOM.getCurrent_address().sendKeys(current_address);
        formsPOM.getSubmit().click();
        String message=formsPOM.getThankyoumessage().getText();
        Assert.assertTrue(actual.equals(message), "Success message not displayed as expected.");

    }
    @AfterTest
    public void tearDown(){
        BaseClass.quit();
    }
}
