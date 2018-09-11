package com.dice;

import base.BaseTest;
import org.testng.annotations.Test;

public class classTwo extends BaseTest {

    @Test
    public  void secondTestMethod(){
        //driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/feed/");
        System.out.println("Linkedin opened");
    }
}
