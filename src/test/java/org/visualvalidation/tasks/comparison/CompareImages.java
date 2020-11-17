package org.visualvalidation.tasks.comparison;

import com.resemble.Comparison;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.visualvalidation.util.DriverManagement.envURL;
import static org.visualvalidation.util.FolderScanner.GOLDEN_IMAGE_FOLDER;
import static org.visualvalidation.util.commonconstants.GeneratedPaths.TAKEN_SCREENSHOT_FOLDER;
import static org.visualvalidation.util.commonconstants.PathConstants.COMPARISON_RESULT;

public class CompareImages {
    public static void compareImagesGivenWithGoldenImages() throws IOException {

        List imageNames = ScanGoldenImageFolderForImages.scanGoldenImageFolderForImages();

        for (Object imageName : imageNames) {

            String goldenImagePath = GOLDEN_IMAGE_FOLDER + envURL + "/" + imageName;
            String imageToComparePath = TAKEN_SCREENSHOT_FOLDER + imageName;
            String imageDiffPath = COMPARISON_RESULT + envURL + "/" + imageName;

            String[] arrayOfImages = {goldenImagePath, imageToComparePath};

            BufferedImage diff = Comparison.compare(arrayOfImages);

            File diffedImage = new File(imageDiffPath);

            ImageIO.write(diff, "PNG", diffedImage);
            if (!ImageIO.write(diff, "PNG", diffedImage)) {
                throw new RuntimeException("Unexpected error writing image");
            }
        }
    }
}
