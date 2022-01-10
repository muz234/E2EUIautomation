package Academy;

import Academy.pageObject.LandingPage;
import Academy.resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateNavBar extends Base {

    public WebDriver driver;
    public static Logger Log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void   initiazlize() throws IOException {
        driver = initializeDriver();
        Log.info("Driver is Initialized");
        driver.get(prop.getProperty("url"));
        Log.info("Navigated to Homepage");
    }

    @Test
    public void basePageNavigation() throws IOException {


        LandingPage L = new LandingPage(driver);
        Assert.assertTrue(L.getNavBar().isDisplayed());
        Log.info("Navigation bar is displayed");
        System.out.println("Navbar found");
    }

    @AfterTest
    public  void TearDown(){
        driver.close();
    }
}
