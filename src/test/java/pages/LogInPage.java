package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class LogInPage extends BasePageObject<LogInPage> {

    private static final String URL = "https://www.dice.com/dashboard/logout";

    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By singButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//span[@data-automation-id='login-failure-help-message']");

    public LogInPage(WebDriver driver, Logger log){
        super(driver, log);
        //toDo auto generated constructor stub
    }

    public void openLoginPage(){
        getPage(URL);
    }

    public void fillUpEmailAndPassword(String email, String password){
        log.info("Filling up email and password");
        type(email, emailField);
        type(password, passwordField);
    }

    public ProfilePage pushSingingButton(){
        log.info("Clicking on Sing In Button");
        click(singButton);
        return new ProfilePage(driver, log);
    }

    public String getLogInErrorMessage(){
        waitForVisabilityOf(errorMessage, 30);
        return getText(errorMessage);

    }
}
