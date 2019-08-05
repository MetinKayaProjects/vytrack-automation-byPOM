package com.vytrack_mkaya.tests.components.login_navigation;

import com.vytrack_mkaya.pages.LoginPages;
import com.vytrack_mkaya.tests.TestBase;
import com.vytrack_mkaya.utilities.BrowserUtils;
import com.vytrack_mkaya.utilities.ConfigurationReader;
import com.vytrack_mkaya.utilities.VytrackUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void setUp(){
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
    }

    @Test
    public void loginTestMethod(){
        LoginPages loginPages = new LoginPages();

        String usernameStr = ConfigurationReader.get("driver_username");
        String passwordStr = ConfigurationReader.get("driver_password");
        loginPages.login(usernameStr, passwordStr);
    }




}
