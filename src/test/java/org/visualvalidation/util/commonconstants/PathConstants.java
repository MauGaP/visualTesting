package org.visualvalidation.util.commonconstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PathConstants {

    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy/");
    private static final LocalDateTime timestamp = LocalDateTime.now();
    private static final String FORMATTED_DATE = timestamp.format(format);

    public static final String COMPARISON_RESULT = "screenshots/Comparison_Result/";
    public static final String FULL_PAGE_SCREEN = "_Entire";
    public static final String GOLDEN_IMAGE_FOLDER = "screenshots/Golden_Image/";
    public static final String PNG_EXTENSION = ".png";
    public static final String TAKEN_SCREENSHOT_FOLDER = "screenshots/" + FORMATTED_DATE;
}
