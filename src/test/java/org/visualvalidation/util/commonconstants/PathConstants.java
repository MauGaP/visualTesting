package org.visualvalidation.util.commonconstants;

import org.visualvalidation.util.DriverManagement;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PathConstants {

    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy/");
    private static final LocalDateTime timestamp = LocalDateTime.now();
    private static final String FORMATTED_DATE = timestamp.format(format);

    private static final String URL = DriverManagement.getURL();

    public static final String COMPARISON_RESULT = "screenshots/Comparison_Result/";
    public static final String FULL_PAGE_SCREEN = "_Entire";
    public static final String GOLDEN_IMAGE_FOLDER = "screenshots/Golden_Image/";
    public static final String PNG_EXTENSION = ".png";

    private static String DOMAIN_NAME = null;
    public static String TAKEN_SCREENSHOT_FOLDER = null;

    private static String configureDomainName() throws URISyntaxException {
        DOMAIN_NAME = DriverManagement.getDomainName(URL);
        return DOMAIN_NAME;
    }

    static {
        try {
            TAKEN_SCREENSHOT_FOLDER = "screenshots/" + FORMATTED_DATE + configureDomainName() + "/";
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
