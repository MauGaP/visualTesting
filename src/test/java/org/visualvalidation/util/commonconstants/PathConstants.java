package org.visualvalidation.util.commonconstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PathConstants {
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd/");
    private static final LocalDateTime timestamp = LocalDateTime.now();
    public static final String FORMATTED_DATE = timestamp.format(format);

    public static final String COMPARISON_RESULT = "screenshots/Comparison_Result/";
    public static final String FULL_PAGE_SCREEN = "_Entire";
    public static final String PNG_EXTENSION = ".png";
}
