package common;

import org.openqa.selenium.WebDriver;

public class BrowserManager {

    private final WebDriver driver;

    public BrowserManager(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void backToPrevious() {
        driver.navigate().back();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void setWindowMaxSize() {
        driver.manage().window().maximize();
    }

    public void quit() {
        driver.quit();
    }
}