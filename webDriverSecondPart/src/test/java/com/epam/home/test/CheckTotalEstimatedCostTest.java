package com.epam.home.test;

import com.epam.home.model.Instance;
import com.epam.home.pages.MainPage;
import com.epam.home.service.InstanceCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckTotalEstimatedCostTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkTotalEstimatedCostText() {

        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        String totalEstimatedCost = new MainPage(driver)
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
                .getTotalEstimatedCost();

        assertThat(totalEstimatedCost, is(equalTo("Total Estimated Cost: USD 1,187.77 per 1 month")));


    }
}