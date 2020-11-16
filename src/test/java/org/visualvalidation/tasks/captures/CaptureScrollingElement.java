package org.visualvalidation.tasks.captures;

import com.assertthat.selenium_shutterbug.core.PageSnapshot;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.openqa.selenium.WebElement;
import org.visualvalidation.tasks.ClosePopUps;
import org.visualvalidation.util.DriverManagement;

import static org.visualvalidation.util.commonconstants.GeneratedPaths.TAKEN_SCREENSHOT_FOLDER;
import static org.visualvalidation.util.commonconstants.PathConstants.FULL_PAGE_SCREEN;

public class CaptureScrollingElement {
    public static void captureScrollingElement(String elementName, WebElement elementToBeCaptured) {
        ClosePopUps.closePopUps();

        PageSnapshot completeScreenshot = Shutterbug.shootPage(DriverManagement.driver, ScrollStrategy.WHOLE_PAGE)
                .cropAround(elementToBeCaptured, 0, 0);

        if (elementName.contains("_Entire")) {
            elementName.replace("_Entire", FULL_PAGE_SCREEN);
        }
        completeScreenshot.withName(elementName).save(TAKEN_SCREENSHOT_FOLDER);
    }
}
