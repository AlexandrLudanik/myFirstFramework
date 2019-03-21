package com.epam.home.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckInstanceTypeTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkInstanceTypeText() {
        assertThat(calculatorPage.getInstanceType(), is(containsStringIgnoringCase(testInstance.getInstanceType())));
    }
}