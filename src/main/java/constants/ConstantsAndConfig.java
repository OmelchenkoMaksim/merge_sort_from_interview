package constants;

import common.ConfigReader;

import java.util.Objects;

public class ConstantsAndConfig {

    // these variables store the values obtained from the configuration file
    public static String BROWSER = ConfigReader.getBrowser();
    public static String HOST = ConfigReader.getHost();
    public static String LOCAL = ConfigReader.getLocal();

    // these variables store the values obtained from the constant file
    public static String PROTOKOL_HTTP = ConfigReader.getConstantValue("PROTOKOL_HTTP");
    public static String PROTOKOL_HTTPS = ConfigReader.getConstantValue("PROTOKOL_HTTPS");

    // for test case 1
    public static String PATH_BASIC_AUTH = ConfigReader.getConstantValue("PATH_BASIC_AUTH");
    public static String AUTHORISATION = ConfigReader.getConstantValue("AUTHORISATION");

    // for test case 2
    public static String PATH_JAVASCRIPT_ALERTS = ConfigReader.getConstantValue("PATH_JAVASCRIPT_ALERTS");

    // for test case 3
    public static String PATH_HORIZONTAL_SLIDER = ConfigReader.getConstantValue("PATH_HORIZONTAL_SLIDER");

    // for test case 4
    public static String PATH_HOVERS = ConfigReader.getConstantValue("PATH_HOVERS");

    // for test case 5
    public static String PATH_IFRAME = ConfigReader.getConstantValue("PATH_IFRAME");

    // sets the implicit wait value
    public static final int IMPLICIT_WAIT = Integer.parseInt(Objects.requireNonNull(ConfigReader.getConfigValue("IMPLICIT_WAIT")));
    // sets the explicit wait value
    public static final int EXPLICIT_WAIT = Integer.parseInt(Objects.requireNonNull(ConfigReader.getConfigValue("EXPLICIT_WAIT")));
    // clear browser cookies after each iteration
    public static final Boolean CLEAR_COOKIES = Boolean.parseBoolean(ConfigReader.getConfigValue("CLEAR_COOKIES"));
    // to keep the browser open after all tests
    public static final Boolean HOLD_BROWSER_OPEN = Boolean.parseBoolean(ConfigReader.getConfigValue("HOLD_BROWSER_OPEN"));
}