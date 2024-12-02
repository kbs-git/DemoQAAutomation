package facebookTestsUsingPom.tests;

import com.base.BaseClass;
import com.pages.faceBookpages.SerachContext1;
import com.utilities.ReadPropFile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchContextTest {

    @BeforeTest
    public void setUp(){
        try {
            BaseClass.initialize(ReadPropFile.getObject("browser"), ReadPropFile.getObject("flipcartUrl"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void tearDown(){
        BaseClass.quit();
    }

    @Test
    public void searchContextTest(){
        SerachContext1 serachContext=new SerachContext1(BaseClass.driver);
        serachContext.searchForItem("Apple iPhone");
    }
}
