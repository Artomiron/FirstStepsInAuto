package com.dice;

//import org.junit.Test; пришлось закоментить и добавить строку ниже. Инете TestSuit из testng.xml не запускался

import base.BaseTest;

import org.testng.annotations.Test;


public class classOne extends BaseTest {
    @Test
    public  void firstTestMethod(){
        //driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/ua/");
        System.out.println("Rozetka opened");
        System.out.println("Rozetka opened 2.1");
    }
}
