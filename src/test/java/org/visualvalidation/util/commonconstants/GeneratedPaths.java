package org.visualvalidation.util.commonconstants;

import org.visualvalidation.util.DriverManagement;

import java.net.URISyntaxException;

import static org.visualvalidation.util.commonconstants.PathConstants.FORMATTED_DATE;

public class GeneratedPaths {

    private static final String URL = DriverManagement.getURL();
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
