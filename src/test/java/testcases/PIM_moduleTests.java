package testcases;

import com.qapitol.base.BaseClass;
import com.qapitol.pages.LoginPage;
import com.qapitol.pages.PIM_module;
import com.qapitol.utility.DataProviderClass;
import com.qapitol.utility.ReadWritePropertyFile;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class PIM_moduleTests extends BaseClass {
    static PIM_module pimModule;
    static LoginPage loginPage;
    @DataProvider(name="userdata")
    public Object[][] getData() throws IOException {
        DataProviderClass dataProviderClass=new DataProviderClass();
        return dataProviderClass.getExcelData("C:\\Users\\Qapitol QA\\IdeaProjects\\OrangeHRMProject\\src\\main\\resources\\testFiles\\TestData.xlsx");
    }

    @BeforeTest
    public void begin() throws IOException {
        browserLaunch(ReadWritePropertyFile.getObject("browser"));
        driver.get(ReadWritePropertyFile.getObject("url"));
        pimModule=new PIM_module(driver);
        loginPage=new LoginPage(driver);
    }

    @AfterTest
    public void end(){
       // browserQauit();
    }

    @Test(priority = -1)
    public void loginTest() throws IOException {
        loginPage.getUsername().sendKeys(ReadWritePropertyFile.getObject("username"));
        loginPage.getPassword().sendKeys(ReadWritePropertyFile.getObject("password"));
        loginPage.getLogin().click();

    }
    @Test(dataProvider = "userdata")
    public void employeeAdd(String firstname,String middleName, String lastname, String employeeid,String username1, String password1,String confirmpassword) throws IOException, InterruptedException {
       // loginPage.login(ReadWritePropertyFile.getObject("username"),ReadWritePropertyFile.getObject("password"));
        pimModule.getPimModule().click();
        pimModule.getAddEmployee().click();
        pimModule.getFirstName().sendKeys(firstname);
        pimModule.getMiddleName().sendKeys(middleName);
        pimModule.getLastName().sendKeys(lastname);
        Thread.sleep(3000);
        //pimModule.getEmployeeId().sendKeys(Keys.CONTROL+"a");
       // pimModule.getEmployeeId().sendKeys(Keys.BACK_SPACE);
        pimModule.getEmployeeId().sendKeys(employeeid);
        if(pimModule.getCreateloginCheckbox().isEnabled()){
            pimModule.getCreateloginCheckbox().click();
        }

        pimModule.getUserName().sendKeys(username1);
        pimModule.getPassword().sendKeys(password1);
        pimModule.getConfirmPassword().sendKeys(confirmpassword);
        pimModule.getSaveUser().click();
        Assert.assertTrue(pimModule.getSuccessconfirm().isDisplayed());
    }

    @Test(dependsOnMethods = "employeeAdd")
    public void verifyTheUserIsCreated(){

    }

}
