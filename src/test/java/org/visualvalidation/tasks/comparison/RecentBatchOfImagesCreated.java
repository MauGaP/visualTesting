package org.visualvalidation.tasks.comparison;

import cucumber.api.java.en.Given;
import org.junit.Assert;

import java.io.File;

import static org.visualvalidation.util.commonconstants.PathConstants.SCREENSHOT_MAIN_FOLDER;

public class RecentBatchOfImagesCreated {

    @Given("There is a recent batch of Images")
    public static void recentBatchOfImagesCreated() {

        File savedImage = new File(SCREENSHOT_MAIN_FOLDER + "/" + "inkafarma.pe/");
        Assert.assertTrue(savedImage.exists());
    }
}
