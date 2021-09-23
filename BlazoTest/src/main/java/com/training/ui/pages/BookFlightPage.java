package com.training.ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFlightPage extends BasePage {

    @FindBy(xpath = "//input[@type='submit'][1]")
    WebElement chooseFlights;
    @FindBy(xpath = "//input[@name='inputName']")
    WebElement firstLastName;
    @FindBy(xpath = "//input[@name='address']")
    WebElement address;
    @FindBy(xpath = "//input[@name='city']")
    WebElement city;
    @FindBy(xpath = "//input[@name='state']")
    WebElement state;
    @FindBy(xpath = "//input[@name='zipCode']")
    WebElement zipCode;
    @FindBy(name = "cardType")
    WebElement cardType;
    @FindBy(xpath = "//input[@name='creditCardNumber']")
    WebElement creditCardNum;
    @FindBy(xpath = "//input[@name='creditCardMonth']")
    WebElement creditCardMonth;
    @FindBy(xpath = "//input[@name='creditCardYear']")
    WebElement creditCardYear;
    @FindBy(xpath = "//input[@name='nameOnCard']")
    WebElement nameOnCard;
    @FindBy(xpath = "//input[@value='Purchase Flight']")
    WebElement purchaseFlight;

    WebDriverWait wait;

    public BookFlightPage() {
        super();
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void chooseFlight() {
        chooseFlights.click();
        wait = new WebDriverWait(driver, 5);
        wait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        firstLastName.sendKeys("TestUser");
        address.sendKeys("Whitefield");
        city.sendKeys("Bangalore");
        state.sendKeys("Karnataka");
        zipCode.sendKeys("321234");

        Select cityDropDown = new Select(cardType);
        cityDropDown.selectByVisibleText("Visa");
        creditCardNum.sendKeys("123456789123");
        creditCardMonth.sendKeys("12");
        creditCardYear.sendKeys("2022");
        nameOnCard.sendKeys("TestUser");
        purchaseFlight.click();
    }
}
