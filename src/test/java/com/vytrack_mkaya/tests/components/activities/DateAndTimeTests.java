package com.vytrack_mkaya.tests.components.activities;

import com.vytrack_mkaya.pages.LoginPages;
import com.vytrack_mkaya.pages.NavigateBar;
import com.vytrack_mkaya.pages.activities.CalendarEventsPage;
import com.vytrack_mkaya.pages.activities.CreateCalendarEventPage;
import com.vytrack_mkaya.tests.TestBase;
import com.vytrack_mkaya.utilities.BrowserUtils;
import com.vytrack_mkaya.utilities.ConfigurationReader;
import com.vytrack_mkaya.utilities.VerificationUtils;
import com.vytrack_mkaya.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DateAndTimeTests extends TestBase {

    @BeforeMethod
    public void setUp() {
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
    }


//    1) Date Time, End date auto adjust
//        1. Log in as Valid user
//        2. Go to Activities -> Calendar Events
//        3. Click on create new calendar event
//        4. Change the start date to future date
//        5. Verify that end date changes to the same date
//        6. Change back the start date to today’s date
//        7. Verify that end date changes back to today’s date


    @Test
    public void dateTime1() {
//        1. Log in as Valid user
        LoginPages loginPages = new LoginPages();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        loginPages.login(username, password);

//        2. Go to Activities -> Calendar Events
        VytrackUtils.waitForUIOverlay();
        NavigateBar navigateBar = new NavigateBar();

        WebElement a = navigateBar.selectTab("Activities");
        wait.until(ExpectedConditions.visibilityOf(a)).click();

        VytrackUtils.waitForUIOverlay();
        WebElement b = navigateBar.selectSubTab("Calendar Events");
        VytrackUtils.waitForUIOverlay();
        wait.until(ExpectedConditions.visibilityOf(b)).click();

//        navigateBar.selectTabs("Activities", "Calendar Events");


//        3. Click on create new calendar event
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();


        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.createCalendarEvents));
        VytrackUtils.waitForUIOverlay();
        calendarEventsPage.createCalendarEvents.click();


//        4. Change the start date to future date
        CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();

        VytrackUtils.waitForUIOverlay();
        WebElement c = createCalendarEventPage.startDateButton;
        VytrackUtils.waitForUIOverlay();
        wait.until(ExpectedConditions.visibilityOf(c)).click();

        WebElement d = createCalendarEventPage.startDay;
        wait.until(ExpectedConditions.visibilityOf(d)).click();

        String startDate = createCalendarEventPage.startDay.getText();
        System.out.println("startDate = " + startDate);
        int startdateInt = Integer.parseInt(startDate);

        VytrackUtils.waitForUIOverlay();


        WebElement e = createCalendarEventPage.endDateButton;

        wait.until(ExpectedConditions.elementToBeClickable(e));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        VytrackUtils.waitForUIOverlay();
        e.click();

        String endDay = createCalendarEventPage.endDay.getText();
        System.out.println("endDay = " + endDay);

        int endDateInt = Integer.parseInt(endDay);


//        5. Verify that end date changes to the same date

        Assert.assertEquals(startdateInt, endDateInt);

        createCalendarEventPage.today.click();

//        6. Change back the start date to today’s date

        VytrackUtils.waitForUIOverlay();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement f = createCalendarEventPage.startDateButton;

        VytrackUtils.waitForUIOverlay();
        wait.until(ExpectedConditions.visibilityOf(f)).click();


        // wait.until(ExpectedConditions.visibilityOf(f)).click();

        VytrackUtils.waitForUIOverlay();
        createCalendarEventPage.today.click();

        String todayText = createCalendarEventPage.today.getText();
        System.out.println("todayText = " + todayText);


       // wait.until(ExpectedConditions.visibilityOf(createCalendarEventPage.endDay));
//        VytrackUtils.waitForUIOverlay();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        VytrackUtils.waitForUIOverlay();
        createCalendarEventPage.endDateButton.click();
        createCalendarEventPage.today.getText();
        String endDayText = createCalendarEventPage.today.getText();
        System.out.println("endDayText = " + endDayText);
//        7. Verify that end date changes back to today’s date

        Assert.assertEquals(todayText, endDayText);

    }

}
