package com.thetestingacademy.basetest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.thetestingacademy.driver.DriverManagerTL;

import java.net.MalformedURLException;

public class CommonToAllTest {

    // To call the Start the Webdriver
    // Down the WebDriver

    // Who will start the Webdriver?
    @BeforeMethod
    protected void setUp() throws MalformedURLException {
        DriverManagerTL.init();
    }

    // Who will close the Webdriver
    @AfterMethod
    protected void tearDown(){
        DriverManagerTL.down();
    }






}
