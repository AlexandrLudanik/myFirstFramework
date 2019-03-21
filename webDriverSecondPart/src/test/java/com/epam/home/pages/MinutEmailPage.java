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

    @FindBy(xpath = "//*[@id='mailAddress']")
    private WebElement emailAddress;

    @FindBy(xpath = "//*[@id='ui-id-1']/span[@class='inc-mail-address']")
    private WebElement infoLineAboutLetter;

//    @FindBy(xpath = "//*[@id='mobilepadding']/td/table/tbody/tr[1]/td[1]/img")
    @FindBy(xpath = "//*[@id='mobilepadding']//img")
    private WebElement logoInTable;

    @FindBy(xpath = "//td//h3[text()[contains(.,'USD')]]")
    private WebElement totalEstimatedMonthlyCostIneLetter;


    public String saveEmailAddress() {
        return emailAddress.getAttribute("value");
    }

    public MinutEmailPage clickOnIncomingLetter() {
        getClickableElement(infoLineAboutLetter);
        getClickableElement(infoLineAboutLetter).click();
        logger.info("Click on incoming letter");
        return this;
    }

    public Double getTotalEstimatedMonthlyCostFromLetter() {
        getClickableElement(logoInTable);
        return StringParser.getDoubleFromString(totalEstimatedMonthlyCostIneLetter.getAttribute("innerText"));
    }
}