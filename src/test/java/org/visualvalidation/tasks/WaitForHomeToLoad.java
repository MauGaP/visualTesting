package org.visualvalidation.tasks;

import org.openqa.selenium.WebElement;
import org.visualvalidation.pages.BasePage;
import org.visualvalidation.pages.PageFactory;
import org.visualvalidation.util.DriverManagement;

public class WaitForHomeToLoad {

    public static void waitForHomeToLoad(String pageName) {
        BasePage identifiedPage = PageFactory.getPage(pageName.toLowerCase());
        String headerSelector = identifiedPage.identifyElement("header");
        WebElement headerElement = DriverManagement.findElementByCssSelector(headerSelector);
        DriverManagement.waitForElementToAppear(headerElement);
    }
}
