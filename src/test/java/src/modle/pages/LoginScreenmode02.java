package src.modle.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import src.modle.component.global.Bottomnav;
import src.modle.component.login.LoginFormCom;

public class LoginScreenmode02 {
    private final AppiumDriver<MobileElement> appiumDriver;
    public LoginScreenmode02(AppiumDriver<MobileElement> appiumDriver)
    {
        this.appiumDriver=appiumDriver;
    }
    public LoginScreenmode02 loginFormCom()
    {
        return new LoginScreenmode02(appiumDriver);
    }
    public Bottomnav bottomnav()
    {
        return  new Bottomnav(appiumDriver);
    }
}
