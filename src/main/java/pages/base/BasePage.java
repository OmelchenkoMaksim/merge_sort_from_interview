package pages.base;

import org.openqa.selenium.support.PageFactory;

import static common.DriverInit.getDriver;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }
}