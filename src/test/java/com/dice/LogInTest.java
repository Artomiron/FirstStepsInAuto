package com.dice;

import base.BaseTest;
import org.testng.Assert;
//import org.junit.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProfilePage;

public class LogInTest extends BaseTest {
    @Test
    public void possitiveLoginTest(){
        LogInPage loginPage = new LogInPage(driver);
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
        System.out.println("Varification");
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

    @Test
    public void negativeLoginTest(){
        String expectedErrorMassage = "Email and/or password incorrect.";
        LogInPage loginPage = new LogInPage(driver);

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
