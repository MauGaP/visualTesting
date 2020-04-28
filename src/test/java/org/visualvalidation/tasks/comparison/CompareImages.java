package org.visualvalidation.tasks.comparison;

import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.StandardStream;

import java.io.IOException;
import java.util.List;

import static org.visualvalidation.util.commonconstants.PathConstants.*;

public class CompareImages {

    public static void compareImagesGivenImages() throws IOException {
        //scan Golden_Image folder and get a list of all the files
        List imageNames = ScanGoldenImageFolderForImages.scanGoldenImageFolderForImages();
        //create a method that iterates al the file names
        for (Object imageName : imageNames) {
            compareImages(GOLDEN_IMAGE_FOLDER + imageName,
                    TARGET_SCREENSHOT_FOLDER + imageName,
                    COMPARISON_RESULT);

        }
    }

    public static void compareImages(String goldenImage, String imageToCompare, String imageDiff) {

        CompareCmd compare = new CompareCmd();

        // For metric-output
        compare.setErrorConsumer(StandardStream.STDERR);
        IMOperation cmpOp = new IMOperation();
        // Set the compare metric
        cmpOp.metric("mae");

        // Add the expected image
        cmpOp.addImage(goldenImage);

        // Add the current image
        cmpOp.addImage(imageToCompare);

        // This stores the difference
        cmpOp.addImage(imageDiff);
    }
}
