package com.vytrack_mkaya.pages.activities;

import com.vytrack_mkaya.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCalendarEventPage {

    public CreateCalendarEventPage(){

        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(css = "input[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDateButton;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]/a")                         //a[.='31']
    public WebElement startDay;


    @FindBy(css = "input[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDateButton;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]/a")                     //a[.='31']
    public WebElement endDay;

    @FindBy(xpath = "//button[.='Today']")
    public WebElement today;



}
