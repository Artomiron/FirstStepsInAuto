package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class ProfilePage extends BasePageObject<ProfilePage> {
    private By editProfilerButton = By.xpath("//button[@id = 'editProfile']");
    private By advancedSerchButton = By.xpath("//a[@class = 'dice-btn-link']");
    private By profileContactNameTest = By.xpath("//h1[@class = 'profile-contact-name']");

    public ProfilePage(WebDriver driver, Logger log){
        super(driver, log);
        //toDo auto generated constructor stub
    }

    public void waitForProfilePageLoad(){
        log.info("Wait for Profile Page Load");
        waitForVisabilityOf(editProfilerButton);
        waitForVisabilityOf(advancedSerchButton, 30);
    }

    public boolean isCorrectProfileLoaded(String correctProfileName){
        if(getText(profileContactNameTest).equals(correctProfileName))
            return true;
        return false;

    }
}
