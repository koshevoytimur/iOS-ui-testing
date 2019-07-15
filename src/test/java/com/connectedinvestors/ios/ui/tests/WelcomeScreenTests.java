package com.connectedinvestors.ios.ui.tests;

import com.connectedinvestors.ios.ui.WelcomeScreen;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class WelcomeScreenTests extends AbstractTest{

    int alertWaitTimeInMillis = 2000;

    @Test
    public void checkUiOfWelcomeScreen() throws InterruptedException {


        LogInScreen.acceptAlert();
        Thread.sleep(alertWaitTimeInMillis);

        LogInScreen.acceptAlert();
        Thread.sleep(alertWaitTimeInMillis);

        LogInScreen.acceptAlert();
        Thread.sleep(alertWaitTimeInMillis);

        checkAssertString("Checking first label.", WelcomeScreen.getFirstLabelText(), "Access secure funding for all your real estate deals");
        System.out.println("1");
        System.out.println(WelcomeScreen.getFirstLabelText());


        checkAssertString("Checking second label.", WelcomeScreen.getSecondLabelText(), "Find and get notified of new properties in your area");
        System.out.println("2");
        System.out.println(WelcomeScreen.getSecondLabelText());


        checkAssertString("Checking third label.", WelcomeScreen.getThirdLabelText(), "Find and talk with cash buyers for your properties");
        System.out.println("3");
        System.out.println(WelcomeScreen.getThirdLabelText());


        checkAssertString("Checking fourth label.", WelcomeScreen.getFourthLabelText(), "Connect with investors in your local area");
        System.out.println("4");
        System.out.println(WelcomeScreen.getFourthLabelText());


        System.out.println(driver.findElement(By.id("Sign In")).getText());
        driver.findElement(By.id("Sign In")).click();

        System.out.println(driver.findElement(By.id("Login with Email")).getText());
        driver.findElement(By.id("Login with Email")).click();

    }


}
