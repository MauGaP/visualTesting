package org.visualvalidation.tasks;

import org.openqa.selenium.WebElement;
import org.visualvalidation.util.DriverManagement;

public class ElementEntirelyDisplayed {
    public static boolean elementIsEntirelyDisplayed(WebElement element) {
        int elementHeight = element.getSize().height;
        int windowHeight = DriverManagement.getDriverHeight();
        return elementHeight < windowHeight;
    }
}
