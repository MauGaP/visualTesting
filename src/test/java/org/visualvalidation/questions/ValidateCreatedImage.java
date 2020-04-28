package org.visualvalidation.questions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.visualvalidation.util.commonconstants.PathConstants;

import java.io.File;

import static org.visualvalidation.util.commonconstants.PathConstants.FULL_PAGE_SCREEN;
import static org.visualvalidation.util.commonconstants.PathConstants.TARGET_SCREENSHOT_FOLDER;

public class ValidateCreatedImage {

    //get a file

    @Then("The image of (.*) in (.*) is saved")
    public static void validateElementImageIsSaved(String elementName, String pageName) {
        String elementIdentifier = pageName + "_" + elementName;
        File savedImage = new File(TARGET_SCREENSHOT_FOLDER + elementIdentifier);
        Assert.assertTrue(savedImage.exists());
    }

    @Then("The image of entire (.*) is saved")
    public static void validatePageImageIsSaved(String pageName) {
        String pageIdentifier = pageName + FULL_PAGE_SCREEN;
        File savedImage = new File(TARGET_SCREENSHOT_FOLDER + pageIdentifier);
        Assert.assertTrue(savedImage.exists());
    }
}
