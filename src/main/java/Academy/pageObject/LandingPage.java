package Academy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    // WebDriverWait wait = new WebDriverWait(driver, 20);
    By signIn =  By.cssSelector("a[href*='sign_in']");
    By title = By.cssSelector(".text-center>h2");
    By navBar = By.cssSelector(".navbar-collapse.collapse");

    public LandingPage(WebDriver driver){

        this.driver = driver;
    }

    public LoginPage getLogin() {

        driver.findElement(signIn).click();
        LoginPage lP =new LoginPage(driver);

        return lP;

    }

    public WebElement getTitle(){
        return driver.findElement(title);
    }

    public WebElement getNavBar(){
        return driver.findElement(navBar);
    }
}
