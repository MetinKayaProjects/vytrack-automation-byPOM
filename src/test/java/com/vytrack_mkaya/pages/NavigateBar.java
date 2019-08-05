package com.vytrack_mkaya.pages;

import com.vytrack_mkaya.utilities.BrowserUtils;
import com.vytrack_mkaya.utilities.Driver;
import com.vytrack_mkaya.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateBar {

    public NavigateBar(){
        PageFactory.initElements(Driver.get(), this);
    }

    //Fleet
    @FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Fleet')]")
    public WebElement fleetMenu;

    @FindBy(xpath = "(//span[@class='title title-level-2'][contains(text(),'Vehicles')])[1]")
    public WebElement vehicleUnderFleet;


//Customer
    @FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Customers')]")
    public WebElement customersMenu;


//    Activities
    @FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Activities')]")
    public WebElement activitiesMenu;

    @FindBy(xpath = "//span[@class='title title-level-2'][contains(text(),'Calendar Events')]")
    public WebElement calendarEventsUnderActivities;


//    System
    @FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'System')]")
    public WebElement systemMenu;



    //span[@class='title title-level-1'][contains(text(),'Activities')]
    //span[@class='title title-level-2'][contains(text(),'Calendar Events')]

    public WebElement selectTab(String module){
        String xpathTab = "//span[@class='title title-level-1'][contains(text(),'" + module + "')]";

        return Driver.get().findElement(By.xpath(xpathTab));
    }

    public WebElement selectSubTab(String subModule){
        String xpathTab = "//span[@class='title title-level-2'][contains(text(),'"+ subModule +"')]";

        return Driver.get().findElement(By.xpath(xpathTab));
    }


    public void selectTabs(String module, String subModule){

        WebElement upTab = selectTab(module);
//        BrowserUtils.hover(upTab);
        upTab.click();

        WebElement subTab = selectSubTab(subModule);
        BrowserUtils.waitForClickablility(subTab, 10).click();


        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        if (module.equals(module)) {
            module = subModule;
        }
        wait.until(ExpectedConditions.titleContains(subModule));


//        WebElement tab = Driver.get().findElement(By.xpath(tabs));
//        BrowserUtils.waitForClickablility(By.xpath(tabs), 10);
//        tab.click();
//
//        String subtabs ="//span[@class='title title-level-2'][contains(text(),'"+ subModule +"')]";
//
//        WebElement subtab = Driver.get().findElement(By.xpath(subtabs));
//        BrowserUtils.waitForClickablility(By.xpath(subtabs), 10);
//        subtab.click();


    }





}
