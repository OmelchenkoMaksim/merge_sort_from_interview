package common;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    private static String browser;
    private static String host;
    private static String local;

    static {
        Logger.LOGGER.warn("config reader start here");
        try (InputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(inputStream);
            local = (String) prop.get("local");
            host = (String) prop.get("host");
            if (host.charAt(host.length() - 1) != '/') {
                host += "/";
            }
            browser = (String) prop.get("browser");
        } catch (Exception e) {
            System.out.println("This is InputStream Exception");
            Logger.LOGGER.warn("config reader crash here");
        }
    }

    public static String getHost() {
        return host;
    }

    public static String getLocal() {
        return local;
    }

    public static String getBrowser() {
        return browser;
    }

    // для чтения тестовых данных без указания пути
    public static String getTestValue(String key) {
        Logger.LOGGER.warn("test data reader start here");
        try (InputStream inputStream = new FileInputStream("src/test/resources/test_data.properties")) {
            Properties prop = new Properties();
            prop.load(inputStream);
            return (String) prop.get(key);
        } catch (Exception e) {
            System.out.println("This is InputStream Exception");
            Logger.LOGGER.warn("test data reader crash here");
        }
        return null;
    }

    // для чтения конфигурационных данных без указания пути
    public static String getConfigValue(String key) {
        Logger.LOGGER.warn("test data reader start here");
        try (InputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(inputStream);
            return (String) prop.get(key);
        } catch (Exception e) {
            System.out.println("This is InputStream Exception");
            Logger.LOGGER.warn("test data reader crash here");
        }
        return null;
    }

    // для чтения конфигурационных данных без указания пути
    public static String getConstantValue(String key) {
        Logger.LOGGER.warn("test data reader start here");
        try (InputStream inputStream = new FileInputStream("src/main/resources/constant.properties")) {
            Properties prop = new Properties();
            prop.load(inputStream);
            return (String) prop.get(key);
        } catch (Exception e) {
            System.out.println("This is InputStream Exception");
            Logger.LOGGER.warn("test data reader crash here");
        }
        return null;
    }
}