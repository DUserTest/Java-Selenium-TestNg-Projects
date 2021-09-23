package com.training.ui.pages;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.training.ui.util.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


public class BasePage {

    protected static WebDriver driver;
    protected static Properties prop;
    public EventFiringWebDriver e_driver;
    //public static WebEventListener eventListener;

    public BasePage() {

        InetAddress host = null;
        prop = new Properties();
        try {
            host = InetAddress.getLocalHost();
            if (host.getHostName().startsWith("qa")) {
                prop.load(new FileInputStream("src/main/resources/env-qa.properties"));
            } else {
                prop.load(new FileInputStream("src/main/resources/env-qa.properties"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void initialization() {
        try {
            String baseUrl = prop.getProperty("baseUrl");
            String browser = prop.getProperty("defaultBrowser");
            driver = DriverUtils.getDriver(driver, baseUrl, browser);
            long implicitWaitTimeOut = Long.parseLong(prop.getProperty("implicitWaitTime"));
            driver.manage().timeouts().implicitlyWait(implicitWaitTimeOut, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
