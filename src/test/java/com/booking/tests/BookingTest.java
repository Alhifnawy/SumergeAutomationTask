package com.booking.tests;

import com.booking.pages.BookingDetailsPage;
import com.booking.pages.HotelSelectionPage;
import com.booking.pages.ReservationPage;
import com.booking.pages.SearchPage;
import com.booking.utils.ExcelUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

public class BookingTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        this.driver = new ChromeDriver();
        PageFactory.initElements(this.driver, this);
        WebDriverManager.chromedriver().setup();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.booking.com/");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
    @DataProvider(name = "bookingData")
    public Object[][] getData() {
        return ExcelUtil.getTestData("Sheet1");
    }

    @Test(dataProvider = "bookingData")
    public void testBooking(String location, String checkinDate, String checkoutDate, String expectedCheckIn, String expectedCheckOut){
        SearchPage searchPage = new SearchPage(driver);
        HotelSelectionPage hotelSelectionPage = new HotelSelectionPage(driver);
        BookingDetailsPage bookingDetailsPage = new BookingDetailsPage(driver);
        ReservationPage reservationPage = new ReservationPage(driver);

        searchPage.closeSignInWindow();
        searchPage.enterLocation(location);
        searchPage.selectLocation();
        searchPage.selectDates(checkinDate, checkoutDate);
        searchPage.clickSearch();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        hotelSelectionPage.selectTolipHotel();
        Assert.assertEquals(bookingDetailsPage.getCheckinDate(), expectedCheckIn, "Check-in date mismatch");
        Assert.assertEquals(bookingDetailsPage.getCheckoutDate(), expectedCheckOut, "Check-out date mismatch");

        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        bookingDetailsPage.selectBedAndReserve();
        Assert.assertTrue(reservationPage.getHotelName().contains("Tolip Hotel Alexandria"), "Hotel name mismatch");
    }
}
