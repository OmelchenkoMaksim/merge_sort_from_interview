package pages.herokuapp;

import constants.ConstantsAndConfig;
import elements.Slider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class HerokuappHorizontalSliderPage extends BasePage {

    private final Slider slider;

    public HerokuappHorizontalSliderPage(Slider slider) {
        this.slider = slider;
    }

    public WebElement getSliderType() {
        return slider.sliderByXpath("//*[@type=\"range\"]");
    }

    public WebElement getSliderId() {
        return slider.sliderByXpath("//*[@id=\"range\"]");
    }

    public String getPath() {
        return ConstantsAndConfig.PATH_HORIZONTAL_SLIDER;
    }

    public void clickOnSlider() {
        getSliderType().click();
        getSliderType().sendKeys(Keys.ARROW_LEFT);
    }

    // выдает случайное количество передвижения ползунка вправо и влево
    public void sentArrows() {
        int l = 1 + (int) Math.round(Math.random() * 2);
        int r = 1 + (int) Math.round(Math.random() * 2);
        for (int o = 0; o <= 6; o++) {
            for (int i = 0; i <= l; i++) {
                getSliderType().sendKeys(Keys.ARROW_LEFT);
                for (int i1 = 0; i1 <= r; i1++) {
                    getSliderType().sendKeys(Keys.ARROW_RIGHT);
                }
            }
            for (int i = 0; i <= r; i++) {
                getSliderType().sendKeys(Keys.ARROW_RIGHT);
                for (int i1 = 0; i1 <= l; i1++) {
                    getSliderType().sendKeys(Keys.ARROW_LEFT);
                }
            }
        }
    }

    public double valueOfRange() {
        return Double.parseDouble(getSliderId().getText());
    }
}