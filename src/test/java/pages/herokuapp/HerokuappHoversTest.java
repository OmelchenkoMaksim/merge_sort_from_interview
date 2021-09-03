package pages.herokuapp;

import base.BaseTest;
import common.ConfigReader;
import constants.ConstantsAndConfig;
import elements.Button;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static common.Logger.LOGGER;

public class HerokuappHoversTest extends BaseTest {

    protected HerokuappHoversPage hovers = new HerokuappHoversPage(new Button());

    @DataProvider(name = "testdata")
    public Object[][] TestDataFeed() {
        Object[][] users = new Object[2][2];
        users[0][0] = ConfigReader.getTestValue("userId1");
        users[0][1] = "user" + ConfigReader.getTestValue("userId1");
        users[1][0] = ConfigReader.getTestValue("userId3");
        users[1][1] = "user" + ConfigReader.getTestValue("userId3");
        return users;
    }

    @Test(dataProvider = "testdata")
    public void checkHoversScenarioForUser(String user, String userForCheck) {
        LOGGER.info("test checkHoversScenario");
        browserManager.goToUrl(ConstantsAndConfig.PROTOKOL_HTTP + ConstantsAndConfig.HOST + hovers.getPath());

        // check Hovers page is open
        Assert.assertEquals(browserManager.getCurrentUrl(), ConfigReader.getTestValue("testCase4ExpectedURL"));

        // after Move the cursor to user label
        // check User1 name is correct and Link to profile is displayed
        hovers.navigateMouseTo(Integer.parseInt(user));
        Assert.assertEquals(hovers.getUserName(Integer.parseInt(user)), userForCheck);

        // check View profile is displayed
        Assert.assertTrue(hovers.isDisplayed(Integer.parseInt(user)));

        // go to user page and check URL
        // тест падает т.к. меняется path
        hovers.goToUser(Integer.parseInt(user));
        Assert.assertEquals(browserManager.getCurrentUrl(), ConfigReader.getTestValue("testCase4ExpectedURLUser") + user);

        // go to previous page and check URL
        browserManager.backToPrevious();
        Assert.assertEquals(browserManager.getCurrentUrl(), ConfigReader.getTestValue("testCase4ExpectedURL"));
    }
}