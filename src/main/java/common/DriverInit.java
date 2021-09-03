package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.util.Locale;

import static constants.ConstantsAndConfig.*;

public class DriverInit {

    private static WebDriver driverInstance = null;

    private DriverInit() {}

    public static WebDriver getDriver() {
        if (driverInstance == null) driverInstance = createDriver();
        return driverInstance;
    }

    // тут типа синглтон (opera, firefox, chrome, edge)
    private static WebDriver createDriver() {
        if (driverInstance == null && BROWSER.toLowerCase(Locale.ROOT).equals("chrome")
                || BROWSER.toLowerCase(Locale.ROOT).equals("google")) {
            WebDriverManager.chromedriver().setup();
            // создаем опцию смены локализации
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=" + LOCAL);
            return new ChromeDriver(options);
        }
        if (driverInstance == null && BROWSER.toLowerCase(Locale.ROOT).equals("mozilla")
                || BROWSER.toLowerCase(Locale.ROOT).equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--lang=" + LOCAL);
            return new FirefoxDriver(options);
        }
        if (driverInstance == null && BROWSER.toLowerCase(Locale.ROOT).equals("opera")) {
            WebDriverManager.operadriver().setup();
            OperaOptions options = new OperaOptions();
            options.addArguments("--lang=" + LOCAL);
            return new OperaDriver(options);
        }
        if (driverInstance == null && BROWSER.toLowerCase(Locale.ROOT).equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--lang=" + LOCAL);
            return new EdgeDriver(options);
        }
        return driverInstance;
    }
}