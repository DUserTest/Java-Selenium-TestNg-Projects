package com.training.ui.pages;

import com.training.ui.extentreport.ExtentReporterNG;
import com.training.ui.util.Constants;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.log4j.Logger;


public class HomeTest extends BasePage {

    HomePage home;
    Logger log = Logger.getLogger("com.training.portal");

    public HomeTest() {
        super();
    }

    @BeforeSuite
    public void setUp() {
        initialization();
        home = new HomePage();
    }

    @Test(priority = 1)
    public void VerifyHomePage() {

        String homePageTitle = home.verifyHomePageTitle();
        Assert.assertEquals(homePageTitle, Constants.expectedTitle, "Home page title not matched");
        log.debug("Expected Title: " + Constants.expectedTitle + " and" + " Actual Title: " + homePageTitle + " are matching ");
        log.info("Expected Title: " + Constants.expectedTitle + " and" + " Actual Title: " + homePageTitle + " are matching ");
        System.out.println("Expected Title: " + Constants.expectedTitle + " and" + " Actual Title: " + homePageTitle + " are matching ");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
