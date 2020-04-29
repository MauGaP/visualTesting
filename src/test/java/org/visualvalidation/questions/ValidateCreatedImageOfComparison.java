package org.visualvalidation.questions;

import org.junit.Assert;

import java.io.File;

import static org.visualvalidation.util.commonconstants.PathConstants.COMPARISON_RESULT;

public class ValidateCreatedImageOfComparison {
    public static void validateCreatedComparisonImage(String imageName) {
        File savedImage =new File(COMPARISON_RESULT + imageName);
        Assert.assertTrue(savedImage.exists());
    }
}
