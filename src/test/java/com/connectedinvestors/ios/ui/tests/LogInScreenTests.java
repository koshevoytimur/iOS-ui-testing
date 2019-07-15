package com.connectedinvestors.ios.ui.tests;

import com.connectedinvestors.ios.ui.LogInScreen;
import com.connectedinvestors.ios.ui.WelcomeScreen;
import io.appium.java_client.ios.IOSElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import sun.rmi.runtime.Log;

import static com.connectedinvestors.ios.ui.ParentScreen.USER_EMAIL;
import static com.connectedinvestors.ios.ui.ParentScreen.USER_PASSWORD;

public class LogInScreenTests extends AbstractTest{

    int alertWaitTimeInMillis = 1500;

    @Test
    @Order(1)
    public void goFromWelcomeScreenToSignIn() throws InterruptedException {

        System.out.println(LogInScreen.getAlertText());
        LogInScreen.acceptAlert();
        Thread.sleep(alertWaitTimeInMillis);

        System.out.println(LogInScreen.getAlertText());
        LogInScreen.acceptAlert();
        Thread.sleep(alertWaitTimeInMillis);

        System.out.println(LogInScreen.getAlertText());
        LogInScreen.acceptAlert();
        Thread.sleep(alertWaitTimeInMillis);

        LogInScreen.goToSignInScreen();
        checkAssertString("Checking if 'Login with email' button is present", LogInScreen.getLogWithEmailInBtnText(), "Login with Email");

    }

    @Test
    @Order(2)
    public void goFromSignInScreenToLoginWithEmail() {

        LogInScreen.pressLogInWithEmailBtn();
        checkAssertString("Checking if 'Log In' button is present", LogInScreen.getLogInBtnText(), "Sign In");

    }


    @ParameterizedTest(name = "{index} => email1= {0}, password1= {1}, result1= {2}")
    @Order(3)
    @CsvSource({"'essence@gmail.com', 'property', 'Warning\nUser with this email not registered Please try to login again'",
            "'qa.coninv@gmail.com', 'invalidPassword', 'Warning\nWrong password'",
            "'qa.coninv+1@gmail.com', 'property', 'Warning\nYour token is expired. Please log in again.'",
            "'', 'property', 'Email is not valid\nPlease enter a valid email address. For example \"John.Smith@example.com\".'",
            "'qa.coninv@gmail.com', '', 'Password is not valid\nYour password is too short.'"
    })
    public void negativeLogInWithInvalidEmail(String email1, String password1, String result1) throws InterruptedException {

        LogInScreen.logIn(email1, password1);
        Thread.sleep(alertWaitTimeInMillis);

        System.out.println(LogInScreen.getAlertText());
        checkAssertString("Validate alert text", LogInScreen.getAlertText(), result1);
        Thread.sleep(alertWaitTimeInMillis);

        LogInScreen.dismisAlert();
        Thread.sleep(alertWaitTimeInMillis);

        LogInScreen.clearEmail();
        LogInScreen.clearPass();
    }


    @Test
    @Order(4)
    public void performLogIn() throws InterruptedException {
        LogInScreen.logIn(USER_EMAIL, USER_PASSWORD);
        checkAssertString("Checking if 'Forum' button is present", LogInScreen.getForumBtnText(), "Forum");
        System.out.println(LogInScreen.getForumBtnText());
    }
}
