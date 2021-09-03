package base;

import common.BrowserManager;import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static common.DriverInit.getDriver;
import static constants.ConstantsAndConfig.HOLD_BROWSER_OPEN;

public abstract class BaseTest {

    protected final BrowserManager browserManager = new BrowserManager(getDriver());

    @BeforeTest
    protected void setUp() {
        browserManager.setWindowMaxSize();
    }

    @AfterTest
    protected void close() {
        if (!HOLD_BROWSER_OPEN) {
            browserManager.quit();
        }
    }
}
