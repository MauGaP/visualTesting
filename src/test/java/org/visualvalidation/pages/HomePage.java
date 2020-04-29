package org.visualvalidation.pages;

import java.util.HashMap;

public class HomePage implements BasePage {

    HashMap<String, String> pageElements = new HashMap<String, String>();

    public HomePage() {
        pageElements.put("header", "inkafarma-header");
        pageElements.put("body", "#home");
        pageElements.put("footer", "inkafarma-footer > footer");
        pageElements.put("mainLoader", ".app-main-loader");
        pageElements.put("enterAddressNotNow", "#notNowAddress");
        pageElements.put("getDiscountsNotNow", "#onesignal-popover-cancel-button");
        pageElements.put("entire", "inkafarma-business > div");
    }

    @Override
    public String identifyElement(String elementName) {
        String identifiedElement = pageElements.get(elementName);
        return identifiedElement;
    }
}