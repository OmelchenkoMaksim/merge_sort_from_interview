package pages.herokuapp;

import constants.ConstantsAndConfig;
import elements.TextField;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static common.Logger.LOGGER;

public class HerokuappAuthPage extends BasePage {

    private final TextField textField;

    public HerokuappAuthPage(TextField textField) {
        this.textField = textField;
    }

    public String getPath() {
        return ConstantsAndConfig.PATH_BASIC_AUTH;
    }

    public String getAuth() {
        return ConstantsAndConfig.AUTHORISATION;
    }

    public WebElement getProperCredentials() {
        LOGGER.info("start getProperCredentials");
        return textField.textByCss("#content > div > p");
    }

    public String getStringFromElement() {
        return getProperCredentials().getText();
    }
}
