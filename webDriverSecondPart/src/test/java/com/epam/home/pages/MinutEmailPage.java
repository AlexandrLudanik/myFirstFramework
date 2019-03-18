package com.epam.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinutEmailPage extends AbstractPage {


    public MinutEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='mailAddress']")
    private WebElement emailAddress;

    @FindBy(xpath = "//*[@id='ui-id-1']/span[@class='inc-mail-address']")
    private WebElement infoLineAboutLetter;

    @FindBy(xpath = "//*[@id=\"mobilepadding\"]/td/table/tbody/tr[1]/td[1]/img")
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

    public String getTotalEstimatedMonthlyCostFromLetter() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(logoInTable));
        return totalEstimatedMonthlyCostIneLetter.getAttribute("innerText");
    }
}
