package com.pages.demoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WidgetsPOM{
    public WidgetsPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Accordian']") private WebElement accordian;
    //datepicker
    @FindBy(xpath = "//span[text()='Date Picker']") private  WebElement datepicker;
    @FindBy(id="datePickerMonthYearInput") private  WebElement selectDate;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']") private  WebElement year;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']") private WebElement month;
    @FindBy(xpath = "//div[text()='11']") private WebElement day;
    @FindBy(id="dateAndTimePickerInput") private WebElement dateAndTime;
    @FindBy(xpath = "//div[@class='react-datepicker__current-month" + " react-datepicker__current-month--hasYearDropdown react-datepicker__current-month--hasMonthDropdown']") private WebElement monthYear;
    @FindBy(xpath = "//button[@aria-label='Next Month']") private WebElement nextMonth;
    @FindBy(xpath = "//div[@class='react-datepicker__month']/div/div") private WebElement alldate;
    @FindBy(xpath = "//ul[@class='react-datepicker__time-list']/li") private WebElement allTime;

    //slider
    @FindBy(xpath = "//span[text()='Slider']") private WebElement slider;
    @FindBy(xpath = "//input[@type='range']") private WebElement range;

    //progressbar
    @FindBy(xpath = "//span[text()='Progress Bar']") private WebElement progressBar;
    @FindBy(xpath = "//button[@id='startStopButton']") private WebElement startStopButton;
    @FindBy(xpath = "//div[@id='progressBar']") private WebElement progressLoader;
    @FindBy(xpath = "//button[@id='resetButton']") private WebElement reset;
    //tabs
    @FindBy(xpath = "//span[text()='Tabs']") private WebElement tabs;
    @FindBy(xpath = "//a[@id='demo-tab-what']") private WebElement whatTab;
    @FindBy(xpath = "//a[@id='demo-tab-origin']") private WebElement originTab;
    @FindBy(xpath = "//p[contains(text(),'Contrary')]") private WebElement originTabText;
    @FindBy(xpath = "//a[@id='demo-tab-use']") private WebElement useTab;
    //tooltip
    @FindBy(xpath = "//span[text()='Tool Tips']") private WebElement toolTips;

    public WebElement getAccordian() {
        return accordian;
    }

    public WebElement getDatepicker() {
        return datepicker;
    }

    public WebElement getSelectDate() {
        return selectDate;
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

    public WebElement getDateAndTime() {
        return dateAndTime;
    }

    public WebElement getMonthYear() {
        return monthYear;
    }

    public WebElement getNextMonth() {
        return nextMonth;
    }

    public WebElement getAlldate() {
        return alldate;
    }

    public WebElement getAllTime() {
        return allTime;
    }

    public WebElement getSlider() {
        return slider;
    }

    public WebElement getRange() {
        return range;
    }

    public WebElement getProgressBar() {
        return progressBar;
    }

    public WebElement getStartStopButton() {
        return startStopButton;
    }

    public WebElement getProgressLoader() {
        return progressLoader;
    }

    public WebElement getReset() {
        return reset;
    }

    public WebElement getTabs() {
        return tabs;
    }

    public WebElement getWhatTab() {
        return whatTab;
    }

    public WebElement getOriginTab() {
        return originTab;
    }

    public WebElement getOriginTabText() {
        return originTabText;
    }

    public WebElement getUseTab() {
        return useTab;
    }

    public WebElement getToolTips() {
        return toolTips;
    }
}
