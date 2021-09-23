package com.training.ui.pages;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindFlightTest extends BasePage {

    FindFlightPage findFlightPage;
    Logger log = Logger.getLogger(FindFlightTest.class);

    public FindFlightTest() {
        super();
    }

    @BeforeClass
    public void setUp() {
        findFlightPage = new FindFlightPage();
    }

    @Test(priority = 1)
    public void FindFlight() {
        findFlightPage.flightSearch();
        System.out.println("Flight Search");
        log.debug("Flight Search");
        log.info("Flight Search");

    }
}
