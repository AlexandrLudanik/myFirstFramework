package com.epam.home.test;

import com.epam.home.model.Instance;
import com.epam.home.pages.CalculatorPage;
import com.epam.home.pages.MainPage;
import com.epam.home.service.InstanceCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckCostInLetterTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkTotalEstimatedCost() {
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        String totalEstimateCostInLetter = new MainPage(driver)
                .openMainPage()
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
                .clickButtonAddToEstimate()
                .totalEstimatedCost()
                .clickEmailEstimateButton()
                .sendLetter("https://10minutemail.com")
                .clickOnIncomingLetter()
                .getTotalEstimatedMonthlyCostFromLetter();

        assertThat(totalEstimateCostInLetter, is(containsStringIgnoringCase(CalculatorPage.totalEstimatedCost)));
    }
}