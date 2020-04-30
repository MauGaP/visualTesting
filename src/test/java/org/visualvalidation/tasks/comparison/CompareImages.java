package org.visualvalidation.tasks.comparison;

import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.StandardStream;

import java.io.IOException;
import java.util.List;

import static org.visualvalidation.util.commonconstants.PathConstants.*;

public class CompareImages {

    public static void compareImagesGivenWithGoldenImages() throws IOException {

        List imageNames = ScanGoldenImageFolderForImages.scanGoldenImageFolderForImages();

        for (Object imageName : imageNames) {

            String goldenImage = GOLDEN_IMAGE_FOLDER + imageName;
            String imageToCompare = TAKEN_SCREENSHOT_FOLDER + imageName;
            String imageDiff = COMPARISON_RESULT + imageName;

            CompareCmd compare = new CompareCmd();

            // For metric-output
            compare.setErrorConsumer(StandardStream.STDERR);
            IMOperation cmpOp = new IMOperation();

            // Set the compare metric
            cmpOp.metric("MAE");

            // TODO find a fuzz level to ignore some minor changes
            cmpOp.fuzz(10.0);

            // Add the expected image
            cmpOp.addImage(goldenImage);

            // Add the current image
            cmpOp.addImage(imageToCompare);

            // This stores the difference
            cmpOp.addImage(imageDiff);

            try {
                compare.run(cmpOp);
            }
            catch (Exception ex) {
            }
        }
    }
}
