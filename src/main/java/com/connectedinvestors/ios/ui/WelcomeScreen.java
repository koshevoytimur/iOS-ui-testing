package com.connectedinvestors.ios.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeScreen extends ParentScreen {

    public WelcomeScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Access secure funding for all your real estate deals")
    @CacheLookup
    private WebElement firstLabel;

    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"CIX UAT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    @CacheLookup
    private WebElement firstImage;

    @FindBy(id = "Find and get notified of new properties in your area")
    @CacheLookup
    private WebElement secondLabel;

    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"CIX UAT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    @CacheLookup
    private WebElement secondImage;

    @FindBy(id = "Find and talk with cash buyers for your properties")
    @CacheLookup
    private WebElement thirdLabel;

    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"CIX UAT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    @CacheLookup
    private WebElement thirdImage;

    @FindBy(id = "Connect with investors in your local area")
    @CacheLookup
    private WebElement fourthLabel;

    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"CIX UAT\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage")
    @CacheLookup
    private WebElement fourthImage;

    int waitTime = 20;
    WebDriverWait testWeb = new WebDriverWait(driver, waitTime);

    public String getFirstLabelText() {
        testWeb.until(ExpectedConditions.visibilityOf(firstLabel));
//        System.out.println(isImageDisplayed(firstImage));
        return firstLabel.getText();
    }

    public String getSecondLabelText() {
        testWeb.until(ExpectedConditions.visibilityOf(secondLabel));
//        System.out.println(isImageDisplayed(secondImage));
        return secondLabel.getText();
    }

    public String getThirdLabelText() {
        testWeb.until(ExpectedConditions.visibilityOf(thirdLabel));
//        System.out.println(isImageDisplayed(thirdImage));
        return thirdLabel.getText();
    }

    public String getFourthLabelText() {
        testWeb.until(ExpectedConditions.visibilityOf(fourthLabel));
//        System.out.println(isImageDisplayed(fourthImage));
        return fourthLabel.getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismisAlert() {
        driver.switchTo().alert().dismiss();
    }

    public Boolean isImageDisplayed(WebElement image) {

        testWeb.until(ExpectedConditions.visibilityOf(image));
        Boolean result = image.isEnabled();
        System.out.println(image.getSize());
        System.out.println("IS IMAGE DISPLAYED?");
//        System.out.println(result);
        return result;
    }

}
