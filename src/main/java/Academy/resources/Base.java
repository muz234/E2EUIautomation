package Academy.resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;

    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fil = new FileInputStream("/Users/muzaffarahmed/Desktop/Selenium/AcademyTest/src/main/java/Academy/resources/Data.properties");

        prop.load(fil);
        String browserName =  prop.getProperty("Browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/muzaffarahmed/Desktop/Selenium/AcademyTest/chromedriver-2");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;


    }

    public void getScreenShotPath(String testCaseName, WebDriver driver){
        TakesScreenshot ts = (TakesScreenshot) driver;
       File source =  ts.getScreenshotAs(OutputType.FILE);
       String destinationFile = System.getProperty("/Users/muzaffarahmed/Desktop/Github/Selenium-project/Practice-tutorial/AcademyTest")
               +"\\reports\\" + testCaseName + ".png";
        try {
            FileUtils.copyFile(source, new File(destinationFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
