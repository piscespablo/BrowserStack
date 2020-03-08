package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class BrowserTest {

    public class multiConfiguration{

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
        @Test
        public void checkBoxesTest() throws InterruptedException {

            driver.get("https://the-internet.herokuapp.com/checkboxes");
            List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
            for(WebElement box : checkboxes) {

                if(!box.isSelected()) {
                    box.click();

                    Thread.sleep(2000);
                }
            }

        }

        @Test
        public void contextMenuTest() {

            driver.get("https://the-internet.herokuapp.com/context_menu");

            Actions context = new Actions(driver);
            WebElement object = driver.findElement(By.cssSelector("#hot-spot"));
            context.contextClick(object).build().perform();

            Alert a = driver.switchTo().alert();
            if (a.getText().contains("You selected a context menu")) {

                a.accept();
            }
        }


        @Test
        public void fileUploadTest() throws InterruptedException {

            driver.get("https://the-internet.herokuapp.com/upload");
            driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("/Users/paulosegun/Downloads/2016-0404-caregiver2.jpg");
            driver.findElement(By.cssSelector("#file-submit.button")).click();
            Thread.sleep(3000);
        }


        @Test
        public void iFrameTest() throws InterruptedException {

            driver.get("https://the-internet.herokuapp.com/iframe");
            Thread.sleep(2000);

            System.out.println(driver.findElements(By.tagName("iframe")).size());


            driver.switchTo().frame(0);

            driver.findElement(By.xpath("//body[@id='tinymce']//p")).sendKeys("God is Great");
            driver.switchTo().defaultContent();

            Thread.sleep(3000);



        }



        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }


    }
}
