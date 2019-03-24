package com.epam.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PricingPage extends AbstractPage {


    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@track-name='pricing']")
    private WebElement pricingButton;

    @FindBy(xpath = "//*[@track-metadata-eventdetail='calculators']")
    private WebElement calculatorLink;


    public CalculatorPage clickCalculatorButton() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitUntilElementBeClicable(pricingButton).click();
        waitUntilElementBeClicable(calculatorLink).click();
        logger.info("Click on link 'Calculators'");
        return new CalculatorPage(driver);
    }
}
