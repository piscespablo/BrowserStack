package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserTestTwo {

    WebDriver driver;

    public static final String USERNAME = "paul1711";
    public static final String AUTOMATE_KEY = "7vPikaZusMU73jyxPLpx";

    @DataProvider(name="Browser_Data", parallel=true)
    public Object[][] getDesiredCaps(){
        Object[][] testData = new Object[][] {
                {Platform.WIN8, "firefox"},
                {Platform.MAC, "firefox"},
                {Platform.WIN8, "chrome"},
                {Platform.MAC, "chrome"},
                {Platform.MAC, "Safari"}
        };
        return testData;
    }

    @Test(dataProvider="Browser_Data")
    public void testSeleniumOnBrowserStackCloud(Platform platform, String browserName) throws MalformedURLException {
        // Create Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(platform);
        caps.setBrowserName(browserName);

        // Create server Url
        String stringURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
        driver = new RemoteWebDriver(new URL(stringURL), caps);
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());

        driver.quit();
    }



    @Test(dataProvider="Browser_Data")
    public void multiPrint(Platform platform, String browserName) throws MalformedURLException {

        // Create Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(platform);
        caps.setBrowserName(browserName);

        // Create server Url
        String stringURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
        driver = new RemoteWebDriver(new URL(stringURL), caps);

      driver.get("https://www.facebook.com/paul.osegun");
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));

        }
    }


