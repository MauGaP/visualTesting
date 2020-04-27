package org.visualvalidation.tasks.captures;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.WebElement;
import org.visualvalidation.tasks.ClosePopUps;
import org.visualvalidation.util.DriverManagement;

import java.io.IOException;

import static org.visualvalidation.util.commonconstants.PathConstants.TARGET_SCREENSHOT_FOLDER;

public class CaptureElement {

    public static void captureElementScreenshot(String elementName, WebElement elementToBeCaptured) throws IOException {
        ClosePopUps.closePopUps();

        Shutterbug.shootElement(DriverManagement.driver, elementToBeCaptured)
                .withName(elementName)
                .save(TARGET_SCREENSHOT_FOLDER);
    }
}