package com.epam.home.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected static WebDriver driver;
    protected final Logger logger = LogManager.getRootLogger();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected static WebElement getClickableElement(By by) {
        return new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected WebElement getClickableElement(WebElement webElement) {
        return new WebDriverWait(driver,45).until(ExpectedConditions.elementToBeClickable(webElement));
    }
}