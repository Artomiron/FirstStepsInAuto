package pages;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePageObject<ProfilePage> {
    private By editProfilerButton = By.xpath("//button[@id = 'editProfile']");
    private By advancedSerchButton = By.xpath("//a[@class = 'dice-btn-link']");

    public ProfilePage(WebDriver driver){
        super(driver);
        //toDo auto generated constructor stub
    }

    public void waitForProfilePageLoad(){
        waitForVisabilityOf(editProfilerButton);
        waitForVisabilityOf(advancedSerchButton, 10);
    }
}
