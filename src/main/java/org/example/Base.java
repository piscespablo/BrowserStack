package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.URL;

public class Base {

    private WebDriver driver;
    public static final String USERNAME = "paul1711";
    public static final String AUTOMATE_KEY = "7vPikaZusMU73jyxPLpx";
    public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

    @BeforeTest
    @Parameters(value = {"browser", "browser_version", "os", "os_version"})
    public void setUp(String browser, String browser_version, String os, String os_version) throws Exception {
        DesiredCapabilities capability = new DesiredCapabilities();


        capability.setCapability("resolution", "1920x1080");
        capability.setCapability("build", "StackTries");
        capability.setCapability("os", os);
        capability.setCapability("os_version", os_version);
        capability.setCapability("browser", browser);
        capability.setCapability("browser_version", browser_version);
        capability.setCapability("project", "BrowserStackSampleProject");
        driver = new RemoteWebDriver(new URL(URL), capability);
        driver.manage().window().maximize();
    }


}
