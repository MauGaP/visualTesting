package org.visualvalidation.tasks.comparison;

import cucumber.api.java.en.When;

import java.io.IOException;

public class RunComparison {

    @When("I run the comparison Software")
    public static void runComparisonSoftware() throws IOException {
        CreateComparisonFolder.createComparisonFolder();

        CompareImages.compareImagesGivenImages();

    }
}
