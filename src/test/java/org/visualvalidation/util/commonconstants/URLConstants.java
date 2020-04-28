package org.visualvalidation.util.commonconstants;

public class URLConstants {

    public static String DOMAIN = ".pe";
    public static String PROTOCOL = "https://";
    public static String WWW = "www.";

    public static String getURLFromURLName(String urlName) {
        String url = urlName.toLowerCase();
        url = PROTOCOL + WWW + url + DOMAIN;
        return url;
    }
}
