package org.visualvalidation.acceptancetests;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.visualvalidation.util.DriverManagement;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/", glue = "org.visualvalidation")
public class AcceptanceTestSuite {

    @BeforeClass
    public static void setUp() {
        DriverManagement.initializeDriver();
    }

    @AfterClass
    public static void tearDown() {
        DriverManagement.closeDriver();
    }

}
