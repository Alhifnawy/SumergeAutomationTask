package com.booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class HotelSelectionPage {
    WebDriver driver;
    public HotelSelectionPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tolipHotelLink = By.xpath("//div[contains(text(),'Tolip Hotel Alexandria')]");
    private By seeAvailabilityButton = By.xpath("//button[contains(text(),'See availability')]");

    public void selectTolipHotel() {
        WebElement tolipHotelLinkElement = driver.findElement(tolipHotelLink);

        tolipHotelLinkElement.click();
    }

    public void clickSeeAvailability() {
        WebElement seeAvailabilityButtonElement = driver.findElement(seeAvailabilityButton);

        seeAvailabilityButtonElement.click();
    }
}
