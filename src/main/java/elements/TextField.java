package elements;

import org.openqa.selenium.WebElement;

public class TextField extends BaseElement {

    public WebElement textByCss(String css) {
        return findElementByCss(css);
    }
}