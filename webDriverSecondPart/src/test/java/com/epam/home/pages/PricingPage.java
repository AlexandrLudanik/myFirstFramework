package com.epam.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingPage extends AbstractPage {


    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"cloud-site\"]/nav/div/div/ul/li[3]/a")
    private WebElement calculatorButton;


    public CalculatorPage clickCalculatorButton() {
        calculatorButton.click();
        logger.info("Click on link 'Calculators'");
        return new CalculatorPage(driver);
    }
}
