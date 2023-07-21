package hooks;

import com.microsoft.playwright.Page;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebActions;

public class Hooks {
    public Page page;

    @Before
    public void setUp() {
        String browserName = WebActions.getProperty("browser");
        page = DriverFactory.initDriver(browserName);
    }

    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}