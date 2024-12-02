package testAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Cricket {
    public static WebDriver driver;
    public static void main(String[] args) {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cricbuzz.com/cricket-series/8525/womens-big-bash-league-2024/points-table");
        //td[@class='cb-srs-pnts-name'] - teams name
        ////td[@class='cb-srs-pnts-td text-bold'] - points
        List<WebElement>  teamsname=driver.findElements(By.xpath("//td[@class='cb-srs-pnts-name']"));
        List<WebElement> points=driver.findElements(By.xpath("//td[@class='cb-srs-pnts-td text-bold']"));

        for (int i = 0; i < points.size(); i++) {
            String pointsText = points.get(i).getText();
            int points1 = Integer.parseInt(pointsText);

            if (points1 >= 9) {
                String teamName = teamsname.get(i).getText();
                System.out.println("Teams are= "+ teamName +" =====>Points "+ pointsText);
            }
        }
        driver.quit();
    }

}
