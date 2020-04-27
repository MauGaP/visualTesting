package org.visualvalidation.tasks.captures;

import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.openqa.selenium.WebElement;
import org.visualvalidation.tasks.ClosePopUps;
import org.visualvalidation.util.DriverManagement;

import java.io.IOException;

import static org.visualvalidation.util.commonconstants.PathConstants.TARGET_SCREENSHOT_FOLDER;

public class CaptureElement {

    public static void captureElementScreenshot(String elementName, WebElement elementToBeCaptured) throws IOException {
        ClosePopUps.closePopUps();

        PageSnapshot completeScreenshot = Shutterbug.shootPage(DriverManagement.driver, ScrollStrategy.WHOLE_PAGE)
                .cropAround(elementToBeCaptured, 0, 0);

        completeScreenshot.withName(elementName).save(TARGET_SCREENSHOT_FOLDER);
    }
}