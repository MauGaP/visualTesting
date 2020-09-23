package org.visualvalidation.util.commonconstants;

public class URLConstants {

    public static String DOMAIN_COM = ".com";
    public static String DOMAIN_PE = ".pe";
    public static String INKAFARMA = "inkafarma";
    public static String MIFARMA = "mifarma";
    public static String PROTOCOL = "https://";
    public static String WWW = "www.";

    public static String getURLFromURLName(String url) {
        String urlName = url.toLowerCase();
        switch (urlName) {
            case "inkafarma":
                urlName = INKAFARMA;
                urlName = composeURLWithWWW(urlName);
                return urlName;

            case "inkafarma qa1":
            case "inkafarma qa01":
                urlName = "inkafarmav2-qa01.cindibyinkafarma";
                urlName = composeURLWithoutWWW(urlName);

                return urlName;

            case "mifarma":
                urlName = MIFARMA;
                urlName = composeURLWithWWW(urlName);
                return urlName;

            case "mifarma qa1":
            case "mifarma qa01":
                urlName = "mifarmaqa.cindibyinkafarma";
                urlName = composeURLWithoutWWW(urlName);
                return urlName;

            case "mifarma v2 qa1":
            case "mifarma v2 qa01":
            case "mifarmav2 qa1":
            case "mifarmav2 qa01":
                urlName = "web-mifarma2-mfqa.cindibyinkafarma";
                urlName = composeURLWithoutWWW(urlName);
                return urlName;

            default:
                urlName = "Didn't match any URL";
                return urlName;
        }
    }

    public static String composeURLWithWWW(String urlName) {
        String composedUrl = PROTOCOL + WWW + urlName + DOMAIN_PE;
        return composedUrl;
    }

    public static String composeURLWithoutWWW(String urlName) {
        String composedUrl = PROTOCOL + urlName + DOMAIN_COM;
        return composedUrl;
    }
}
