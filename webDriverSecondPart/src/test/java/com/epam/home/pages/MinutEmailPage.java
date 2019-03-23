package com.epam.home.pages;

import com.epam.home.utils.StringParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MinutEmailPage extends AbstractPage {

    public MinutEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='fe_text']")
    private WebElement emailAddress;

    @FindBy(xpath = "//*[text()='Google Cloud Platform Price Estimate']")
    private WebElement newLetter;

    @FindBy(xpath = "//td//h3[text()[contains(.,'USD')]]")
    private WebElement totalEstimatedMonthlyCostIneLetter;


    public String saveEmailAddress() {
        return emailAddress.getAttribute("value");
    }

    public MinutEmailPage clickOnIncomingLetter() {
        waitUntilLetterComing(newLetter).click();
        logger.info("Click on incoming letter");
        return this;
    }

    public Double getTotalEstimatedMonthlyCostFromLetter() {
        return StringParser.getDoubleFromLetter(totalEstimatedMonthlyCostIneLetter.getText());
    }
}