# SumergeAutomationTask

## Overview

This project contains a suite of automated tests for booking.com using Selenium WebDriver, TestNG, and Maven. The
tests cover the process of searching for a hotel, selecting it, and completing the reservation process.

## Project Structure
- **src/main/java/com/booking/pages/:** Contains Page Object Model (POM) classes for interacting with different
  pages of the booking.com site.
  - **BookingDetailsPage.java:** Page Object for the hotel booking details page.
  - **HotelSelectionPage.java:** Page Object for the hotel selection page from the search results.
  - **ReservationPage.java:** Page Object for the reservation confirmation page.
  - **SearchPage.java:** Page Object for the search page.

* **src/main/java/com/booking/utils/:** Contains utility classes.
  - **ExcelUtil.java:** Utility for reading test data from Excel files.
- **src/test/java/com/booking/tests/:** Contains TestNG test classes.
  - **BookingTest.java:** TestNG test class for the booking process.
* src/test/resources/:** Contains test data files.
  - **BookingData.xlsx:** Excel file with test data.**


## Prerequisites

Before running the tests, ensure you have the following installed:

- Java Development Kit (JDK) 11 or higher
- Maven
- ChromeDriver (or the WebDriver for your preferred browser)

## Setup

#### 1. **Clone the Repository**

```bash
git https://github.com/Alhifnawy/SumergeAutomationTask.git
```
#### 2. **Navigate to the project directory and use Maven to install the required dependencies:**
    
```bash
mvn install
```   
#### 3. **Configuration**
- Excel Data File: Update the src/test/resources/testdata/bookingdata.xlsx file with your test data if necessary.
  The file should contain the following columns:
  - Location
  - Check-in Date
  - Check-out Date
  - Expected Check-in Date
  - Expected Check-out Date

## Running the Tests
To run the test suite, execute the following Maven command:

```bash
mvn test
```
This command will compile the code, download the required dependencies, and run the TestNG tests.

## Project Configuration
- Maven Dependencies:
  - Selenium WebDriver for browser automation.
  - TestNG for test management.
  - Apache POI for reading Excel files.
  - WebDriverManager for handling WebDriver binaries.
- Test Data: The test data for the test cases is stored in an Excel file (BookingData.xlsx) under src/test/resources/.

## Running Tests from IDE
1. Import the project: Import the Maven project into your preferred IDE (e.g., IntelliJ IDEA or Eclipse).
2. Run the tests: Locate BookingTest in the test directory and run it as a TestNG test.
