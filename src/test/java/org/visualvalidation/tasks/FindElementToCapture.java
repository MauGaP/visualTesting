package org.visualvalidation.tasks;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.visualvalidation.pages.BasePage;
import org.visualvalidation.pages.PageFactory;

import java.io.IOException;
import java.util.Arrays;

import static org.visualvalidation.tasks.captures.CaptureElement.captureElementScreenshot;
import static org.visualvalidation.tasks.captures.CaptureScrollingElement.captureScrollingElement;
import static org.visualvalidation.util.DriverManagement.findElementByCssSelector;

public class FindElementToCapture {
    @When("He captures a screenshot of the (.*) (.*)")
    public void findAndCaptureElementScrenshot(String elementName, String pageName) throws IOException {
        BasePage identifiedPage = PageFactory.getPage(pageName.toLowerCase());

        assert identifiedPage != null;
        if (elementName.contains(" in")) {
            elementName = elementName.replace(" in", "");
        }

        String elementSelector = identifiedPage.identifyElement(elementName.toLowerCase());

        String elementIdentifier = pageName + "_" + elementName;

        //TODO create a method that can handle other selectors different from cssSelectors
        WebElement elementToBeCaptured = findElementByCssSelector(elementSelector);
        if (ElementEntirelyDisplayed.elementIsEntirelyDisplayed(elementToBeCaptured)) {
            captureElementScreenshot(elementIdentifier, elementToBeCaptured);
        } else {
            captureScrollingElement(elementIdentifier, elementToBeCaptured);
        }
    }
}
