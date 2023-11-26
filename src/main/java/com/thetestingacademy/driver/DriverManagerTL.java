package com.thetestingacademy.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.net.MalformedURLException;
import java.util.Objects;

public class DriverManagerTL {


    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();


    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static WebDriver getDriver(){
        return dr.get();
    }

    // Unload
    public static void unload(){
        dr.remove();
    }

    public static void down() {
        if (Objects.nonNull(DriverManagerTL.getDriver())) {
            getDriver().quit();
            unload();
        }
    }

    public static void init() throws MalformedURLException {
        if (Objects.isNull(DriverManagerTL.getDriver())){
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--guest");
            options.addArguments("--remote-allow-origins=*");
            WebDriver driver = new EdgeDriver(options);
            setDriver(driver);
        }
    }









}
