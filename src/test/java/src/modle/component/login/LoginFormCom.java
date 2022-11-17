package src.modle.component.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormCom {
    private final AppiumDriver<MobileElement> appiumDriver;

    private static  final By username= MobileBy.AccessibilityId("input-email");
    private static  final By password= MobileBy.AccessibilityId("input-password");
    private static  final By loginbtn= MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormCom(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }


    public MobileElement usernameElement()
    {
        return  appiumDriver.findElement(username);
    }
    public MobileElement passwordElement()
    {
        return  appiumDriver.findElement(password);
    }
    public MobileElement btnloginElement()
    {
        return  appiumDriver.findElement(loginbtn);
    }
}
