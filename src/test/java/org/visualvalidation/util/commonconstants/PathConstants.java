package org.visualvalidation.util.commonconstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PathConstants {

    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy/");
    private static final LocalDateTime timestamp = LocalDateTime.now();
    private static final String FORMATED_DATE = timestamp.format(format);

    public static final String COMPARISON_RESULT = "target/screenshots/Comparison_Result/";
    public static final String FULL_PAGE_SCREEN = "_FullPageScreen";
    public static final String GOLDEN_IMAGE_FOLDER = "target/screenshots/Golden_Image/";
    public static final String TARGET_SCREENSHOT_FOLDER = "target/screenshots/" + FORMATED_DATE;
}
