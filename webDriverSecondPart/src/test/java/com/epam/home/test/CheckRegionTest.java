package com.epam.home.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckRegionTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkRegionText() {
        assertThat(calculatorPage.getRegion(), is(containsStringIgnoringCase(testInstance.getDataCenterLocation())));
    }
}