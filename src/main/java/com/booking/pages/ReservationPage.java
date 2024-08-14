package com.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class ReservationPage {

    WebDriver driver;
    public ReservationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By hotelName = By.xpath("//div[contains(text(),'Tolip Hotel Alexandria')]");

    public String getHotelName() {
        WebElement hotelNameElement = driver.findElement(hotelName);

        return hotelNameElement.getText();
    }
}
