package org.visualvalidation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.visualvalidation.util.commonconstants.TimeOutConstants;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverManagement {

    public static WebDriver driver = null;

    public static void initializeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito", "--disable-download-notification");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TimeOutConstants.SHORT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TimeOutConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void navigateTo(String url) {
        initializeDriver();
        driver.get(url);
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
