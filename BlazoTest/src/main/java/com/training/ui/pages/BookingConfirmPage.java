package com.training.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingConfirmPage extends BasePage {

    @FindBy(xpath = "//table/tbody/tr[1]/td[2]")
    WebElement confirmationId;

    WebDriverWait wait;

    public BookingConfirmPage() {
        super();
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public String confirmationId() {
        return confirmationId.getText();

    }
}
