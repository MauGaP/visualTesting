package org.visualvalidation.tasks.comparison;

import cucumber.api.java.en.Given;
import org.junit.Assert;

import java.io.File;

import static org.visualvalidation.util.commonconstants.PathConstants.GOLDEN_IMAGE_FOLDER;

public class GoldenImageFolderIsPresent {

    @Given("There is a Golden Image Folder")
    public static void goldenImageIsPresent() {
        File savedImage = new File(GOLDEN_IMAGE_FOLDER);
        Assert.assertTrue(savedImage.exists());
    }
}
