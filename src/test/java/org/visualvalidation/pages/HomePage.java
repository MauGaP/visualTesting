package org.visualvalidation.pages;

import java.util.HashMap;

public class HomePage implements BasePage {

    HashMap<String, String> pageElements = new HashMap<String, String>();

    public HomePage() {
        pageElements.put("closeNovedadesPopUp", "#braindw_register > div.braindw_closepop");
        pageElements.put("header", "fp-header > main > header");
        pageElements.put("body", "fp-business > div > div");
        pageElements.put("footer", "fp-business > div > fp-footer");
        pageElements.put("mainLoader", ".app-main-loader");
        pageElements.put("enterAddressNotNow", ".ng-star-inserted > div > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1)");
        pageElements.put("getDiscountsNotNow", "#onesignal-slidedown-cancel-button");
        pageElements.put("entire", "fp-root > fp-business > div");
    }

    @Override
    public String identifyElement(String elementName) {
        String identifiedElement = pageElements.get(elementName);
        return identifiedElement;
    }
}