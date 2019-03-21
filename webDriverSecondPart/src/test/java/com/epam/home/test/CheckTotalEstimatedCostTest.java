package com.epam.home.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CheckTotalEstimatedCostTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkTotalEstimatedCostText() {
        assertThat(calculatorPage.getTotalEstimatedCost(), is(equalTo(1187.77)));
    }
}