package com.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BookingDetailsPage {

    WebDriver driver;

    public BookingDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By bedSelection = By.xpath("(//*[@data-testid=\"select-room-trigger\"])[1]");
    private By reserveButton = By.xpath("//*[@class=\"bui-button__text js-reservation-button__text\"]");
    private By checkinDateDisplay = By.xpath("//*[@data-testid=\"date-display-field-start\"]");
    private By checkoutDateDisplay = By.xpath("//*[@data-testid=\"date-display-field-end\"]");



    public void selectBedAndReserve() {
        WebElement bedSelectionElement = driver.findElement(bedSelection);
        WebElement reserveButtonElement = driver.findElement(reserveButton);

        Select dropdown = new Select(bedSelectionElement);
        dropdown.selectByValue("1");
        reserveButtonElement.click();
    }

    public String getCheckinDate() {
        WebElement checkinDateDisplayElement = driver.findElement(checkinDateDisplay);

        return checkinDateDisplayElement.getText();
    }

    public String getCheckoutDate() {
        WebElement checkoutDateDisplayElement = driver.findElement(checkoutDateDisplay);

        return checkoutDateDisplayElement.getText();
    }
}
