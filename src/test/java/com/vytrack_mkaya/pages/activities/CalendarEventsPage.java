package com.vytrack_mkaya.pages.activities;

import com.vytrack_mkaya.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage {

    public CalendarEventsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "a[title='Create Calendar event']")
    public WebElement createCalendarEvents;

}
