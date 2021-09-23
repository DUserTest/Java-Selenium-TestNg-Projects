package com.training.ui.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;


public class HomePage extends BasePage {

    Logger log = Logger.getLogger(HomePage.class);
    public HomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle() {
        log.info("Blaze demo page");
        return driver.getTitle();
    }
}
