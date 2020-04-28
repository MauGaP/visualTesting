package org.visualvalidation.tasks.captures;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import cucumber.api.java.en.When;
import org.visualvalidation.tasks.ClosePopUps;
import org.visualvalidation.tasks.WaitForHomeToLoad;
import org.visualvalidation.util.DriverManagement;
import org.visualvalidation.util.commonconstants.PathConstants;

import java.io.IOException;

import static org.visualvalidation.util.commonconstants.PathConstants.FULL_PAGE_SCREEN;

public class CaptureEntireScreenshot {

    @When("He captures a screenshot of the entire (.*) Page")
    public void captureEntireScreen(String pageName) throws IOException {
        WaitForHomeToLoad.waitForHomeToLoad(pageName);
        ClosePopUps.closePopUps();
        Shutterbug.shootPage(DriverManagement.driver, ScrollStrategy.WHOLE_PAGE, 500)
                .withName(pageName + FULL_PAGE_SCREEN)
                .save(PathConstants.TAKEN_SCREENSHOT_FOLDER);
    }
}
