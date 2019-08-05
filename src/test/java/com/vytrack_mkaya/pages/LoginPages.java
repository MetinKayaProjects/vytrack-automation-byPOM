package com.vytrack_mkaya.pages;

import com.vytrack_mkaya.utilities.Driver;
import com.vytrack_mkaya.utilities.VytrackUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

    public LoginPages() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement usernameBox;

    @FindBy(id="prependedInput2")
    public WebElement passwordBox;

    @FindBy(id="_submit")
    public WebElement submitButton;


    public void login(String username, String password){
        usernameBox.sendKeys(username);
            VytrackUtils.waitForUIOverlay();
        passwordBox.sendKeys(password);
            VytrackUtils.waitForUIOverlay();
        submitButton.click();
    }





}
