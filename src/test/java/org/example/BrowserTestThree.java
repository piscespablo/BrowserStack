package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserTestThree extends Base{
    WebDriver driver;



    @BeforeTest
    public void CallSetUpFromBase(){

       // I don't want to repeat the same lines over in every test class so i'd like to be able to call the setup method from Base Class here' with errors


    }

    @AfterTest
    public void tearDown(){
        driver.quit();

    }


    @Test
    public void firstTest(){


    }
}
