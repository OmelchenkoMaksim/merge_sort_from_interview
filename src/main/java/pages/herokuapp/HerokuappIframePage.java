package pages.herokuapp;

import common.ConfigReader;
import constants.ConstantsAndConfig;
import elements.Frame;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

import static common.DriverInit.getDriver;

public class HerokuappIframePage extends BasePage {

    private final Frame frame;

    public HerokuappIframePage(Frame frame) {
        this.frame = frame;
    }

    public String getPath() {
        return ConstantsAndConfig.PATH_IFRAME;
    }

    public void selectAllText() {
        frame.frameByXpath(("//*[@class=\"tox-mbtn__select-label\"][text()='Edit']")).click();
        frame.frameByCss(("div:nth-child(3) > div > div.tox-collection__item-label")).click();
    }

    public void setTextSizeTo8() {
        frame.frameByXpath(("//*[@class=\"tox-mbtn__select-label\"][text()='Format']")).click();
        frame.frameByXpath(("//*[@class=\"tox-collection__item-label\"][text()='Font sizes']")).click();
        frame.frameByXpath(("//*[@class=\"tox-collection__item-label\"][text() = '8pt']")).click();
    }

    public void setAlignLeft() {
        if (frame.frameByXpath(("//*[@title=\"Align left\"]")).getAttribute("aria-pressed").equals("false"))
            frame.frameByXpath(("//*[@title=\"Align left\"]")).click();

    }

    public String getStyleAlignText() {
        return frame.frameByXpath(("//*[@title=\"Align left\"]")).getAttribute("aria-pressed");
    }

    public String getText() {
        return frame.frameByCss(("#tinymce > p")).getText();
    }

    public WebElement getIFrame() {
        return frame.frameByCss(("#mce_0_ifr"));
    }

    public void switcher() {
        getDriver().switchTo().frame(getIFrame());
    }

    public void newDocument() {
        frame.frameByCss(("div.tox-menubar > button:nth-child(1) > span")).click();
        frame.frameByCss(("div.tox-collection__item-label")).click();
    }

    public void parentSwitch() {
        getDriver().switchTo().parentFrame();
    }

    // используется деление на 2 что бы реализовать выделение половины текста
    public void selectHalfText() {
        Actions actions = new Actions(getDriver());
        WebElement element = frame.frameByCss(("#tinymce > p"));
        actions.moveToElement(element).build().perform();
        for (int i = 0; i < element.getText().length() / 2; i++) {
            actions.moveToElement(element).keyDown(Keys.SHIFT).sendKeys(Keys.RIGHT).build().perform();
        }
    }

    public void reset() {
        Actions actions = new Actions(getDriver());
        WebElement element = frame.frameByCss(("#tinymce > p"));
        actions.moveToElement(element).build().perform();
        for (int i = 0; i < element.getText().length(); i++) {
            actions.moveToElement(element).sendKeys(Keys.LEFT).build().perform();
        }
    }

    public void setTextSizeToConfigValue() {
        frame.frameByXpath(("//*[@class=\"tox-mbtn__select-label\"][text()='Format']")).click();
        frame.frameByXpath(("//*[@class=\"tox-collection__item-label\"][text()='Font sizes']")).click();
        frame.frameByXpath((String.format("//*[@class=\"tox-collection__item-label\"][text() = '%spt']", ConfigReader.getTestValue("setSize")))).click();
    }

    public String checkTextSize() {
        return frame.frameByCss(("#tinymce > p > span > span")).getAttribute("data-mce-style");
    }
}