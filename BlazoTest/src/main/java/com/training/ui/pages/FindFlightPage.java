package com.training.ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage extends BasePage {

    @FindBy(name = "fromPort")
    WebElement departureCity;
    @FindBy(name = "toPort")
    WebElement destinationCity;
    @FindBy(xpath = "//input[@value='Find Flights']")
    WebElement findFlights;

    WebDriverWait wait;

    public FindFlightPage() {
        super();
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void flightSearch() {
        Select fromCity = new Select(departureCity);
        fromCity.selectByVisibleText("Paris");
        Select toCity = new Select(destinationCity);
        toCity.selectByVisibleText("London");
        wait = new WebDriverWait(driver, 5);
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        findFlights.click();
    }


}
