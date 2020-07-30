package org.visualvalidation.questions;

import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.io.File;

import static org.visualvalidation.util.commonconstants.PathConstants.*;

public class ValidateCreatedImageOfCapture {

    @Then("The image of (.*) in (.*) is saved")
    public static void validateElementImageIsSaved(String elementName, String pageName) {
        String elementIdentifier = pageName + "_" + elementName;
        File savedImage = new File(TAKEN_SCREENSHOT_FOLDER + elementIdentifier + PNG_EXTENSION);
        Assert.assertTrue(savedImage.exists());
    }

    @Then("The image of entire (.*) is saved")
    public static void validatePageImageIsSaved(String pageName) {
        String pageIdentifier = pageName + FULL_PAGE_SCREEN;
        File savedImage = new File(TAKEN_SCREENSHOT_FOLDER + pageIdentifier + PNG_EXTENSION);
        Assert.assertTrue(savedImage.exists());
        //esto es un comment
    }
}
