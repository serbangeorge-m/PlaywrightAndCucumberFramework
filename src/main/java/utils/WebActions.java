package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.Properties;

public class WebActions {
    public static boolean waitUntilLocatorIsDisplayed(Page page, Locator locator, int timeoutSec) {
        try {
            page.waitForTimeout(timeoutSec * 1000);
            return locator.isVisible();
        } catch (Exception e) {
            System.out.println(locator + " was not visible within the specified timeout.");
            return false;
        }
    }

    public static String getProperty(String key) {
        ConfigReader configReader = new ConfigReader();
        Properties properties = configReader.initProp();
        return properties.getProperty(key);
    }
}
