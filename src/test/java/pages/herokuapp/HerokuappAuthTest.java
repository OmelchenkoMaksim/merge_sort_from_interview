package pages.herokuapp;

import base.BaseTest;
import common.ConfigReader;
import constants.ConstantsAndConfig;
import elements.TextField;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.Logger.LOGGER;

public class HerokuappAuthTest extends BaseTest {
    protected HerokuappAuthPage auth = new HerokuappAuthPage(new TextField());

    @Test
    public void checkExpectedResult() {
        LOGGER.info("test checkExpectedResult is started");
        browserManager.goToUrl(ConstantsAndConfig.PROTOKOL_HTTP + auth.getAuth() + ConstantsAndConfig.HOST + auth.getPath());
        Assert.assertEquals(auth.getStringFromElement(), ConfigReader.getTestValue("testCase1ExpectedResult"));
    }
}