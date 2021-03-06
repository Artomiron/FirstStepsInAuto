package com.dice;

import base.BaseTest;
import base.CsvDataProvider;
import org.testng.Assert;
//import org.junit.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProfilePage;

import java.util.Map;


public class LogInTest extends BaseTest {
    @Test (priority = 1, groups = { "positive" })
    public void possitiveLoginTest(){
        LogInPage loginPage = new LogInPage(driver, log);
        String expectedPageTitle = "Seeker Dashboard - Profile";
        String correctProfileName = "Tom Soyer";

        loginPage.openLoginPage();

        // open authorization page

        loginPage.fillUpEmailAndPassword("s2b.artem@gmail.com", "9379992atom");
        // set field login and password

        ProfilePage profilePage = loginPage.pushSingingButton();
        profilePage.waitForProfilePageLoad();
        // push the button login


        // varification
        log.info("Varification");
        String actualTitle = profilePage.getTitle();
        /*Assert.assertTrue("Page title is not expected. \nExpected: " + expectedPageTitle + "\nActual: " + actualTitle,
                expectedPageTitle.equals(actualTitle)); this assert is for junit*/
        Assert.assertTrue(expectedPageTitle.equals(actualTitle),
                "Page title is not expected.\nExpected: " + expectedPageTitle + "\nActual: " + actualTitle + ".");
        // - page title correct

        Assert.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName),
                "Profile name is not expected.");
        // - profile name correct

    }

    @Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 2, groups = { "negative", "broken" })
    public void negativeLoginTest(Map<String,String> testData){
        String expectedErrorMassage = "Email and/or password incorrect.";

        String testNumber = testData.get("no");
        String email = testData.get("email");
        String password = testData.get("password");
        String description = testData.get("description");

        log.info("test No #" + testNumber + " for " + description + " where \nEmail:" + email + " \nPassword: " + password);


        LogInPage loginPage = new LogInPage(driver, log);

        loginPage.openLoginPage();

        // open authorization page

        loginPage.fillUpEmailAndPassword("s2b.artemm@gmail.com", "9379992atom");
        // set field login and password

        loginPage.pushSingingButton();

        String errorMessage = loginPage.getLogInErrorMessage();

        Assert.assertTrue(errorMessage.contains(expectedErrorMassage),
                "Error message is not expected. \nExpected: " + expectedErrorMassage + "\nActual: " + errorMessage + ".");

    }


}
