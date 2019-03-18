package com.epam.home.test;

import com.epam.home.driver.DriverSingleton;
import com.epam.home.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners({TestListener.class})
public class CommonCondition {


    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getWebDriver();
    }
}