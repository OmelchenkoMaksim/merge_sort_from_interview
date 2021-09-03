package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static common.DriverInit.getDriver;

public abstract class BaseElement {

    public BaseElement() {
        PageFactory.initElements(getDriver(), this);
    }

    public static WebElement findElementByCss(String selector) {
        return getDriver().findElement(By.cssSelector(selector));
    }

    public static WebElement findElementByXpath(String selector) {
        return getDriver().findElement(By.xpath(selector));
    }

    public static Actions navigateMouse() {
        return new Actions(getDriver());}
}
