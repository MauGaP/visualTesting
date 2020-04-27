package org.visualvalidation.pages;

public class PageFactory {
    private static String HOME = "home";

    public static BasePage getPage(String name) {
        if (name.equals(HOME)) {
            return new HomePage();
        }
        return null;
    }
}
