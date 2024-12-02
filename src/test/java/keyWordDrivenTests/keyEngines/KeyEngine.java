package keyWordDrivenTests.keyEngines;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.utilities.ExcelRead;

import java.io.IOException;

public class KeyEngine {

    static WebDriver driver;

    public void service(String filePath) throws IOException, InterruptedException {
        XSSFSheet sheet = ExcelRead.readExcel(filePath);

        for (Row row : sheet) {

            String keyword = row.getCell(0).getStringCellValue();
            String locator = row.getCell(1).getStringCellValue();
            String locatorValue = row.getCell(2).getStringCellValue();
            String data = row.getCell(3).getStringCellValue();

            switch (keyword) {
                case "LaunchBrowser":
                    if (data.equalsIgnoreCase("Edge")) {
                        driver = new EdgeDriver();
                    } else if (data.equalsIgnoreCase("chrome")) {
                        driver = new ChromeDriver();
                    } else {
                        driver = new FirefoxDriver();
                    }
                    ExcelRead.writeResultToExcel(filePath,"FaceBookLogin",1,"PASS");
                    break;
                case "Navigate":

                    driver.get(data);
                    driver.manage().window().maximize();
                    break;
                case "EnterText":
                    getElement(locator, locatorValue).sendKeys(data);
                    break;
                case "Click":
                    Thread.sleep(3000);
                    getElement(locator, locatorValue).click();
                    break;
                case "NA":
                    break;
                default:
                    System.out.println("The Keyword is not found/invalid " + keyword);
            }
        }
    }

    public static WebElement getElement(String locator, String locatorValue) {
        WebElement webelement = null;
        switch (locator) {
            case "id":
                webelement = driver.findElement(By.id(locatorValue));
                break;
            case "xpath":
                webelement = driver.findElement(By.xpath(locatorValue));
                break;
            case "name":
                webelement = driver.findElement(By.name(locatorValue));
                break;
            case "cssSelector":
                webelement = driver.findElement(By.cssSelector(locatorValue));
                break;
            case "linkText":
                webelement = driver.findElement(By.linkText(locatorValue));
                break;
            case "partialLinkText":
                webelement = driver.findElement(By.partialLinkText(locatorValue));
                break;
            case "className":
                webelement = driver.findElement(By.className(locatorValue));
                break;
            case "tagName":
                webelement = driver.findElement(By.tagName(locatorValue));
                break;
            case "NA":
                break;
            default:
                System.out.println("The locator is invalid =" + locator + " " + locatorValue);
        }
        return webelement;

    }

    public void tearDown() {
        driver.quit();
    }
}
