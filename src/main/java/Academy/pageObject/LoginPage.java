package Academy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    // WebDriverWait wait = new WebDriverWait(driver, 20);
    By email =  By.cssSelector("[id='user_email']");
    By password = By.cssSelector("[type='password']");
    By bLogin = By.cssSelector("[value='Log In']");
    By forgotPassword = By.cssSelector("[href*='password/new']");

    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement getEmail() {

        return driver.findElement(email);
    }

    public WebElement getPass() {

        return driver.findElement(password);
    }

    public WebElement loginButton() {

        return driver.findElement(bLogin);
    }
    public ForgotPassword forgotPassword()
    {
        driver.findElement(forgotPassword).click();
        ForgotPassword fP = new ForgotPassword(driver);
        return fP;

    }

}
