package utils;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WebActions {
    public static boolean waitUntilLocatorIsDisplayed(Page page, Locator locator, int timeoutSec) {
        try {
            page.waitForTimeout(timeoutSec * 1000); // Wait for the element to be visible within the timeout
            return locator.isVisible();
        } catch (Exception e) {
            System.out.println(locator + " was not visible within the specified timeout.");
            return false;
        }
    }
}
