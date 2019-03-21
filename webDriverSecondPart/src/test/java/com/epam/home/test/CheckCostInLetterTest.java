package com.epam.home.test;

import com.epam.home.pages.CalculatorPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckCostInLetterTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkTotalEstimatedCost() {
        Double totalEstimateCostInLetter =
                calculatorPage
                .totalEstimatedCost()
                .clickEmailEstimateButton()
                .sendLetter("https://10minutemail.com")
                .clickOnIncomingLetter()
                .getTotalEstimatedMonthlyCostFromLetter();

        assertThat(totalEstimateCostInLetter, is(equals(CalculatorPage.totalEstimatedCost)));
    }
}