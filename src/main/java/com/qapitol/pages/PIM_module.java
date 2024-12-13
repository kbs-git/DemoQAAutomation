package com.qapitol.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIM_module {
    public PIM_module(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']") private WebElement pimModule;
    @FindBy(xpath = "//a[contains(text(), 'Add Employee')]") private WebElement addEmployee;
    @FindBy(name="firstName") private WebElement firstName;
    @FindBy(name="middleName") private WebElement middleName;
    @FindBy(name="lastName") private WebElement lastName;
    @FindBy(xpath = "(//div[@class='oxd-input-group oxd-input-field-bottom-space'])[5]/div[2]/input")  private WebElement employeeId;
       //     "(//input[@class='oxd-input oxd-input--active'])[2]")
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']") private WebElement createloginCheckbox;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]") private WebElement userName;
    @FindBy(xpath = "(//input[@type='password'])[1]") private WebElement password;
    @FindBy(xpath = "(//input[@type='password'])[2]") private WebElement confirmPassword;
    @FindBy(xpath = "//button[@type='submit']") private WebElement saveUser;
    @FindBy(css=".oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text") private WebElement successconfirm;

    public WebElement getSuccessconfirm() {
        return successconfirm;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getPimModule() {
        return pimModule;
    }

    public WebElement getAddEmployee() {
        return addEmployee;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getMiddleName() {
        return middleName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmployeeId() {
        return employeeId;
    }

    public WebElement getCreateloginCheckbox() {
        return createloginCheckbox;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getSaveUser() {
        return saveUser;
    }
}
