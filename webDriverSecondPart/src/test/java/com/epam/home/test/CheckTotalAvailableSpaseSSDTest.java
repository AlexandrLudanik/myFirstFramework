package com.epam.home.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckTotalAvailableSpaseSSDTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkTotalAvailableSpaseSSDText() {
        assertThat(calculatorPage.getTotalAvailaleLocalSSDspace(), is(containsStringIgnoringCase(testInstance.getLocalSSD())));
    }
}