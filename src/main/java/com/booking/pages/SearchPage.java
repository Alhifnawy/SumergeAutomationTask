package com.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class SearchPage{
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private String inDate = "InDate";
    private String outDate = "outDate";

    private By locationInput = By.name("ss");
    private By locationSelect = By.xpath("//*[@data-testid=\"autocomplete-result\"]//*[contains(text(),'Alexandria')]");
    private By calendar = By.xpath("//*[@data-testid=\"searchbox-dates-container\"]");
    private By nextMonthButton = By.xpath("//*[@aria-label=\"Next month\"]");
    private By previousMonthButton = By.xpath("//*[@aria-label=\"Previous month\"]");
    private By CheckInDateInput;
    private By CheckOutDateInput;
    private By searchButton = By.xpath("//button[@type='submit']");
    private By LoadMoreButton = By.xpath("//span[contains(text(),'Load more results')]");
    private By dismissSignInButton = By.xpath("//*[@aria-label=\"Dismiss sign-in info.\"]");


    public void closeSignInWindow(){
        WebElement dismissSignInButtonElement = driver.findElement(dismissSignInButton);
        dismissSignInButtonElement.click();
    }

    public void enterLocation(String location) {
        WebElement LocationInputElement = driver.findElement(locationInput);
        LocationInputElement.sendKeys(location);
    }

    public void selectLocation(){
        WebElement locationSelectElement = driver.findElement(locationSelect);
        locationSelectElement.click();
    }

    public void selectDates(String checkinDate, String checkoutDate){
        inDate = checkinDate;
        outDate = checkoutDate;
        CheckInDateInput = By.xpath("//*[@aria-label=\"" +inDate+ "\"]");
        CheckOutDateInput = By.xpath("//*[@aria-label=\"" +outDate+ "\"]");

        WebElement nextMonthButtonElement = driver.findElement(nextMonthButton);
        nextMonthButtonElement.click();
        WebElement CheckInDateInputElement = driver.findElement(CheckInDateInput);
        CheckInDateInputElement.click();
        WebElement CheckOutDateInputElement = driver.findElement(CheckOutDateInput);
        CheckOutDateInputElement.click();
    }

    public void loadMoreResults(){
        WebElement LoadMoreButtonElement = driver.findElement(LoadMoreButton);
        LoadMoreButtonElement.click();
    }

    public void clickSearch() {
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
    }
}