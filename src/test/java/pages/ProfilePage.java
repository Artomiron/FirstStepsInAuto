package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject<ProfilePage> {
    private By editProfilerButton = By.xpath("//button[@id = 'editProfile']");
    private By advancedSerchButton = By.xpath("//a[@class = 'dice-btn-link']");
    private By profileContactNameTest = By.xpath("//h1[@class = 'profile-contact-name']");

    public ProfilePage(WebDriver driver){
        super(driver);
        //toDo auto generated constructor stub
    }

    public void waitForProfilePageLoad(){
        System.out.println("Wait for Profile Page Load");
        waitForVisabilityOf(editProfilerButton);
        waitForVisabilityOf(advancedSerchButton, 10);
    }

    public boolean isCorrectProfileLoaded(String correctProfileName){
        if(getText(profileContactNameTest).equals(correctProfileName))
            return true;
        return false;

    }
}
