package pages.herokuapp;

import common.RandomUtils;
import constants.ConstantsAndConfig;
import elements.Alert;
import elements.Button;
import elements.TextField;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class HerokuappJavascriptAlertsPage extends BasePage {

    private final Alert alert;
    private final Button button;
    private final TextField textField;
    private final String randomText;

    public HerokuappJavascriptAlertsPage(Alert alert, Button button, TextField textField) {
        this.alert = alert;
        this.button = button;
        this.textField = textField;
        randomText = generateRandom();
    }

    public String getRandomText() {
        return randomText;
    }

    public WebElement buttonJsAlert() {
        return button.buttonByXpath("//button[@onclick='jsAlert()']");
    }

    public WebElement buttonJsConfirm() {
        return button.buttonByXpath("//button[@onclick='jsConfirm()']");
    }

    public WebElement buttonJsPrompt() {
        return button.buttonByXpath("//button[@onclick='jsPrompt()']");
    }

    public String getPath() {
        return ConstantsAndConfig.PATH_JAVASCRIPT_ALERTS;
    }

    public void ClickForJSAlert() {
        buttonJsAlert().click();
    }

    public void ClickForJSConfirm() {
        buttonJsConfirm().click();
    }

    public void ClickForJSPrompt() {
        buttonJsPrompt().click();
    }

    public String getAlertText() {
        return alert.getAlertText();
    }

    public WebElement getResult() {
        return textField.textByCss("#result");
    }

    public String getResultText() {
        return getResult().getText();
    }

    public void accept() {
        alert.accept();
    }

    public void sendText() {
        alert.sendKeys(randomText);
    }

    private String generateRandom() {
        return RandomUtils.generateRandom();
    }
}