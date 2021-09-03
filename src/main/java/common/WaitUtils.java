package common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void coffeeBreak(int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        wait.until(ExpectedConditions.urlContains(driver.getCurrentUrl()));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("hmmm")));
        } catch (TimeoutException ignored) {
        }
    }
}
