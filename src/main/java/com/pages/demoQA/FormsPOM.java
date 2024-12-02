package com.pages.demoQA;

import com.base.BaseClass;
import com.utilities.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormsPOM {
    public FormsPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practiceForm;

    @FindBy(id="firstName") private WebElement firstName;
    @FindBy(id="lastName") private WebElement lastName;
    @FindBy(xpath="//input[@id='userEmail']") private WebElement email;
    @FindBy(xpath="//*[@id='genterWrapper']/div[2]/div[1]/label") private WebElement gender_male;
    @FindBy(xpath="//*[@id='genterWrapper']/div[2]/div[2]/label") private WebElement gender_female;
    @FindBy(xpath="//*[@id='genterWrapper']/div[2]/div[3]/label") private WebElement gender_other;
    @FindBy(xpath="//input[@id='userNumber']") private WebElement mobile;
    @FindBy(id="dateOfBirthInput") private WebElement dob;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']") private WebElement year;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']") private WebElement month;
    @FindBy(xpath = "//div[text()='11']") private WebElement day;
    @FindBy(id="subjectsInput") private WebElement subject;
    @FindBy(xpath = "//*[@id='hobbiesWrapper']/div[2]/div[1]/label") private WebElement hobbies_Sport;
    @FindBy(xpath = "//*[@id='hobbiesWrapper']/div[2]/div[2]/label") private WebElement hobbies_Reading;
    @FindBy(xpath = "//*[@id='hobbiesWrapper']/div[2]/div[3]/label") private WebElement hobbies_Music;
    @FindBy(xpath = "//input[@id='uploadPicture']") private WebElement upload;
    @FindBy(xpath = "//textarea[@id='currentAddress']") private WebElement current_address;
    @FindBy(xpath="//*[@id='submit']") private  WebElement submit;
    @FindBy(xpath = "//*[@id='example-modal-sizes-title-lg']") WebElement thankyoumessage;

    public WebElement getPracticeForm() {
        return practiceForm;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getGender_male() {
        return gender_male;
    }

    public WebElement getGender_female() {
        return gender_female;
    }

    public WebElement getGender_other() {
        return gender_other;
    }

    public WebElement getMobile() {
        return mobile;
    }

    public WebElement getDob() {
        return dob;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getDay() {
        return day;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getHobbies_Sport() {
        return hobbies_Sport;
    }

    public WebElement getHobbies_Reading() {
        return hobbies_Reading;
    }

    public WebElement getHobbies_Music() {
        return hobbies_Music;
    }

    public WebElement getUpload() {
        return upload;
    }

    public WebElement getCurrent_address() {
        return current_address;
    }

    public WebElement getSubmit() {
        return submit;
    }

    public WebElement getThankyoumessage() {
        return thankyoumessage;
    }
}
