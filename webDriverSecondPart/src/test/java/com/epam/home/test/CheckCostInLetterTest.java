package com.epam.home.test;

import static com.epam.home.pages.CalculatorPage.totalEstimatedCost;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class CheckCostInLetterTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkTotalEstimatedCost() {
        Double totalEstimateCostInLetter =
                calculatorPage
                .totalEstimatedCost()
                .clickEmailEstimateButton()
                .sendLetter("https://10minutemail.net")
                .clickOnIncomingLetter()
                .getTotalEstimatedMonthlyCostFromLetter();

        assertThat(totalEstimateCostInLetter, is(equalTo(totalEstimatedCost)));
    }
}