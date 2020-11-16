package org.visualvalidation.questions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.visualvalidation.tasks.comparison.ScanGoldenImageFolderForImages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.visualvalidation.util.DriverManagement.envURL;
import static org.visualvalidation.util.commonconstants.PathConstants.COMPARISON_RESULT;

public class ValidateCreatedFolderWithResults {

    @Then("There is a new folder with the result of the comparison")
    public static void validateFolderWithResultsOfComparison() throws IOException {
        File comparisonFolder = new File(COMPARISON_RESULT + envURL);
        Assert.assertTrue(comparisonFolder.exists());
        List fileNames = ScanGoldenImageFolderForImages.scanGoldenImageFolderForImages();
        for (Object fileName : fileNames) {
            ValidateCreatedImageOfComparison.validateCreatedComparisonImage(fileName.toString());
        }
    }
}

