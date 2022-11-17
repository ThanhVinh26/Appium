package src.modle.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import src.driver.AppPackage;
import src.modle.component.global.Bottomnav;
import src.modle.component.login.LoginFormCom;

public class LoginScreenmode01 {
    private final AppiumDriver<MobileElement> appiumDriver;
    public LoginScreenmode01(AppiumDriver<MobileElement> appiumDriver)
    {
        this.appiumDriver=appiumDriver;
    }
    public LoginFormCom loginFormCom()
    {
        return new LoginFormCom(appiumDriver);
    }
    public Bottomnav bottomnav()
    {
        return  new Bottomnav(appiumDriver);
    }
}
