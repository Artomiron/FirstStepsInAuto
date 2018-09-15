package com.dice;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInTest extends BaseTest {
    @Test
    public void possitiveLoginTest(){
        LogInPage loginPage = new LogInPage(driver);
        loginPage.openLoginPage();

        // open authorization page

        loginPage.fillUpEmailAndPassword("s2b.artem@gmail.com", "slim1984");
        // set field login and password


        loginPage.pushSingingButton();
        // push the button login
        // varification
        // - user name correct
        // - page title correct

    }


}
