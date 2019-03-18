package com.epam.home.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/";


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@track-name='exploreProducts']")
    private WebElement exploreAllProductsButton;


    public ProductsPage clickExploreAllProductsButton() {
        exploreAllProductsButton.click();
        logger.info("Click on button 'EXPLORE ALL PRODUCTS'");
        return new ProductsPage(driver);
    }

    public MainPage openMainPage() {
        driver.get(PAGE_URL);
        logger.info("Main Page open");
        return this;
    }
}
