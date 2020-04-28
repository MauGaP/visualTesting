package org.visualvalidation.tasks.comparison;

import cucumber.api.java.en.Given;
import org.junit.Assert;

import java.io.File;

import static org.visualvalidation.util.commonconstants.PathConstants.TARGET_SCREENSHOT_FOLDER;

public class RecentBatchOfImagesCreated {
    @Given("There is a recent batch of Images")
    public static void resentBatchOfImagesCreated() {
        File savedImage = new File(TARGET_SCREENSHOT_FOLDER);
        Assert.assertTrue(savedImage.exists());
    }
}
