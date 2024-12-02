package com.pages.faceBookpages;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SerachContext1 extends BaseClass {

    WebDriver driver;
    public SerachContext1(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id="twotabsearchtextbox")
    WebElement search;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;


    // Method to perform the search in one step
    public void searchForItem(String searchTerm) {
        search.clear();
        search.sendKeys(searchTerm);
        searchButton.click();
        contextSearch(searchTerm);
    }

    public static  void contextSearch(String quary){
        List<WebElement> elements=BaseClass.driver.findElements(By.xpath("//span[@class='a-declarative']/div/div/div/div[2]/div/div/div/h2"));
        if(elements.size()>0){
            for (WebElement element:elements){
                String text=element.getText();
                if (text.contains(quary)){
                    System.out.println("Search query contains result are "+text);
                }else {
                    System.out.println("Search query contains no result");
                }
            }
        }

    }

}
