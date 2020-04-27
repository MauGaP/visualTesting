package org.visualvalidation.util.commonconstants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PathConstants {

    private static final LocalDateTime timestamp = LocalDateTime.now();
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mms/");
    private static final String FORMATED_DATE = timestamp.format(format);

    public static final String TARGET_SCREENSHOT_FOLDER = "target/screenshots/" + FORMATED_DATE;
}
