package com.epam.home.test;

import com.epam.home.model.Instance;
import com.epam.home.pages.MainPage;
import com.epam.home.service.InstanceCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckTotalAvailableSpaseSSDTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkTotalAvailableSpaseSSDText() {

        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        String totalAvailableSpaseSSD = new MainPage(driver)
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
                .getTotalAvailaleLocalSSDspace();

        assertThat(totalAvailableSpaseSSD, is(containsStringIgnoringCase(testInstance.getLocalSSD())));

    }
}