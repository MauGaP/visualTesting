package org.visualvalidation.util;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.visualvalidation.util.commonconstants.TimeOutConstants;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobilePlatform.WINDOWS;

public class DriverManagement {

    public static WebDriver driver = null;

    public static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    public static final String envURL = variables.getProperty("envURL");

    public static void initializeDriver() {
        if (driver == null) {
            String chromeSwitches = variables.getProperty("chrome.switches");
            String OS = variables.getProperty("sun.desktop");
            String webDriverLocation = "";
            if (OS.equals(WINDOWS.toLowerCase())) {
                webDriverLocation = variables.getProperty("driver.windows.webdriver.chrome.driver");
            }

            System.setProperty("webdriver.chrome.driver", webDriverLocation);

            ChromeOptions options = new ChromeOptions();
            options.addArguments(chromeSwitches);
            driver = new ChromeDriver(options);
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TimeOutConstants.SHORT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TimeOutConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void navigateTo(String url) {
        if (driver == null) {
            initializeDriver();
        }
        driver.get(url);
    }

    public static String getDomainName(String url) throws URISyntaxException {
        if (driver == null) {
            return envURL;
        } else {
            URI uri = new URI(url);
            String domain = uri.getHost();
            return domain.startsWith("www.") ? domain.substring(4) : domain;
        }
    }

    public static String getURL() {
        if (driver == null) {
            return envURL;
        } else {
            String url = driver.getCurrentUrl();
            return url;
        }
    }

    public static void waitForElementToAppear(WebElement elementSelector) {
        new WebDriverWait(driver, 20).until(
                ExpectedConditions.visibilityOf(elementSelector));
    }

    public static WebElement findElementByCssSelector(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public static List<WebElement> findElementsByCssSelector(String cssSelector) {
        return driver.findElements(By.cssSelector(cssSelector));
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

    public static int getDriverWidth() {
        return driver.manage().window().getSize().width;
    }

    public static int getDriverHeight() {
        return driver.manage().window().getSize().height;
    }

    public static void clickElement(WebElement element) {
        waitForElementToAppear(element);
        element.click();
    }
}
