package com.epam.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PricingPage extends AbstractPage {


    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@track-name='pricingNav/calculators']")
    private WebElement calculatorButton;


    public CalculatorPage clickCalculatorButton() {
        calculatorButton.click();
        logger.info("Click on link 'Calculators'");
        return new CalculatorPage(driver);
    }
}
