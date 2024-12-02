package com.pages.demoQA;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFramesWindowPOM {
    public AlertsFramesWindowPOM(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    //Browser Window Section
    @FindBy(xpath="//span[text()='Browser Windows']") private WebElement browserWindow1;
    @FindBy(id ="tabButton") private WebElement newTab;
    @FindBy(xpath="//button[@id='windowButton']") private WebElement newWindow;
    @FindBy(xpath="//button[text()='New Window Message']") private WebElement newWindowMessage;
    //Alerts Window Section
    @FindBy(xpath="//span[text()='Alerts']") private WebElement alert;
    @FindBy(xpath="//button[@id='alertButton']") private WebElement onClickAlert;
    @FindBy(xpath="//button[@id='timerAlertButton']") private WebElement timeAlert;
    @FindBy(xpath="//button[@id='confirmButton']") private WebElement confirmAlert;
    @FindBy(xpath="//button[@id='promtButton']") private WebElement promtAlert;
    //Frames
    @FindBy(xpath="//span[text()='Frames']") private WebElement frames;
    @FindBy(xpath = "//iframe[@id='frame1']") private WebElement frame1;
    @FindBy(xpath="//h1[@id='sampleHeading']") private WebElement headderInsideFrame;
    @FindBy(xpath = "//iframe[@id='frame2']") private WebElement frame2;
    //nestedFrames
    @FindBy(xpath = "//span[text()='Nested Frames']") private WebElement nestaedFrames;
    @FindBy(xpath="//iframe[@id='frame1']") private WebElement parentframe;
    @FindBy(xpath = "//body[text()='Parent frame']") private WebElement parentFrameText;
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']") private WebElement childFrame;
    @FindBy(xpath = "//body/p[text()='Child Iframe']") private WebElement childFrameText;
    @FindBy(id="item-4") private  WebElement modelDialog;

    public WebElement getBrowserWindow1() {
        return browserWindow1;
    }

    public WebElement getNewTab() {
        return newTab;
    }

    public WebElement getNewWindow() {
        return newWindow;
    }

    public WebElement getNewWindowMessage() {
        return newWindowMessage;
    }

    public WebElement getAlert() {
        return alert;
    }

    public WebElement getOnClickAlert() {
        return onClickAlert;
    }

    public WebElement getTimeAlert() {
        return timeAlert;
    }

    public WebElement getConfirmAlert() {
        return confirmAlert;
    }

    public WebElement getPromtAlert() {
        return promtAlert;
    }

    public WebElement getFrames() {
        return frames;
    }

    public WebElement getFrame1() {
        return frame1;
    }

    public WebElement getHeadderInsideFrame() {
        return headderInsideFrame;
    }

    public WebElement getFrame2() {
        return frame2;
    }

    public WebElement getNestaedFrames() {
        return nestaedFrames;
    }

    public WebElement getParentframe() {
        return parentframe;
    }

    public WebElement getParentFrameText() {
        return parentFrameText;
    }

    public WebElement getChildFrame() {
        return childFrame;
    }

    public WebElement getChildFrameText() {
        return childFrameText;
    }

    public WebElement getModelDialog() {
        return modelDialog;
    }
}
