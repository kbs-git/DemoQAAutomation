package com.utilities;

import com.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtil extends BaseClass {
    public static String captureScreenshot(String screenshotName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") +"target/screenshot"+ screenshotName + ".png";
        FileUtils.copyFile(screenshot, new File(screenshotPath));
        return screenshotPath;
    }
}
