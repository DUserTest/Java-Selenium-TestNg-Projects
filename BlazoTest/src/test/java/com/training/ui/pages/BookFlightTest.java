package com.training.ui.pages;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookFlightTest extends BasePage {

    BookFlightPage bookFlightPage;
    Logger log = Logger.getLogger(BookFlightTest.class);

    public BookFlightTest() {
        super();
    }

    @BeforeClass
    public void setUp() {
        bookFlightPage = new BookFlightPage();
    }

    @Test(priority = 1)
    public void BookFlight() {
        bookFlightPage.chooseFlight();
        System.out.println("Book Flight");
        log.debug("Book Flight");
        log.info("Book Flight");


    }
}
