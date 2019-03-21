package com.epam.home.test;

import com.epam.home.driver.DriverSingleton;
import com.epam.home.model.Instance;
import com.epam.home.pages.CalculatorPage;
import com.epam.home.pages.MainPage;
import com.epam.home.pages.MinutEmailPage;
import com.epam.home.service.InstanceCreator;
import com.epam.home.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonCondition {

    Instance testInstance = InstanceCreator.withCredentialsFromProperty();
    protected WebDriver driver;
    protected MainPage mainPage;
    protected CalculatorPage calculatorPage;
    protected MinutEmailPage minutEmailPage;

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        mainPage = new MainPage(driver);
        calculatorPage = new CalculatorPage(driver);
        minutEmailPage = new MinutEmailPage(driver);
        mainPage.openMainPage()
                .clickExploreAllProductsButton()
                .clickSeeePriceButton()
                .clickCalculatorButton()
                .enterIntoFrame()
                .chooseComputerEngine()
                .inputNumberOfInstances(testInstance)
                .inputWhatAreTheseInstancesFor(testInstance)
                .chooseOperatingSystem(testInstance)
                .chooseVMClass(testInstance)
                .chooseInstanceType(testInstance)
                .clickOnCheckboxAddGPUs()
                .chooseNumberOfGPU(testInstance)
                .chooseGPUType(testInstance)
                .chooseLocalSSD(testInstance)
                .chooseDataCenterLocation(testInstance)
                .chooseCommitedUsage(testInstance)
                .clickButtonAddToEstimate();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}

