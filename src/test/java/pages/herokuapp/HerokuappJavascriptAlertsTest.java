package pages.herokuapp;

import base.BaseTest;
import common.ConfigReader;
import constants.ConstantsAndConfig;
import elements.Alert;
import elements.Button;
import elements.TextField;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.Logger.LOGGER;

public class HerokuappJavascriptAlertsTest extends BaseTest {

    protected HerokuappJavascriptAlertsPage javascriptAlerts = new HerokuappJavascriptAlertsPage(new Alert(), new Button(),
            new TextField());

    @Test
    public void checkExpectedAlertsIsDisplayed() {
        LOGGER.info("test checkExpectedAlertsIsDisplayed");
        browserManager.goToUrl(ConstantsAndConfig.PROTOKOL_HTTP + ConstantsAndConfig.HOST + javascriptAlerts.getPath());

        // check Alerts page is open
        Assert.assertEquals(browserManager.getCurrentUrl(), ConfigReader.getTestValue("testCase2ExpectedURL"));

        // check "I am a JS Alert" text is displayed
        javascriptAlerts.ClickForJSAlert();
        Assert.assertEquals(javascriptAlerts.getAlertText(), ConfigReader.getTestValue("testCase2ExpectedIAmAJSAlert"));

        // check "You successfully clicked an alert" text is displayed in Result section
        javascriptAlerts.accept();
        Assert.assertEquals(javascriptAlerts.getResultText(), ConfigReader.getTestValue("testCase2ExpectedResultAfterJSAlert"));

        // check “I am a JS Confirm" text is displayed
        javascriptAlerts.ClickForJSConfirm();
        Assert.assertEquals(javascriptAlerts.getAlertText(), ConfigReader.getTestValue("testCase2ExpectedIAmAJSConfirm"));

        // check "You clicked: OK” text is displayed in Result section
        javascriptAlerts.accept();
        Assert.assertEquals(javascriptAlerts.getResultText(), ConfigReader.getTestValue("testCase2ExpectedResultAfterJSConfirm"));

        // check “I am a JS prompt” alert is displayed
        javascriptAlerts.ClickForJSPrompt();
        Assert.assertEquals(javascriptAlerts.getAlertText(), ConfigReader.getTestValue("testCase2ExpectedIAmAJSPrompt"));

        // check "You entered: <random text>” text is displayed
        javascriptAlerts.sendText();
        javascriptAlerts.accept();
        Assert.assertEquals(javascriptAlerts.getResultText(), "You entered: " + javascriptAlerts.getRandomText());
    }
}