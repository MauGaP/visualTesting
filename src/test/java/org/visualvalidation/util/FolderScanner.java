package org.visualvalidation.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.visualvalidation.util.DriverManagement.variables;
import static org.visualvalidation.util.commonconstants.PathConstants.FORMATTED_DATE;

public class FolderScanner {
    public static final String GOLDEN_IMAGE_FOLDER = "screenshots/Golden_Image/";
    public static final String SCREENSHOT_MAIN_FOLDER = "screenshots/" + FORMATTED_DATE + variables.getProperty("envURL");

    public static void scanForGoldenImages() throws IOException, URISyntaxException {
        URI path = new URI(GOLDEN_IMAGE_FOLDER);
        Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .forEach(System.out::println);
    }

    public static void scanForResentBatchOfImagesCaptured() {

    }

    public static void scanForComparisonResultFolder() {

    }
}
