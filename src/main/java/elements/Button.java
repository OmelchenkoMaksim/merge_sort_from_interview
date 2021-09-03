package elements;

import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public WebElement buttonByXpath(String xpath) {
        return findElementByXpath(xpath);
    }

    public WebElement buttonByCss(String css) {
        return findElementByCss(css);
    }
}
