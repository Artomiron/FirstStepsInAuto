package base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class BasePageObject<T> {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger log;

    protected BasePageObject(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
        wait = new WebDriverWait(driver, 40);
    }

    //@SuppressWarnings("unchecked")
    protected T getPage(String url){
        driver.get(url);
        return (T) this;
    }

    protected void type(String text, By element){
        find(element).sendKeys(text);

    }

    protected void click(By element){
        find(element).click();

    }
    private WebElement find(By element) {
        return driver.findElement(element);
    }

    protected void waitForVisabilityOf(By locator, Integer... timeOutInSeconds){
        int attempts = 0;
        while (attempts < 2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e){

            }
            attempts++;
        }
    }

    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSecongs){
        timeOutInSecongs = timeOutInSecongs != null ? timeOutInSecongs : 45;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSecongs);
        wait.until(condition);
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    protected String getText(By element){
        return find(element).getText();
    }
}
