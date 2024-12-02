package testAssignments;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;

public class BookStore {
    public static WebDriver driver;

    @BeforeMethod
    public void begin(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://139.59.27.246:3000/");
    }

    @Test(dataProvider = "login")
    public static void bookStoreLogin(String email, String pwd) throws InterruptedException, IOException {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
       /* String email= BookStore.readExcel("Assignment",0,0);
        String pwd=BookStore.readExcel("Assignment",1,0);*/
        WebElement email1=driver.findElement(By.id("userNameOrEmail"));
        email1.sendKeys(email);
        WebElement pwd1=driver.findElement(By.id("password"));
        pwd1.sendKeys(pwd);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        String message="\"Bad credentials\"";
        String alertsNames=driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/div[1]/div")).getText();
        /*Thread.sleep(1000);
        email1.click();email1.clear();
        pwd1.click();pwd1.clear();*/
        System.out.println(alertsNames);
        Assert.assertEquals(alertsNames,message);

    }

    @AfterMethod
    public void end(){
        driver.quit();
    }

    /*public static String readExcel(String sheetname, int row, int column) throws IOException {
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\Qapitol QA\\Desktop\\Assignments\\Book 1.xlsx"));
        XSSFWorkbook XSSFSheet=new XSSFWorkbook(fis);
        XSSFSheet sheet1 =  XSSFSheet.getSheet(sheetname);
        DataFormatter formatter = new DataFormatter();
        String excelData = formatter.formatCellValue(sheet1.getRow(row).getCell(column));
        return excelData;
    }*/

    @DataProvider(name = "login")
    public String[][] loginData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Qapitol QA\\Desktop\\Assignments\\Book 1.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh=wb.getSheet("Sheet1");
        int rownum = sh.getLastRowNum();
        int colnum = sh.getRow(0).getLastCellNum();
        String[][] data = new String[rownum-1][colnum];
        for (int i = 0; i < rownum - 1; i++) {
            for (int j = 0; j < colnum; j++) {
                data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }
}
