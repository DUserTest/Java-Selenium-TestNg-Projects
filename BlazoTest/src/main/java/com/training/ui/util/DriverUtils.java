package com.training.ui.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverUtils {

    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    //public  static EventFiringDecorator ee_driver;
    public static WebEventListener eventListener;

    private static Properties props;
    private static final String DRIVER_PROP_FILE = "src/main/resources/driver.properties";

    public static WebDriver getDriver(WebDriver driver, String baseUrl, String browser) throws FileNotFoundException,IOException {
        props = new Properties();
        props.load(new FileInputStream(DRIVER_PROP_FILE));

        if (isWindows()) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty(Constants.CHROME_KEY, props.getProperty(Constants.CHROME_DRIVER_WIN));
                driver = new ChromeDriver();
                e_driver = new EventFiringWebDriver(driver);
                //ee_driver = new EventFiringDecorator((WebDriverListener) driver);
                // Now create object of EventListerHandler to register it with EventFiringWebDriver
                eventListener = new WebEventListener();
                e_driver.register(eventListener);
                driver = e_driver;

                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                //Reporter.log("Invalid browser");
                System.exit(0);
            }
        } else if (isMac()) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty(Constants.CHROME_KEY, props.getProperty(Constants.CHROME_DRIVER_WIN));
                driver = new ChromeDriver();
            } else {
                // Reporter.log("Invalid browser");
                System.exit(0);
            }
        }
        driver.get(baseUrl);
        return driver;
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name");
        return os.startsWith("Windows");
    }

    private static boolean isMac() {
        String os = System.getProperty("os.name");
        return os.startsWith("Mac");
    }

}
