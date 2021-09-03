package pages.herokuapp;

import base.BaseTest;
import common.ConfigReader;
import constants.ConstantsAndConfig;
import elements.Slider;
import org.testng.Assert;
import org.testng.annotations.Test;

import static common.Logger.LOGGER;

public class HerokuappHorizontalSliderTest extends BaseTest {

    protected HerokuappHorizontalSliderPage horizontalSlider = new HerokuappHorizontalSliderPage(new Slider());

    @Test
    public void checkExpectedSliderPageAndValue() {
        LOGGER.info("test checkExpectedSliderPageAndValue");
        browserManager.goToUrl(ConstantsAndConfig.PROTOKOL_HTTP + ConstantsAndConfig.HOST + horizontalSlider.getPath());

        // check Slider page is open
        Assert.assertEquals(browserManager.getCurrentUrl(), ConfigReader.getTestValue("testCase3ExpectedURL"));

        // check Slider have a valid value
        horizontalSlider.clickOnSlider();
        horizontalSlider.sentArrows();
        Assert.assertEquals(horizontalSlider.valueOfRange() % 0.5, 0);
    }
}