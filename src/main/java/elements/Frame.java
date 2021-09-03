package elements;

import org.openqa.selenium.WebElement;

public class Frame extends BaseElement{

    public WebElement frameByXpath(String xpath) {
        return findElementByXpath(xpath);
    }

    public WebElement frameByCss(String css) {
        return findElementByCss(css);
    }
}