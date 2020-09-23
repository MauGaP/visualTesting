package org.visualvalidation.tasks;

import org.visualvalidation.pages.BasePage;
import org.visualvalidation.pages.PageFactory;
import org.visualvalidation.util.DriverManagement;

public class ClosePopUps {

    public static final String ADDRESS_NOT_NOW = "enterAddressNotNow";
    public static final String DISCOUNT_NOT_NOW = "getDiscountsNotNow";
    public static final String CLOSE_NOVEDADES_POP_UP = "closeNovedadesPopUp";

    public static void closePopUps() {
        BasePage identifiedPage = PageFactory.getPage("home");
        String addressNotNowButtonSelector = identifiedPage.identifyElement(ADDRESS_NOT_NOW);
        String discountNotNowButtonSelector = identifiedPage.identifyElement(DISCOUNT_NOT_NOW);
        String closeNovedadesPopUp = identifiedPage.identifyElement(CLOSE_NOVEDADES_POP_UP);

        if (DriverManagement.findElementsByCssSelector(addressNotNowButtonSelector).size() > 0) {
            DriverManagement.clickElement(DriverManagement.findElementByCssSelector(addressNotNowButtonSelector));
        }
        if (DriverManagement.findElementsByCssSelector(discountNotNowButtonSelector).size() > 0) {
            DriverManagement.clickElement(DriverManagement.findElementByCssSelector(discountNotNowButtonSelector));
        }
        if (DriverManagement.findElementsByCssSelector(closeNovedadesPopUp).size() > 0) {
            DriverManagement.clickElement(DriverManagement.findElementByCssSelector(closeNovedadesPopUp));
        }
    }
}
