package pages.herokuapp;

import constants.ConstantsAndConfig;
import elements.Button;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static elements.BaseElement.navigateMouse;

public class HerokuappHoversPage extends BasePage {

    private final Button button;

    public HerokuappHoversPage(Button button) {
          this.button = button;
    }
    public String getPath() {
        return ConstantsAndConfig.PATH_HOVERS;
    }

    public WebElement goTo(int userId) {
        String selector = String.format("//*[@id=\"content\"]/div/div[%d]/div/a", userId);
        return button.buttonByXpath(selector);
    }

    public WebElement photo(int userId) {
        String selector = String.format("div:nth-child(%d) > img", 2 + userId);
        return button.buttonByCss(selector);
    }

    public WebElement getUser(int userId) {
        String selector = String.format("div:nth-child(%d) > div > h5", 2 + userId);
        return button.buttonByCss(selector);
    }

    // получаемая строка имеет формат "name: user1" где первая часть не нужна, потому берем вторую часть
    public String getUserName(int userId) {
        return getUser(userId).getText().split(" ")[1];
    }

    public Boolean isDisplayed(int userId) {
        return getUser(userId).isDisplayed();
    }

    public void goToUser(int userId) {
        goTo(userId).click();
    }

    public void navigateMouseTo(int userId) {
        navigateMouse().moveToElement(photo(userId)).perform();
    }
}