package hooks;

import com.microsoft.playwright.Page;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public Page page;

    @Before
    public void setUp() {
        page = DriverFactory.initDriver("chrome");
    }

    @After
    public void tearDown() {
        DriverFactory.closeDriver();
    }
}