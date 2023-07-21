package factory;

import com.microsoft.playwright.*;
import utils.WebActions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static Map<String, BrowserType> browserTypes = new HashMap<>();
    private static ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();
    private static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    static {
        // Initialize browser types
        browserTypes.put("firefox", Playwright.create().firefox());
        browserTypes.put("chrome", Playwright.create().chromium());
    }

    public static Page initDriver(String browserName) {
        boolean headless = Boolean.valueOf(WebActions.getProperty("headless"));
        BrowserType browserType = browserTypes.get(browserName);
        if (browserType == null) {
            throw new IllegalArgumentException("Could not Launch Browser for type " + browserName);
        }

        // Launch the browser
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(headless));
        threadLocalBrowser.set(browser);

        // Create a new context and page
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        // Start tracing (optional)
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));

        // Save context and page to thread-local variables
        threadLocalContext.set(context);
        threadLocalPage.set(page);

        return page;
    }

    public static synchronized Page getPage() {
        return threadLocalPage.get();
    }

    public static synchronized BrowserContext getContext() {
        return threadLocalContext.get();
    }

    public static synchronized void closeDriver() {
        Page page = threadLocalPage.get();
        BrowserContext context = threadLocalContext.get();
        Browser browser = threadLocalBrowser.get();

        if (page != null) {
            page.close();
            threadLocalPage.remove();
        }
        if (context != null) {
            context.close();
            threadLocalContext.remove();
        }
        if (browser != null) {
            browser.close();
            threadLocalBrowser.remove();
        }
    }
}
