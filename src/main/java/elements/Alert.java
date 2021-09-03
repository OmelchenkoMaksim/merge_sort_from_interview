package elements;

import static common.DriverInit.getDriver;

public class Alert extends BaseElement {

    public String getAlertText() {
        return getDriver().switchTo().alert().getText();
    }

    public void accept() {
        getDriver().switchTo().alert().accept();
    }

    public void sendKeys(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }
}