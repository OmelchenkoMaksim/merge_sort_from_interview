package elements;

import org.openqa.selenium.WebElement;

public class Slider extends BaseElement {

    public WebElement sliderByXpath(String xpath) {
        return findElementByXpath(xpath);
    }
}