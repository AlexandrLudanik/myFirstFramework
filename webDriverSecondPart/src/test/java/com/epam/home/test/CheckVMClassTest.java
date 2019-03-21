package com.epam.home.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CheckVMClassTest extends CommonCondition {

    @org.testng.annotations.Test
    public void checkVMClassText() {
        assertThat(calculatorPage.getVmClass(), is(containsStringIgnoringCase(testInstance.getVMClass())));
    }
}
