package com.connectedinvestors.ios.ui.tests;

import com.connectedinvestors.ios.ui.LogInScreen;
import com.connectedinvestors.ios.ui.WelcomeScreen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.connectedinvestors.ios.ui.ParentScreen.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public abstract class AbstractTest {

    protected static IOSDriver driver;

    public static LogInScreen LogInScreen;
    public static WelcomeScreen WelcomeScreen;

    @BeforeAll
    public static void createDriver() throws IOException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", PLATFORM_NAME);
        capabilities.setCapability("deviceName", DEVICE_NAME);
        capabilities.setCapability("platformVersion", PLATFORM_VERSION);
        capabilities.setCapability("app", APP_PATH);
        capabilities.setCapability("automationName", AUTOMATION_NAME);
//        capabilities.setCapability("autoAcceptAlerts", true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new IOSDriver<WebElement>(url, capabilities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeEach
    public void createDriverBeforeEachMethod(){

        LogInScreen = new LogInScreen(driver);
        WelcomeScreen = new WelcomeScreen(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


    public void waitForVisible(final By by, int waitTime) {
        int timeoutInSeconds = 10;
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        for (int attempt = 0; attempt < waitTime; attempt++) {
            try {
                driver.findElement(by);
                System.out.println(driver.findElement(by).getText());
                break;
            } catch (Exception e) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void checkAssertBool(String message, boolean actualResult, boolean expectedResult) {
        assertThat(message, actualResult, is(expectedResult));
    }


    public void checkAssertString(String message, String actualResult1, String expectedResult1) {
        assertThat(message, actualResult1, is(expectedResult1));
    }

}