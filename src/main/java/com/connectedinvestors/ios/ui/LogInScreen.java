package com.connectedinvestors.ios.ui;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogInScreen extends ParentScreen {

    public LogInScreen(WebDriver driver) {
        super(driver);
    }

//    @FindBy(id = "Sign In") // Change to xpath
    @FindBy(xpath = "//XCUIElementTypeButton[@name='Sign In']")
    @CacheLookup
    private WebElement goToSignInBtn;

    @FindBy(id = "Login with Email")
    @CacheLookup
    private WebElement logInWithEmailBtn;

    @FindBy(xpath = "//XCUIElementTypeApplication[@name='CIX UAT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField")
    @CacheLookup
    private WebElement emailTF;

    @FindBy(xpath = "//XCUIElementTypeApplication[@name='CIX UAT']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
    @CacheLookup
    private WebElement passTF;

    @FindBy(id = "Sign In")
    @CacheLookup
    private WebElement signInBtn;

    @FindBy(id = "Forum")
    @CacheLookup
    private WebElement forumBtn;

    @FindBy(id = "icon_logo")
    @CacheLookup
    private  WebElement safeArea;

    @FindBy(id = "Ellipse 1")
    @CacheLookup
    private  WebElement elipse1;

    @FindBy(id = "Ellipse 1 copy")
    @CacheLookup
    private  WebElement elipse1Copy;

////    @FindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
    @FindBy(name = "Done")
    @CacheLookup
    private WebElement doneBtn;

    int waitTime = 50;
    WebDriverWait testWeb = new WebDriverWait(driver, waitTime);

    int alertWaitTimeInMillis = 2000;

    public void goToSignInScreen() {
        testWeb.until(ExpectedConditions.visibilityOf(goToSignInBtn)).click();
        goToSignInBtn.click();
    }


    public String getLogWithEmailInBtnText() {
        return logInWithEmailBtn.getText();
    }

    public void pressLogInWithEmailBtn() {
        logInWithEmailBtn.click();
    }

    public String getLogInBtnText() {
        return signInBtn.getText();
    }

    public void logIn(String email, String password) throws InterruptedException {

        emailTF.click();
        emailTF.sendKeys(email);
        Thread.sleep(alertWaitTimeInMillis);

        passTF.click();
        passTF.sendKeys(password);
        Thread.sleep(alertWaitTimeInMillis);

//        doneBtn.click();
        dismissKeyboad();
        Thread.sleep(1000);
//        elipse1.click();
//        Thread.sleep(500);
//        elipse1Copy.click();
//        Thread.sleep(500);
        signInBtn.click();

        Thread.sleep(alertWaitTimeInMillis);

    }

    public void dismissKeyboad() throws InterruptedException {
        TouchAction action = new TouchAction((PerformsTouchActions) driver);
        action.press(PointOption.point(safeArea.getLocation().x, safeArea.getLocation().y));
        Thread.sleep(500);
        action.release();
        action.perform();
    }

    public void clearEmail() {
        emailTF.clear();
    }

    public void clearPass() {
        passTF.clear();
    }

    public String getForumBtnText() {
        return forumBtn.getText();
    }

    public String getAlertText() {
        String alertText =  driver.switchTo().alert().getText();
        return alertText;
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismisAlert() {
        driver.switchTo().alert().dismiss();
    }


//        WebElement emailTextField = driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"CIX UAT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField"));
//        emailTextField.click();
//        emailTextField.sendKeys(someText);

//        driver.findElement(By.id("Sign In")).click();

}
