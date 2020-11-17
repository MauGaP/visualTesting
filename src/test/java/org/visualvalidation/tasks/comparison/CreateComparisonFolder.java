package org.visualvalidation.tasks.comparison;

import java.io.File;

import static org.visualvalidation.util.DriverManagement.envURL;
import static org.visualvalidation.util.commonconstants.PathConstants.COMPARISON_RESULT;

public class CreateComparisonFolder {

    public static void createComparisonFolder() {

        File comparisonResultFolder = new File(COMPARISON_RESULT + envURL);
        comparisonResultFolder.mkdir();
    }
}
