package src.modle.component.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class Bottomnav {
    private final AppiumDriver<MobileElement> appiumDriver;
    private static final By Loginbtn= MobileBy.AccessibilityId("Login");
    public Bottomnav(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    public MobileElement loginIcon()
    {
        return appiumDriver.findElement(Loginbtn);
    }
    //method 2
    public void ClickLoginIcon()
    {
        appiumDriver.findElement(Loginbtn).click();

    }
}
