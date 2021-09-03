package pages.herokuapp;

import base.BaseTest;
import common.ConfigReader;
import constants.ConstantsAndConfig;
import elements.Frame;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.Logger.LOGGER;

public class HerokuappIframeTest extends BaseTest {

    protected HerokuappIframePage iframe = new HerokuappIframePage(new Frame());

    @Test
    public void checkExpectedResult() {
        LOGGER.info("test checkExpectedResult is started");
        browserManager.goToUrl(ConstantsAndConfig.PROTOKOL_HTTP + ConstantsAndConfig.HOST + iframe.getPath());
        Assert.assertEquals(browserManager.getCurrentUrl(), ConfigReader.getTestValue("testCase5ExpectedURL"));

        iframe.selectAllText();
        iframe.setTextSizeTo8();

        iframe.setAlignLeft();
        Assert.assertEquals(iframe.getStyleAlignText(), ConfigReader.getTestValue("trueCheck"));

        iframe.switcher();
        iframe.reset();
        iframe.selectHalfText();
        iframe.parentSwitch();
        iframe.setTextSizeToConfigValue();
        iframe.switcher();
        Assert.assertEquals(iframe.checkTextSize(), ConfigReader.getTestValue("checkSize"));

        iframe.parentSwitch();
        iframe.newDocument();
        iframe.switcher();
        Assert.assertEquals(iframe.getText(), ConfigReader.getTestValue("finalCheck"));
    }
}