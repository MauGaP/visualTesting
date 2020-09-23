package org.visualvalidation.tasks;

import cucumber.api.java.en.Given;
import org.visualvalidation.util.DriverManagement;
import org.visualvalidation.util.commonconstants.URLConstants;

public class Navigate {

    //TODO this method will need some refactoring in order to be able to navigate to other pages, like a SKU, etc
    @Given("The user is on the (.*) Page")
    public void theUserIsOnThePage(String urlName) {
        String page = URLConstants.getURLFromURLName(urlName);
        DriverManagement.navigateTo(page);
    }
}
