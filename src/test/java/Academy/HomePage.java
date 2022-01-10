package Academy;

import Academy.pageObject.ForgotPassword;
import Academy.pageObject.LandingPage;
import Academy.pageObject.LoginPage;
import Academy.resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends Base {

    public WebDriver driver;
    public static Logger Log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void   initiazlize() throws IOException {
        driver = initializeDriver();
        Log.info("Driver is Initialized");
    }

    @Test(dataProvider =  "getData")
    public void basePageNavigation(String Username, String Password, String text) throws IOException {

        driver.get(prop.getProperty("url"));
        Log.info("Navigated to browser");
        LandingPage L = new LandingPage(driver);

        LoginPage lP = L.getLogin(); // driver.findElement(byCss

        Log.info("Navigated to Login page");
        lP.getEmail().sendKeys(Username);
        lP.getPass().sendKeys(Password);
        System.out.println(text);
        lP.loginButton().click();
        Log.info("Expected results found while passing resricted & non-restricted user");

        lP.loginButton().click();
        ForgotPassword fp =  lP.forgotPassword();
        fp.getEmail().sendKeys("xxx");
        fp.sendMeInstructions().click();
    }


    @AfterTest
    public  void TearDown(){

        driver.close();
    }


    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[2][3];
        data[0][0] = "nonrestricteruser@qw.com";
        data[0][1] = "123456";
        data[0][2] = "Restricted user";
        data[1][0] = "restricteruser@qw.com";
        data[1][1] = "456789";
        data[1][2] = "Non restrictied user";


        return data;

    }
}
