package com.training.ui.pages;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookingConfirmTest extends BasePage {

    BookingConfirmPage bookingConfirmPage;
    Logger log = Logger.getLogger(BookingConfirmTest.class);

    public BookingConfirmTest() {
        super();
    }

    @BeforeClass
    public void setUp() {
        bookingConfirmPage = new BookingConfirmPage();
    }

    @Test(priority = 3)
    public void GetConfirmationId() {
        String confirmId = bookingConfirmPage.confirmationId();
        System.out.println("Flight Booking Confirmed with Id=" + confirmId);
        log.debug("Flight Booking Confirmed");
        log.info("Flight Booking Confirmed");
    }
}
