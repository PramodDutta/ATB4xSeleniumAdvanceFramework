package com.thetestingacademy.vwo.LoginTests;

import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.pages.PageObjectModel.DashboardPage_POM;
import com.thetestingacademy.pages.PageObjectModel.LoginPage_POM;
import com.thetestingacademy.utils.PropertyReader;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

public class LoginTest extends CommonToAllTest {


    @Test(priority = 1)
    public void testLoginPNegative() throws Exception {

        // How to enter the user, pass and go the Dashboard and verify
        LoginPage_POM pagePom = new LoginPage_POM();
        pagePom.openURL(PropertyReader.readKey("url"));
        String error_message = pagePom.loginToVWONegative();
        Assertions.assertThat(error_message )
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readKey("error_message"));
    }

    @Test(priority = 2)
    public void testLoginPositive() throws Exception {

        // How to enter the user, pass and go the Dashboard and verify
        LoginPage_POM pagePom = new LoginPage_POM();
        pagePom.openURL(PropertyReader.readKey("url"));
        DashboardPage_POM dashboardPagePom = pagePom.loginToVWOPositive().afterLogin();
        String expected_username = dashboardPagePom.loggedInUserName();
        Assertions.assertThat(expected_username)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readKey("expected_username"));

    }



}
