package com.connectedinvestors.ios.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParentScreen {
    WebDriver driver;

    public ParentScreen(WebDriver driver) {
        this.driver = driver;
        // logger = Logger.getLogger(getClass());
        // actionsWithOurElements = new ActionsWithOurElements(webDriver);
//	PageFactory.initElements(driver, this)
        int timeOut = 10;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeOut), this);
    }

    public static final String PLATFORM_NAME= "iOS";
    public static final String DEVICE_NAME = "iPhone 6s";
    public static final String PLATFORM_VERSION = "12.2";
    public static final String APP_PATH = "/Users/essence/Desktop/ConnectedInvestors/connectedinvestors.app";
    // /Users/essence/Desktop/ConnectedInvestors/connectedinvestors.app
    public static final String AUTOMATION_NAME = "XCUITest";
    public static final String USER_EMAIL = "qa.coninv@gmail.com";
    public static final String USER_PASSWORD = "property";

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

}